package com.example.nischal.ricardoappexercise.ui.login.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ebpearls on 2/1/2018.
 */

public class LoginResponse {

    @SerializedName("status")
    @Expose
    public Integer status;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public Data data;

    public static class Data {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("company_name")
        @Expose
        public String companyName;
        @SerializedName("braintree_id")
        @Expose
        public Object braintreeId;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("group_id")
        @Expose
        public Integer groupId;
        @SerializedName("country")
        @Expose
        public String country;
        @SerializedName("state")
        @Expose
        public String state;
        @SerializedName("suburb")
        @Expose
        public String suburb;
        @SerializedName("address")
        @Expose
        public String address;
        @SerializedName("postcode")
        @Expose
        public String postcode;
        @SerializedName("country_code")
        @Expose
        public String countryCode;
        @SerializedName("phone_code")
        @Expose
        public String phoneCode;
        @SerializedName("phone_number")
        @Expose
        public String phoneNumber;
        @SerializedName("first_time")
        @Expose
        public Integer firstTime;
        @SerializedName("last_login")
        @Expose
        public Object lastLogin;
        @SerializedName("updated_at")
        @Expose
        public String updatedAt;
        @SerializedName("token_expires_at")
        @Expose
        public Integer tokenExpiresAt;
        @SerializedName("subscription")
        @Expose
        public String subscription;
        @SerializedName("subscription_type")
        @Expose
        public int subscriptionType;
        @SerializedName("avatar")
        @Expose
        public Avatar avatar;
        @SerializedName("payment_methods")
        @Expose
        public PaymentMethods paymentMethods;
        @SerializedName("payment_help")
        @Expose
        public String paymentHelp;
        @SerializedName("farms_count")
        @Expose
        public Integer farmCount;
        @SerializedName("subscribed")
        @Expose
        public int subscribed;
        @SerializedName("farm_occupied")
        @Expose
        public Integer farmOccupied;
        @SerializedName("status")
        @Expose
        public Integer status;
        @SerializedName("subscription_status")
        @Expose
        public Integer subscriptionStatus;

    }

    public static class Avatar {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("path")
        @Expose
        public String path;

    }


    public static class PaymentMethods {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("default")
        @Expose
        public Integer _default;
        @SerializedName("card_number")
        @Expose
        public String cardNumber;
        @SerializedName("expires_at")
        @Expose
        public String expiresAt;
        @SerializedName("token")
        @Expose
        public String token;

    }




}
