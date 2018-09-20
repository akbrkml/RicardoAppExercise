package com.example.nischal.ricardoappexercise.data.model;


import com.example.nischal.ricardoappexercise.util.CommonUtils;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class Service extends RealmObject implements Cloneable {
    @PrimaryKey
    private String localId;

    private int id;
    private String reading;
    private int readingUnit;
    private String serviceDate;
    private int isDeleted;
    private boolean syncStatus;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String notes;
    private Date serviceDateTime;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }


    private RealmList<ServiceItem> items;


    @LinkingObjects("serviceDbs")
    private final RealmResults<Machine> detailsDb = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReading() {
        return reading;
    }

    public void setReadingUnit(String readingUnit) {
        if (readingUnit.equalsIgnoreCase("kms"))
            this.readingUnit = 1;
        else if (readingUnit.equalsIgnoreCase("miles"))
            this.readingUnit = 3;
        else
            this.readingUnit = 2;
    }

    public void setReadingUnit(int readingUnit) {
        this.readingUnit = readingUnit;
    }

    public String getReadingUnit() {
        if (this.readingUnit == 1)
            return "kms";
        else if (this.readingUnit == 2)
            return "hrs";
        else
            return "miles";
    }

    public int getReadintUnitInt() {
        return this.readingUnit;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public RealmResults<Machine> getDetailsDb() {
        return detailsDb;
    }

    public RealmList<ServiceItem> getItems() {
        return items;
    }

    public void setItems(RealmList<ServiceItem> items) {
        this.items = items;
    }

    public void setItems(ServiceItem items) {
        if (this.items == null) {
            this.items = new RealmList<>();
            this.items.add(items);
        } else {
            this.items.add(items);
        }

    }

    public void setServiceItems(RealmList<ServiceItem> items) {
        this.items = new RealmList<>();
        for (ServiceItem serviceitem : items) {
//            AppLog.d("Sizes", serviceitem.getMachineItem().getServiceName() + " size of parts " + serviceitem.getItemParts().size());
            ServiceItem serviceItem = new ServiceItem();
            for (MachineItemPart parts : serviceitem.getItemParts()) {

            }
        }


    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt = CommonUtils.getCurrentDateTimeString();
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = CommonUtils.getCurrentDateTimeString();
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Date getServiceDateTime() {
        return serviceDateTime;
    }

    public void setServiceDateTime(Date serviceDateTime) {
        this.serviceDateTime = serviceDateTime;
    }
}
