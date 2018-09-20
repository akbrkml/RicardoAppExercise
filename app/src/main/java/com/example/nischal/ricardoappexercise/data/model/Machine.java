package com.example.nischal.ricardoappexercise.data.model;

import android.text.TextUtils;

import com.example.nischal.ricardoappexercise.util.CommonUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.LinkingObjects;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Utsab on 3/12/2018.
 */

public class Machine extends RealmObject {

    @PrimaryKey
    private String localMachineUuid;
    private int position;

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    private int category_id;
    private int machineId;
    private String lastReading;
    private String comments;
    private String lastService;
    private String modelName;
    private int readingUnit;

    //Vehicle registration
    private String registrationDate;
    private Date notificationDate;
    private String notificationDuration;
    private int notificationFormat;
    private int registrationNotificatioinId = 0;

    private String nextService;
    private String order;
    private String registrationNumber;
    private String vinSerial;
    private String createdAt;
    private String updatedAt;
    private int is_deleted;
    private boolean syncStatus;
    private String deletedAt;
    private int alarmId = 0;


    //getting the deadline for next service date
    private Date nextServiceDate;

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    private Integer createdBy;
    private RealmList<Image> images;
    private RealmList<MachineCategory> machineCategories;
    private RealmList<Service> serviceDbs;
    private MachineOrder machineOrder;
    @LinkingObjects("machinesList")
    private final RealmResults<Farm> farmDbs = null;

    private RealmList<MachineItem> serviceItems;

    private RealmList<MachineFarm> machineFarms;

    public boolean isSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(boolean syncStatus) {
        this.syncStatus = syncStatus;
    }

    public RealmList<MachineFarm> getMachineFarms() {

        return machineFarms;
    }


    public void setNextServiceDate(String nextServiceDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(nextServiceDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.nextServiceDate = date;
    }

    public Date getNextServiceDate() {
        return nextServiceDate;
    }


    public void setMachineFarms(RealmList<MachineFarm> machineFarms) {
        if (this.machineFarms != null && this.machineFarms.size() > 0) {
            this.machineFarms.addAll(machineFarms);
        } else {
            this.machineFarms = new RealmList<>();
            this.machineFarms.addAll(machineFarms);
        }
    }

    public void setMachineFarms(MachineFarm machineFarms) {
        if (this.machineFarms != null && this.machineFarms.size() > 0) {
            this.machineFarms.add(machineFarms);
        } else {
            this.machineFarms = new RealmList<>();
            this.machineFarms.add(machineFarms);
        }
    }

    public void setMachineFarms(RealmResults<MachineFarm> machineFarmsDb) {
        RealmList<MachineFarm> machineFarms = new RealmList<>();
        machineFarms.addAll(machineFarmsDb);
        this.machineFarms = machineFarms;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
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
        } else {
            this.images.add(images);
        }
    }

    public RealmList<MachineCategory> getMachineCategories() {
        return machineCategories;
    }

    public void setMachineCategories(RealmList<MachineCategory> machineCategories) {
        this.machineCategories = machineCategories;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machine_id) {
        this.machineId = machine_id;
    }

    public String getLocalMachineUuid() {
        return localMachineUuid;
    }

    public void setLocalMachineUuid(String localMachineUuid) {
        this.localMachineUuid = localMachineUuid;
    }

    public String getLastReading() {
        return lastReading;
    }

    public void setLastReading(String lastReading) {
        this.lastReading = lastReading;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getLastService() {
        return lastService;
    }

    public void setLastService(String lastService) {
        this.lastService = lastService;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getNextService() {
        return nextService;
    }

    public void setNextService(String nextService) {
        this.nextService = nextService;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVinSerial() {
        return vinSerial;
    }

    public void setVinSerial(String vinSerial) {
        this.vinSerial = vinSerial;
    }


    public int getIsDeleted() {
        return is_deleted;
    }

    public void setIsDeleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public RealmList<Service> getServiceDbs() {
        return serviceDbs;
    }

    public void setServiceDbs(Service serviceDbs) {
        if (this.serviceDbs == null || this.serviceDbs.size() == 0) {
            this.serviceDbs = new RealmList<>();
            this.serviceDbs.add(serviceDbs);
        } else {
            this.serviceDbs.add(serviceDbs);
        }

    }

    public void setServiceLists(RealmList<Service> services) {
        if (this.serviceDbs == null || this.serviceDbs.size() == 0) {
            this.serviceDbs = new RealmList<>();
            this.serviceDbs.addAll(services);
        } else {

            this.serviceDbs.addAll(services);
        }
    }

    public RealmList<MachineItem> getMachineItems() {
        return serviceItems;
    }

    public void setServiceItems(RealmList<MachineItem> serviceItems) {
        if (this.serviceItems == null || this.serviceItems.size() == 0) {
            this.serviceItems = new RealmList<>();
            this.serviceItems.addAll(serviceItems);
        } else {

            this.serviceItems.addAll(serviceItems);
        }
    }

    public void setServiceItems(MachineItem serviceItems) {
        if (this.serviceItems == null || this.serviceItems.size() == 0) {
            this.serviceItems = new RealmList<>();
            this.serviceItems.add(serviceItems);
        } else {

            this.serviceItems.add(serviceItems);
        }
    }

    public void addServiceItem(MachineItem serviceItem) {
        this.serviceItems.add(serviceItem);
    }

    public RealmResults<Farm> getFarmDbs() {
        return farmDbs;
    }

    public String getReadingUnit() {
        if (this.readingUnit == 1)
            return "kms";
        else if (this.readingUnit == 2)
            return "hrs";
        else
            return "miles";
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
        this.updatedAt = CommonUtils.getCurrentDateTimeString();
    }

    public void setUpdatedAt() {
        this.updatedAt = CommonUtils.getCurrentDateTimeString();
    }

    public RealmResults<Service> getServicesForSync() {
        return this.serviceDbs.where().equalTo("syncStatus", false).findAll();
    }

    public RealmList<Service> getServices() {
        RealmList<Service> services = new RealmList<>();
        services.addAll(this.serviceDbs.where().equalTo("isDeleted", 0).findAllSorted("serviceDateTime", Sort.DESCENDING));
        return services;
    }

    public MachineOrder getMachineOrder() {
        return machineOrder;
    }

    public void setMachineOrder(MachineOrder machineOrder) {

        this.machineOrder = machineOrder;
    }

    //for saving the next service date such that it makes query easier while setting an alarm withing of only one maonth
    public String getNextServiceDate(String date, int time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        if (TextUtils.isEmpty(date)) {
            date = CommonUtils.getCurrentDateString();
        }
        Date dateStartTime = null;
        if (TextUtils.isEmpty(date)) {
            date = CommonUtils.getCurrentDateString();
        }
        try {
            dateStartTime = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStartTime);
        cal.add(Calendar.MONTH, time);
        return simpleDateFormat.format(cal.getTime());
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId() {

        int min = 1;
        int max = Integer.MAX_VALUE;

        Random r = new Random();

        if (alarmId == 0) {
            alarmId = r.nextInt(max - min + 1) + min;
        }
    }

    public void setAlarmId(int id) {
        this.alarmId = id;
    }


    public Integer getReadingUnitInt() {
        return this.readingUnit;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getNotificationDate() {
        return this.notificationDate;
    }

    public String getNotificationDate(String date, String duration, int notificationFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        if (TextUtils.isEmpty(date)) {
            date = CommonUtils.getCurrentDateString();
        }
        Date dateStartTime = null;
        if (TextUtils.isEmpty(date)) {
            date = CommonUtils.getCurrentDateString();
        }
        try {
            dateStartTime = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateStartTime);
        if (notificationFormat == 2)
            cal.add(Calendar.MONTH, -Integer.parseInt(duration));
        else
            cal.add(Calendar.DAY_OF_YEAR, -(Integer.parseInt(duration) * 7));

        if (cal.getTime().before(CommonUtils.getCurrentDate())){
            cal = Calendar.getInstance();
            cal.setTime(CommonUtils.getCurrentDate());
        }
        return simpleDateFormat.format(cal.getTime());
    }

    public String getNotificationDateString(){
        return CommonUtils.getCurrentDateToServer(notificationDate);
    }

    public void setNotificationDate(String notificationDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = null;
        try {
            date = dateFormat.parse(notificationDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.notificationDate = date;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationDuration() {
        return notificationDuration;
    }

    public void setNotificationDuration(String notificationDuration) {
        this.notificationDuration = notificationDuration;
    }

    public int getNotificationFormat() {
        return notificationFormat;
    }

    public void setNotificationFormat(int notificationFormat) {
        this.notificationFormat = notificationFormat;
    }

    public int getRegistrationNotificatioinId() {
        return registrationNotificatioinId;
    }

    public void setRegistrationNotificatioinId() {
        int min = 1;
        int max = Integer.MAX_VALUE;

        Random r = new Random();

        if (registrationNotificatioinId == 0) {
            registrationNotificatioinId = r.nextInt(max - min + 1) + min;
        }
    }

    public void setRegistrationNotificatioinId(int id) {

        registrationNotificatioinId = id;

    }
}
