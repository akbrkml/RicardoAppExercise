package com.example.nischal.ricardoappexercise.data.model;

import android.util.Log;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Utsab on 3/12/2018.
 */

public class Farm extends RealmObject {


    @PrimaryKey
    private Integer id;

    private String farmName;



    private RealmList<FarmUser> farmUsers;
    private RealmList<User> userList;
    private long userId;
    private Integer managing;
    private String updatedAt;
    private Integer managerId;
    private RealmList<Machine> machinesList;

    public Integer getManagerId() {
        return managerId;
    }



    public RealmList<FarmUser> getFarmUsers() {
        return farmUsers;
    }




    public void setFarmUsers(RealmList<FarmUser> farmUsers) {
        this.farmUsers = farmUsers;
    }

    public void addMachinde(Machine machine){
        if (this.machinesList != null)
            this.machinesList.add(machine);
        else{
            this.machinesList = new RealmList<>();

            this.machinesList.add(machine);
        }
    }

    public void addFarmUsers(FarmUser farmUserDb){
        if(this.farmUsers!=null){
            this.farmUsers.add(farmUserDb);
        }else{
            this.farmUsers = new RealmList<>();
            this.farmUsers.add(farmUserDb);
        }
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public RealmList<User> getUserList() {
        return userList;
    }


    public void setUserList(RealmList<User> userList) {
        this.userList = userList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Integer getManaging() {
        return managing;
    }

    public void setManaging(Integer managing) {
        this.managing = managing;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserList(User userList) {
        if (this.userList != null)
            this.userList.add(userList);
        else{
            this.userList = new RealmList<>();
            this.userList.add(userList);
        }

    }


    public Integer getFarmId() {
        return id;
    }

    public void setFarmId(Integer id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public RealmList<Machine> getMachinesList() {
        return machinesList;
    }

    public void setMachinesList(RealmList<Machine> machinesList) {
        this.machinesList = machinesList;
    }


    public User getMainManagingOperator(){
        FarmUser farmUserDbs = this.farmUsers.where().equalTo("type",2).findFirst();
        if(farmUserDbs!=null){
            return this.farmUsers.where().equalTo("type",2).findFirst().getUserDb();
        }else{
            return this.farmUsers.where().equalTo("type",1).findFirst().getUserDb();

        }
    }

    public User getMainManagerForSingleFarm(){

        return this.farmUsers.where().equalTo("type",1).findFirst().getUserDb();
    }

    public RealmResults<FarmUser> getOtherOperators(){
        RealmResults<FarmUser> farmUserDbs = this.farmUsers.where().equalTo("type",3).or().equalTo("type",4).findAll();
        Log.d("famruserdbssize",farmUserDbs.size()+"");
        return farmUserDbs;

    }

    public RealmResults<FarmUser> getOtherOperatorsExceptOneself(int id){
        RealmResults<FarmUser> farmUserDbs = this.farmUsers.where().equalTo("type",3).or().equalTo("type",4).findAll();
        Log.d("id",id+"");
        RealmResults<FarmUser> filterFarmUsers = farmUserDbs.where().notEqualTo("userDb.status",3).findAll();
        Log.d("famruserdbssize",farmUserDbs.size()+"");
        Log.d("fiiltersize",filterFarmUsers.size()+"");
        return filterFarmUsers;

    }


    public User getOperatorWithId(Integer id){
        return this.farmUsers.where().equalTo("userDb.id",id).findFirst().getUserDb();
    }

    public FarmUser getFarmUserWithOperatorId(int id){
        return this.farmUsers.where().equalTo("userDb.id",id).findFirst();
    }

    public User getMainManagingOperators(){
        for(int i = 0 ; i< this.farmUsers.size(); i++){
            if(this.farmUsers.get(i).getType()==2){
                return this.farmUsers.get(i).getUserDb();
            }
        }
        return null;
    }



    public User getManagingOperatorAndOperators(){
        return this.farmUsers.where().not().equalTo("type",1).findFirst().getUserDb();
    }


}
