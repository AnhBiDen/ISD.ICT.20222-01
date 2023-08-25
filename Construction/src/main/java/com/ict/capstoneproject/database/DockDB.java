package com.ict.capstoneproject.database;

import com.ict.capstoneproject.entity.dock.Dock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DockDB {

    public List<Dock> getAllDocks() {
        List<Dock> docks = new ArrayList<>();
        String query = "SELECT * FROM ecobike";

        try (Connection connection = ConnectDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int dockId = resultSet.getInt("dock_id");
                String dockName = resultSet.getString("dock_name");
                String address = resultSet.getString("address");
                int availableBikes = resultSet.getInt("available_bikes");
                int distance = resultSet.getInt("distance");
                int walkingTime = resultSet.getInt("walking_time");

                Dock dock = new Dock(dockId, dockName, address, availableBikes, distance, walkingTime);
                docks.add(dock);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return docks;
    }
}
