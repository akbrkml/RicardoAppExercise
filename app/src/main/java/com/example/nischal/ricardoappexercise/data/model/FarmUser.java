package com.example.nischal.ricardoappexercise.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Amir on 25/04/2018.
 */

public class FarmUser extends RealmObject {

    @PrimaryKey
    private Integer id;
    private Integer type;
    private User userDb;
    private Integer farmId;
    private Integer userId;
    private Integer managing;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFarmId() {
        return farmId;
    }

    public void setFarmId(Integer farmId) {
        this.farmId = farmId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getManaging() {
        return managing;
    }

    public void setManaging(Integer managing) {
        this.managing = managing;
    }

    public Integer getId() {
        return id;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public User getUserDb() {
        return userDb;
    }

    public void setUserDb(User userDb) {
        this.userDb = userDb;
    }


}
