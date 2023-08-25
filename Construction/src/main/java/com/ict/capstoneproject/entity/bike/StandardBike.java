package com.ict.capstoneproject.entity.bike;

import com.ict.capstoneproject.entity.dock.Dock;
import com.ict.capstoneproject.entity.bike.BikeType;

public class StandardBike extends Bike {

    public static final int BIKE_TYPE_VALUE = 1;


    public StandardBike(int bikeId, BikeType bikeType, String barcode, String licensePlateNumber,
                         int batteryPercentage, boolean isAvailable) {
        super(bikeId, String.valueOf(bikeType), barcode, licensePlateNumber,batteryPercentage, isAvailable);
    }

}