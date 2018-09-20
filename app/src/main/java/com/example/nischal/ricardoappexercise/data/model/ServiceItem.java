package com.example.nischal.ricardoappexercise.data.model;

import com.example.nischal.ricardoappexercise.util.CommonUtils;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class ServiceItem extends RealmObject {
    @PrimaryKey
    private String localId;
    private int id;
    private MachineItem machineItem;
    private int createdBy;
    private String createdAt;
    private String updatedAt;


    private String deletedAt;
    private RealmList<ServiceItemActions> itemActions;
    private RealmList<MachineItemPart> itemParts;
    private boolean syncStatus;

    @LinkingObjects("items")
    private final RealmResults<Service> serviceDbs = null;

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public MachineItem getMachineItem() {
        return machineItem;
    }

    public void setMachineItem(MachineItem machineItem) {
        this.machineItem = machineItem;
    }

    public RealmList<ServiceItemActions> getItemActions() {
        return itemActions;
    }

    public void setItemActions(ServiceItemActions itemActions) {
        if (this.itemActions != null)
            this.itemActions.add(itemActions);
        else {
            this.itemActions = new RealmList<>();
            this.itemActions.add(itemActions);
        }
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public void setItemActionList(RealmList<ServiceItemActions> itemActions) {
        if (this.itemActions != null)
            this.itemActions.addAll(itemActions);
        else {
            this.itemActions = new RealmList<>();
            this.itemActions.addAll(itemActions);
        }
    }

    public RealmList<MachineItemPart> getItemParts() {
        return itemParts;
    }

    public void setItemParts(RealmList<MachineItemPart> itemParts) {
        this.itemParts = itemParts;
    }

    public void setItemParts(MachineItemPart machineItemPartDb) {
        if (this.itemParts == null) {
            this.itemParts = new RealmList<>();
            this.itemParts.add(machineItemPartDb);
        } else {
            this.itemParts.add(machineItemPartDb);
        }
    }

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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
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

    public RealmResults<Service> getServiceDbs() {
        return serviceDbs;
    }

    public void setItemActionLists(RealmList<ServiceItemActions> itemActions) {
        if (itemActions != null && itemActions.size() > 0) {
            this.itemActions = new RealmList<>();
            this.itemActions.addAll(itemActions);
        }
    }
}
