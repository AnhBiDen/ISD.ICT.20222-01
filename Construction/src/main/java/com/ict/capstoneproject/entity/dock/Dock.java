package com.ict.capstoneproject.entity.dock;

import javafx.beans.property.*;

public class Dock {
    private int dockId;
    private String dockName;
    private String address;
    private int availableBikes;
    private int walkingTime;
    private int distance;

    public Dock(int dockId, String dockName, String address, int availableBikes, int walkingTime, int distance) {
        this.dockId = dockId;
        this.dockName = dockName;
        this.address = address;
        this.availableBikes = availableBikes;
        this.walkingTime = walkingTime;
        this.distance = distance;
    }
    public int getDockId() {
        return dockId;
    }
    public void setDockId(int dockId) {
        this.dockId = dockId;
    }
    public String getDockName() {
        return dockName;
    }
    public void setDockName(String dockName) {
        this.dockName = dockName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getAvailableBikes() {
        return availableBikes;
    }
    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }
    public double getDistance() {
        return distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public int getWalkingTime() {
        return walkingTime;
    }
    public void setWalkingTime(int walkingTime) {
        this.walkingTime = walkingTime;
    }
}
