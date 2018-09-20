package com.example.nischal.ricardoappexercise.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MachineOrder extends RealmObject {

    @PrimaryKey
    private String localId;
    private int userId;
    private int order;

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
