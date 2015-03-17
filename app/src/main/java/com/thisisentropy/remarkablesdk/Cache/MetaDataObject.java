package com.thisisentropy.remarkablesdk.Cache;

import com.google.gson.annotations.Expose;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MetaDataObject {

    @Expose
    private String status;
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @Expose
    private String message;
    @SerializedName("release_name")
    @Expose
    private String releaseName;
    @SerializedName("bundle_version")
    @Expose
    private String bundleVersion;
    @SerializedName("last_update")
    @Expose
    private String lastUpdate;
    @SerializedName("last_update_timestamp")
    @Expose
    private String lastUpdateTimestamp;

    /**
     * @return The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return The statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode The status_code
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return The releaseName
     */
    public String getReleaseName() {
        return releaseName;
    }

    /**
     * @param releaseName The release_name
     */
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    /**
     * @return The bundleVersion
     */
    public String getBundleVersion() {
        return bundleVersion;
    }

    /**
     * @param bundleVersion The bundle_version
     */
    public void setBundleVersion(String bundleVersion) {
        this.bundleVersion = bundleVersion;
    }

    /**
     * @return The lastUpdate
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate The last_update
     */
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * @return The lastUpdateTimestamp
     */
    public String getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * @param lastUpdateTimestamp The last_update_timestamp
     */
    public void setLastUpdateTimestamp(String lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

}