package com.thisisentropy.remarkablesdk.RealmObjects;

import io.realm.RealmObject;

/**
 * Created by joe on 04/03/15.
 */
public class RemarkableJSONCacheDB extends RealmObject{

    private String last_update_timestamp;
    private String cacheString;

    public String getCacheString() {
        return cacheString;
    }

    public void setCacheString(String cacheString) {
        this.cacheString = cacheString;
    }

    public String getLast_update_timestamp() {
        return last_update_timestamp;
    }

    public void setLast_update_timestamp(String last_update_timestamp) {
        this.last_update_timestamp = last_update_timestamp;
    }
}
