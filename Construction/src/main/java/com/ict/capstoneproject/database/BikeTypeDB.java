package com.ict.capstoneproject.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ict.capstoneproject.database.ConnectDB;
import com.ict.capstoneproject.entity.bike.BikeType;
public class BikeTypeDB {

    public BikeTypeDB() {

    }

    public static BikeType getById(int typeId) throws SQLException {

        Connection connection = ConnectDB.getConnection();
        Statement statement = connection.createStatement();
        String query = String.format("select * from `bikeType` where typeId =  %d", typeId);
        ResultSet result = statement.executeQuery(query);

        if (result.next()) {
            BikeType bikeType = new BikeType();
            bikeType.setBikeTypeId(result.getInt("bikeTypeId"));
            bikeType.setBikeTypeName(result.getString("bikeTypeId"));
            bikeType.setNoOfSaddles(result.getInt("noOfSaddles"));
            bikeType.setNoOfPendals(result.getInt("noOfPendals"));
            bikeType.setBikeTypeImageURL(result.getString("bikeTypeImageURL"));
            bikeType.setPrice(result.getInt("price"));
            bikeType.setBikeTypeEBike(result.getBoolean("bikeTypeEBike"));


            return bikeType;
        }
        return null;
    }

}
