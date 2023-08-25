package com.ict.capstoneproject.entity.bike;

public class BikeType {
    private int bikeTypeId;
    private String bikeTypeName;
    private int noOfSaddles;
    private int noOfPendals;
    private String bikeTypeImageURL;
    private boolean bikeTypeEBike;
    private int price;
    public BikeType(){

    }
    public BikeType(int bikeTypeId, String bikeTypeName, int noOfSaddles, int noOfPendals, String bikeTypeImageURL, int price, boolean bikeTypeEBike){
        this.bikeTypeId=bikeTypeId;
        this.bikeTypeName=bikeTypeName;
        this.noOfSaddles=noOfSaddles;
        this.noOfPendals=noOfPendals;
        this.bikeTypeImageURL=bikeTypeImageURL;
        this.price=price;
        this.bikeTypeEBike=bikeTypeEBike;
    }
    public int getBikeTypeId() {
        return bikeTypeId;
    }
    public void setBikeTypeId(int bikeTypeId) {
        this.bikeTypeId = bikeTypeId;
    }
    public String getBikeTypeName() {
        return bikeTypeName;
    }
    public void setBikeTypeName(String bikeTypeName) {
        this.bikeTypeName = bikeTypeName;
    }

    public int getNoOfSaddles() {
        return noOfSaddles;
    }
    public void setNoOfSaddles(int noOfSaddles) {
        this.noOfSaddles = noOfSaddles;
    }
    public int getNoOfPendals() {
        return noOfPendals;
    }
    public void setNoOfPendals(int noOfPendals) {
        this.noOfPendals = noOfPendals;
    }
    public String getBikeTypeImageURL () {
        return bikeTypeImageURL;
    }
    public void setBikeTypeImageURL(String bikeTypeImageURL) {
        this.bikeTypeImageURL = bikeTypeImageURL;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public boolean getBikeTypeEBike() {
        return this.bikeTypeEBike;
    }
    public void setBikeTypeEBike(boolean bikeTypeEBike){
        this.bikeTypeEBike=bikeTypeEBike;
    }
}
