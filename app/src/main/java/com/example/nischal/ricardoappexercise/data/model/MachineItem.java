package com.example.nischal.ricardoappexercise.data.model;

import com.example.nischal.ricardoappexercise.util.CommonUtils;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class MachineItem extends RealmObject implements Cloneable {
    @PrimaryKey
    private String localId;
    private int id;
    private String serviceName;
    private boolean isSelected;
    private String createdAt;
    private String updatedAt;
    private boolean syncStatus;

    RealmList<ServiceItemActions> serviceItemAction;

    RealmList<MachineItemPart> serviceItemParts;

    @LinkingObjects("machineItem")
    private final RealmResults<ServiceItem> serviceItems = null;

    @LinkingObjects("serviceItems")
    private final RealmResults<Machine> machine = null;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public RealmList<ServiceItemActions> getServiceItemAction() {
        return serviceItemAction;
    }

    public void setServiceItemAction(RealmList<ServiceItemActions> serviceItemAction) {
        this.serviceItemAction = serviceItemAction;
    }

    public RealmList<MachineItemPart> getServiceItemParts() {
        return serviceItemParts;
    }

    public void setServiceItemParts(MachineItemPart serviceItemParts) {
        if (this.serviceItemParts != null) {
            this.serviceItemParts.add(serviceItemParts);
        } else {
            this.serviceItemParts = new RealmList<>();
            this.serviceItemParts.add(serviceItemParts);
        }
    }

    public void setServiceItemParts(RealmList<MachineItemPart> machineParts) {
        if (this.serviceItemParts != null) {
            this.serviceItemParts.addAll(machineParts);
        } else {
            this.serviceItemParts = new RealmList<>();
            this.serviceItemParts = machineParts;
        }
    }

    public void setMachineItemParts(RealmList<MachineItemPart> machineItemParts) {

        for (int i = 0; i < machineItemParts.size(); i++) {
            MachineItemPart part = this.serviceItemParts.where().equalTo("localId", machineItemParts.get(i).getLocalId()).findFirst();
            if (part != null) {
                part.setName(machineItemParts.get(i).getName());
                part.setSyncStatus(machineItemParts.get(i).isSyncStatus());
                part.setImages(machineItemParts.get(i).getImages());
                part.setComment(machineItemParts.get(i).getComment());
                part.setUpdatedAt(machineItemParts.get(i).getUpdatedAt());

            } else {
                this.serviceItemParts.add(machineItemParts.get(i));
            }
        }
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = CommonUtils.getCurrentDateTimeString();
        ;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUpdatedAt() {
        this.createdAt = CommonUtils.getCurrentDateTimeString();
        ;
    }

    public RealmResults<ServiceItem> getServiceItems() {
        return serviceItems;
    }

    public RealmResults<Machine> getMachine() {
        return machine;
    }

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


}
