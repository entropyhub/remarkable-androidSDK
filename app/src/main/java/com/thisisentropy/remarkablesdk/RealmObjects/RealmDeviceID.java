package com.thisisentropy.remarkablesdk.RealmObjects;

import io.realm.RealmObject;

/**
 * Created by joe on 28/02/15.
 */
public class RealmDeviceID extends RealmObject {
    public String getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(String deviceID) {
        DeviceID = deviceID;
    }

    private String DeviceID;

}
