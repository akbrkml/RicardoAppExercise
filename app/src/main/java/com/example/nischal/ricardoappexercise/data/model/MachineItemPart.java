package com.example.nischal.ricardoappexercise.data.model;

import com.example.nischal.ricardoappexercise.util.CommonUtils;
import java.io.Serializable;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class MachineItemPart extends RealmObject implements Serializable {

    @PrimaryKey
    private String localId;
    private int id;
    private String comment;
    private String name;
    private RealmList<Image> images;
    private Integer createdBy;
    private String createdAt;
    private String updatedAt;
    private boolean syncStatus;

    @LinkingObjects("serviceItemParts")
    private final RealmResults<MachineItem> machineItems = null;

    @LinkingObjects("itemParts")
    private final RealmResults<ServiceItem> serviceItems = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public RealmResults<MachineItem> getMachineItems() {
        return machineItems;
    }

    public RealmResults<ServiceItem> getServiceItems() {
        return serviceItems;
    }

    public RealmList<Image> getImages() {
        return images;
    }

    public void setImages(RealmList<Image> images) {
        this.images = new RealmList<>();
        this.images.addAll(images);
    }

    public void setImages(Image images) {
        if (this.images == null) {
            this.images = new RealmList<>();
            this.images.add(images);
        }else{
            this.images.add(images);
        }
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = CommonUtils.getCurrentDateString();
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public void setUpdatedAt() {
        this.updatedAt = CommonUtils.getCurrentDateString();


    }

    public void setPartImages(RealmList<Image> images) {
        this.images = images;
    }
}
