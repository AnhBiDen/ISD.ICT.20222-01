package com.ict.capstoneproject.entity.bike;

import com.ict.capstoneproject.entity.dock.Dock;
import com.ict.capstoneproject.entity.bike.BikeType;

public class StandardEBike extends Bike {

    public static final int BIKE_TYPE_VALUE = 2;


    public StandardEBike(int bikeId, BikeType bikeType, String barcode, String licensePlateNumber,
                         int batteryPercentage, boolean isAvailable) {
        super(bikeId, String.valueOf(bikeType), barcode, licensePlateNumber,batteryPercentage, isAvailable);
    }

}