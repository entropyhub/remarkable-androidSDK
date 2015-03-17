package com.thisisentropy.remarkablesdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.thisisentropy.remarkablesdk.Cache.MetaDataObject;
import com.thisisentropy.remarkablesdk.Cache.SimpleDiskCache;
import com.thisisentropy.remarkablesdk.RealmObjects.RemarkableJSONCacheDB;


import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RemarkableManager {
    private static RemarkableManager uniqInstance;
    private static Boolean isDraft = false;
    private static String apiKey = null;
    private static String appID = null;
    private static SimpleDiskCache tcache;
    private static Boolean isInitialised = false;

    private Context context;
    private SimpleDiskCache cache;
    private Realm realm;
    private String deviceID;
    private String baseContentURL = "https://data.useremarkable.com/api/v1/c/";
    private String baseMetaURL = "https://data.useremarkable.com/api/v1/m/";
    private String contentURL = "";
    private String metaURL = "";
    private onRemarkableCacheCompleteListener remarkableCacheCompleteListener;
    private List<RemarkableTarget> targets;
    private onImageLoadedListener imageLoadedListener;

    public interface onRemarkableCacheCompleteListener {
        /**
         * The Remarkable Data is now available to use, will be faster when data already cached
         */
        public void remarkableCacheComplete();

        /**
         * Will be called when unable to get RemarkableData, usually because the JSON is malformed.
         *
         * @param code HTTP Error code
         * @param msg  Error message
         */
        public void remarkableCacheFailed(Integer code, String msg);
    }

    public interface onImageLoadedListener {
        /**
         * Image loaded notification with image Bitmap, can either be new or from cache.
         *
         * @param bitmap The bitmap for requested image.
         */
        public void onImageLoaded(Bitmap bitmap);

        /**
         * Called when an image failed to load, usually due to connection error or missing image.
         */
        public void onImageLoadFailed();
    }


    /**
     * Set the listener with which to receive CacheComplete notifications, will still be called if data already cached
     *
     * @param listener Listener to receive notification when Remarkable data is available.
     */
    public void setRemarkableCacheCompleteListener(onRemarkableCacheCompleteListener listener) {
        remarkableCacheCompleteListener = listener;
        setCachedJSON(false);
    }



    private RemarkableManager() {
    }

    /**
     * @param Version The current version of the disk cache
     * @param con     The current context
     * @return SimpleDiskCache
     */
    private static synchronized SimpleDiskCache getDiskCache(int Version, Context con) {
        if (tcache == null) {
            try {
                tcache = SimpleDiskCache.open(con.getFilesDir(), Version, 20000000);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tcache;
    }

    /**
     * Get a singleton instance of the Remarkable Manager
     *
     * @return RemarkableManager Instance
     */
    public static synchronized RemarkableManager getInstance() {

        if (uniqInstance == null) {
            uniqInstance = new RemarkableManager();
        }
        return uniqInstance;
    }

    /**
     * Set whether we should use the Draft Bundle set in the Remarkable control panel
     *
     * @param isDraft Should use Draft Bundle Boolean
     * @return RemarkableManager
     */
    public RemarkableManager setDraftMode(Boolean isDraft) {
        this.isDraft = isDraft;
        RLog.e("Draft mode enabled: " + String.valueOf(this.isDraft));
        return this;
    }

    /**
     * Set whether to show logging info
     * @param isEnabled Is Debugging Enabled
     * @return RemarkableManager Instance
     */
    public RemarkableManager setLoggingEnabled(Boolean isEnabled)
    {
        RLog.setIsLoggingEnabled(isEnabled);
        return this;
    }

    private String getDeviceID(Context con) {
        String ID = DeviceIDFactory.getID(realm, con);
        RLog.e("Anon Device ID: " + ID);
        return ID;
    }

    /**
     * Get the cached remarkable data, if no cache available, download.
     *
     * @return Map of objects in Remarkable JSON response
     */
    public RemarkableMap<String, Object> getRemarkable() {

        String json = getCachedJSON().getCacheString();

        Map<String, Object> map = new Gson().fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
        if (map != null && map.size() > 0) {
            return new RemarkableMap<String, Object>((Map<String, Object>) map);
        } else {
            if (remarkableCacheCompleteListener != null) {
                remarkableCacheCompleteListener.remarkableCacheFailed(400, "Failed to parse remarkable data");
            }
            return null;
        }
    }

    /**
     * Initialise Remarkable with Keys
     *
     * @param con       The current context
     * @param secretKey Remarkable Secret Key
     * @param appToken  Remarkable APP Token
     * @return Current RemarkableManager Instance
     */
    public RemarkableManager initialise(Context con, String secretKey, String appToken) {
        targets = new ArrayList<>();
        apiKey = secretKey;
        appID = appToken;
        realm = Realm.getInstance(con);
        deviceID = getDeviceID(con);
        contentURL = baseContentURL + appID + "/" + apiKey + ".json?platform=android&device_id=" + deviceID + "&draft=" + String.valueOf(isDraft);
        metaURL = baseMetaURL + appID + "/" + apiKey + ".json?platform=android&device_id=" + deviceID + "&draft=" + String.valueOf(isDraft);
        context = con;
        cache = getDiskCache(getVersion(), con);
        try {
        } catch (ClassCastException e) {
            throw new ClassCastException("Activity must implement RemarkableCallbacks.");
        }
        isInitialised = true;
        return this;
    }

    private RemarkableJSONCacheDB getCachedJSON() {
        RealmQuery<RemarkableJSONCacheDB> query = realm.where(RemarkableJSONCacheDB.class);
        final RealmResults<RemarkableJSONCacheDB> result = query.findAll();
        if (result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    private RemarkableJSONCacheDB setCachedJSON(final Boolean forceRefresh) {

        Boolean hasCache = false;
        RealmQuery<RemarkableJSONCacheDB> query = realm.where(RemarkableJSONCacheDB.class);
        final RealmResults<RemarkableJSONCacheDB> result = query.findAll();
        if (result.size() > 0) {
            if (NetworkUtil.getConnectivityStatus(context) == NetworkUtil.TYPE_NOT_CONNECTED) {
                if (remarkableCacheCompleteListener != null) {
                    remarkableCacheCompleteListener.remarkableCacheComplete();
                }
                return result.get(0);
            } else {
                hasCache = true;
            }

        }

        new OkHttpClient().newCall(new Request.Builder().url(metaURL).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
                if (remarkableCacheCompleteListener != null) {
                    remarkableCacheCompleteListener.remarkableCacheFailed(null, "Meta Data Request canceled, connectivity problem or timeout.");
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {
                final Response r = response;
                final String meta_json = r.body().string();
                final Handler mainHandler = new Handler(Looper.getMainLooper());
                final Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {

                        final MetaDataObject new_meta = new Gson().fromJson(meta_json, MetaDataObject.class);
                        if (new_meta.getStatusCode() != 200) {
                            if (remarkableCacheCompleteListener != null) {
                                remarkableCacheCompleteListener.remarkableCacheFailed(new_meta.getStatusCode(), new_meta.getMessage());
                            }
                            return;
                        }

                        if (shouldReplaceCache(new_meta.getLastUpdateTimestamp(), result) || forceRefresh == true) {

                            RLog.e("Data has been changed on server, replacing cached Remarkable Data");
                            new OkHttpClient().newCall(new Request.Builder().url(contentURL).build()).enqueue(new Callback() {
                                @Override
                                public void onFailure(Request request, IOException e) {
                                    e.printStackTrace();
                                    if (remarkableCacheCompleteListener != null) {
                                        remarkableCacheCompleteListener.remarkableCacheFailed(null, "Content Request canceled, connectivity problem or timeout.");
                                    }
                                }

                                @Override
                                public void onResponse(Response response) throws IOException {
                                    final Response r = response;
                                    final String json = r.body().string();
                                    Handler mainHandler = new Handler(context.getMainLooper());
                                    mainHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            RLog.e("Content request succeeded attempting to save to cache");
                                            setupJSONCache(new_meta.getLastUpdateTimestamp(), json);
                                        }
                                    });
                                }
                            });

                        } else {
                            RLog.e("Using Cached Remarkable Data");
                            if (remarkableCacheCompleteListener != null) {
                                remarkableCacheCompleteListener.remarkableCacheComplete();
                            }
                        }

                    }
                };
                mainHandler.post(myRunnable);

            }
        });
        return null;
    }

    private String setupJSONCache(String last_update_ts, String json) {

        RealmQuery<RemarkableJSONCacheDB> query = realm.where(RemarkableJSONCacheDB.class);
        RealmResults<RemarkableJSONCacheDB> result = query.findAll();
        if (result.size() > 0) {
            RLog.e("Cache already present, replacing");
            realm.beginTransaction();
            result.get(0).setLast_update_timestamp(last_update_ts);
            result.get(0).setCacheString(json);
            realm.commitTransaction();

        } else {
            RLog.e("Cache empty, saving values");
            realm.beginTransaction();
            RemarkableJSONCacheDB db = realm.createObject(RemarkableJSONCacheDB.class);
            db.setLast_update_timestamp(last_update_ts);
            db.setCacheString(json);
            realm.commitTransaction();
        }
        if (remarkableCacheCompleteListener != null) {
            remarkableCacheCompleteListener.remarkableCacheComplete();
        }

        return json;

    }

    private Boolean shouldReplaceCache(String new_timestamp, RealmResults<RemarkableJSONCacheDB> db) {
        if (db.size() > 0) {
            double new_ts = Double.parseDouble(new_timestamp);
            double cache_ts = Double.parseDouble(db.get(0).getLast_update_timestamp());
            if (new_ts > cache_ts) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

    private int getVersion() {
        try {
            PackageInfo pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return pInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    /**
     * Refresh all cached Remarkable Objects, Replaces cache
     */
    public void refreshAllObjects() {

        if (isInitialised == false) {
            throw new RuntimeException("Remarkable: initialise has not been called");
        } else {
            setCachedJSON(true);
        }

    }

    /**
     * Requests an image by URL. Will return a cached version if available or download and notify.
     *
     * @param url Image URL
     * @return RemarkableManager instance
     */
    public void requestImageForURL(String url, onImageLoadedListener list) {

        RLog.e("Requesting Image for URL: " + url);

        try {
            if (cache.getBitmap(url) != null) {
                RLog.e("Requested image is in cache");
                if (list != null) {
                    list.onImageLoaded(cache.getBitmap(url).getBitmap());
                } else {
                    throw new RuntimeException("ImageLoadedListener is NULL");
                }
            } else {
                RLog.e("Requested image is NOT in cache, requesting new.");
                if (list != null) {
                    loadWithPicasso(list, url);
                } else {
                    throw new RuntimeException("ImageLoadedListener is NULL");
                }
            }
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void loadWithPicasso(onImageLoadedListener listener, String url) {
        Picasso.with(context).setLoggingEnabled(true);
        RemarkableTarget target = new RemarkableTarget(url, listener, cache);
        targets.add(target);
        Picasso.with(context).load(url).placeholder(R.drawable.ic_launcher).into(target);
    }






}
