package com.example.nischal.ricardoappexercise.data.model;

import com.example.nischal.ricardoappexercise.util.CommonUtils;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Amir on 17/05/2018.
 */

public class MachineFarm extends RealmObject {

    @PrimaryKey
    private String localid;
    private int id;
    private int type;
    private Farm farmDb;
    private boolean syncStatus;
    @LinkingObjects("machineFarms")
    private final RealmResults<Machine> machines=null;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private Integer shareBy;

    public Integer getShareBy() {
        return shareBy;
    }

    public void setShareBy(Integer shareBy) {
        this.shareBy = shareBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = CommonUtils.getCurrentDateTimeString();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = CommonUtils.getCurrentDateTimeString();
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Machine getMachines() {
        return machines.get(0);
    }

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getLocalid() {
        return localid;
    }

    public void setLocalid(String localid) {
        this.localid = localid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Farm getFarmDb() {
        return farmDb;
    }

    public void setFarmDb(Farm farmDb) {
        this.farmDb = farmDb;
    }
}
