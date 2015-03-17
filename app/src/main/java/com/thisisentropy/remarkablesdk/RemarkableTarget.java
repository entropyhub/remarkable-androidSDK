package com.thisisentropy.remarkablesdk;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.thisisentropy.remarkablesdk.Cache.SimpleDiskCache;

import java.io.OutputStream;


public class RemarkableTarget implements Target {
    private RemarkableManager.onImageLoadedListener listener;
    private String url;
    private SimpleDiskCache cache;
    public RemarkableTarget(String url, RemarkableManager.onImageLoadedListener list, SimpleDiskCache cache)
    {
        this.url = url;
        this.listener = list;
        this.cache = cache;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public void setReturnListener(RemarkableManager.onImageLoadedListener list)
    {
        this.listener = list;
    }
    public RemarkableManager.onImageLoadedListener getImageLoadedListener()
    {
        return this.listener;
    }

    @Override
    public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    OutputStream out = cache.openStream(getUrl());
                    bitmap.compress(Bitmap.CompressFormat.PNG, 75, out);
                    out.close();

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        };
        thread.start();
        if (getImageLoadedListener() != null) {
            getImageLoadedListener().onImageLoaded(bitmap);
        }

    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        if (getImageLoadedListener() != null) {
            getImageLoadedListener().onImageLoadFailed();
        }
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {

    }
}
