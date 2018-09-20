package com.example.nischal.ricardoappexercise.data.model;

import com.example.nischal.ricardoappexercise.util.CommonUtils;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Image extends RealmObject {

    @PrimaryKey
    private String localId;
    private int id;
    private String imagePath;
    private int imageType;
    private boolean syncStatus;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;



    @LinkingObjects("images")
    private final RealmResults<Machine> machines = null;

    @LinkingObjects("images")
    private final RealmResults<MachineItemPart> machinesPart = null;

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageType() {
        return imageType;
    }

    public void setImageType(int imageType) {
        this.imageType = imageType;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public RealmResults<Machine> getMachines() {
        return machines;
    }

    public RealmResults<MachineItemPart> getMachinesPart() {
        return machinesPart;
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
}
