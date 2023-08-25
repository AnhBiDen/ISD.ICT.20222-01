package com.ict.capstoneproject.entity.bike;

public class Bike {
    private int bikeId;
    private String bikeType;
    private String barcode;
    private String licensePlateNumber;
    private int batteryPercentage;
    private boolean isAvailable;

    public Bike(int bikeId, String bikeType, String barcode, String licensePlateNumber,int batteryPercentage,boolean isAvailable){
        this.bikeId = bikeId;
        this.bikeType = bikeType;
        this.barcode = barcode;
        this.licensePlateNumber = licensePlateNumber;
        this.batteryPercentage = batteryPercentage;
        this.isAvailable = isAvailable;
    }

    public int getBikeId() {
        return bikeId;
    }
    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
    public String getBarcode() {
        return barcode;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }
    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
    public boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public int getBatteryPercentage() {
        return batteryPercentage;
    }
    public void setBatteryPercentage(int batteryPercentage) {
        this.batteryPercentage = batteryPercentage;
    }
    public String getBikeType() {
        return bikeType;
    }
    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
    public String toString() {
        return "Bike " + getBikeId() + " Type " + getBikeType() + " Bar Code " + getBarcode() + " Percentage " + getBatteryPercentage();
    }
}
