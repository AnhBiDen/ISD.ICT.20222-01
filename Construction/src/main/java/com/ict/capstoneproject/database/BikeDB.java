package com.ict.capstoneproject.database;

import com.ict.capstoneproject.entity.bike.Bike;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BikeDB {

    public List<Bike> getAllBikes() {
        List<Bike> bikes = new ArrayList<>();
        String query = "SELECT * FROM bike";

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int bikeId = resultSet.getInt("bikeid");
                String bikeType = resultSet.getString("biketype");
                String barcode = resultSet.getString("barcode");
                String licensePlateNumber = resultSet.getString("licenseplatenumber");
                int batteryPercentage = resultSet.getInt("batterypercentage");
                boolean isAvailable = resultSet.getBoolean("isavailable");

                Bike bike = new Bike(bikeId, bikeType, barcode, licensePlateNumber, batteryPercentage, isAvailable); //lỗi gì đây a
                System.out.println(bike);
                System.out.println(resultSet);
                bikes.add(bike);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bikes;
    }
}
