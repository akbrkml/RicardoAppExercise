package com.example.nischal.ricardoappexercise.data.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    @PrimaryKey
    private Integer id;
    private String accesstoken;
    private boolean active;
    private String address;
    private String avatar;
    private String country;
    private Integer imageId;
    private RealmList<MachineCategory> categoryList;
    private int farmOccupied;
    private int isSubscribed;
    private int subscriptionType;
    private int subscriptionStatus;

    public int getSubscriptionStatus() {
        return subscriptionStatus;
    }

    public void setSubscriptionStatus(int subscriptionStatus) {
        this.subscriptionStatus = subscriptionStatus;
    }

    public int getFarmOccupied() {
        return farmOccupied;
    }

    public void setFarmOccupied(int farmOccupied) {
        this.farmOccupied = farmOccupied;
    }

    public int getIsSubscribed() {
        return isSubscribed;
    }

    public Integer getManaging() {
        return managing;
    }

    public void setIsSubscribed(int isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public int getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(int subscriptionType) {
        this.subscriptionType = subscriptionType;
    }


    @LinkingObjects("userDb")
    private final RealmResults<FarmUser> farmUser = null;


    public void setManaging(Integer managing) {
        this.managing = managing;
    }

    private String phoneCode;
    private String countryCode;

    public RealmResults<FarmUser> getFarmUser() {
        return farmUser;
    }

    public Integer getRoleId() {

        return this.farmUser.get(0).getType();
    }

    private Integer managing;
    private String deviceToken;
    private Integer deviceId;
    private String email;
    private String name;
    private String phoneNumber;
    private String postCode;
    private String state;
    private String subscriptionExpireDate;
    private String suburb;
    private Integer grouptype;
    private String companyName;
    private Integer status;
    private Integer farmCount;

    public Integer getFarmCount() {
        return farmCount;
    }

    public void setFarmCount(Integer farmCount) {
        this.farmCount = farmCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private RealmList<Farm> listFarm;
    private long timeStamp;
    private String subscriptionText;
    private String cardNumber;
    private String expiresat;
    private String cardToken;


    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiresat() {
        return expiresat;
    }

    public void setExpiresat(String expiresat) {
        this.expiresat = expiresat;
    }

    public String getCardToken() {
        return cardToken;
    }

    public void setCardToken(String cardToken) {
        this.cardToken = cardToken;
    }

    public String getSubscriptionText() {
        return subscriptionText;
    }

    public void setSubscriptionText(String subscriptionText) {
        this.subscriptionText = subscriptionText;
    }

    public Integer getGrouptype() {
        return grouptype;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setGrouptype(Integer grouptype) {
        this.grouptype = grouptype;
    }

    public RealmList<Farm> getListFarm() {
        return listFarm;
    }

    public void addFarm(Farm farmDb) {
        if (this.listFarm != null)
            this.listFarm.add(farmDb);
        else {
            this.listFarm = new RealmList<>();
            this.listFarm.add(farmDb);
        }
    }


    public void setListFarm(RealmList<Farm> listFarm) {
        this.listFarm = listFarm;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccesstoken() {
        return accesstoken;
    }

    public void setAccesstoken(String accesstoken) {
        this.accesstoken = accesstoken;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;

    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        if (postCode != null) {
            this.postCode = postCode;
        } else {
            this.postCode = "";
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if (state != null) {
            this.state = state;
        } else {
            this.state = "";
        }
    }

    public String getSubscriptionExpireDate() {
        return subscriptionExpireDate;
    }

    public void setSubscriptionExpireDate(String subscriptionExpireDate) {
        this.subscriptionExpireDate = subscriptionExpireDate;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = ((suburb == null) ? "" : suburb);

    }

    public Integer getType() {
        return grouptype;
    }

    public void setType(Integer type) {
        this.grouptype = type;
    }

    public String getFormattedCarNumber() {
        return this.cardNumber;
    }


    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCategoryList(RealmList<MachineCategory> categoryList) {
        this.categoryList = new RealmList<>();
        this.categoryList = categoryList;
    }

    public RealmList<MachineCategory> getCategoryList() {
        return categoryList;
    }
}