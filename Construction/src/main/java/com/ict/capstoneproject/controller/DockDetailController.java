package com.ict.capstoneproject.controller;

import com.ict.capstoneproject.database.BikeDB;
import com.ict.capstoneproject.entity.bike.Bike;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import java.util.List;

public class DockDetailController {

    @FXML
    public TableView<Bike> tableView;

    @FXML
    public TableColumn<Bike, Integer> colBikeId;

    @FXML
    public TableColumn<Bike, String> colBikeType;

    @FXML
    public TableColumn<Bike, String> colBarcode;

    @FXML
    public TableColumn<Bike, String> colLicensePlateNumber;

    @FXML
    public TableColumn<Bike, Integer> colBatteryPercentage;

    @FXML
    public TableColumn<Bike, Boolean> colIsAvailableBike;

    @FXML
    public TableColumn<Bike, String> colRent;


    private List<Bike> bikes;

    @FXML
    public void initialize() throws Exception {
        colBikeId.setCellValueFactory(new PropertyValueFactory<>("bikeId"));
        colBikeType.setCellValueFactory(new PropertyValueFactory<>("bikeType"));
        colBarcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
        colLicensePlateNumber.setCellValueFactory(new PropertyValueFactory<>("licensePlateNumber"));
        colBatteryPercentage.setCellValueFactory(new PropertyValueFactory<>("batteryPercentage"));
        colIsAvailableBike.setCellValueFactory(new PropertyValueFactory<>("isAvailable"));
        colRent.setCellValueFactory(new PropertyValueFactory<>("Rent"));

        // Action logic
        Callback<TableColumn<Bike, String>, TableCell<Bike, String>> cellFactory
                = param -> new TableCell<Bike, String>() {
            final Button btn = new Button("Rent");

            {
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                btn.setOnAction(event -> {
                    Bike bike = getTableView().getItems().get(getIndex());

                });
                setAlignment(Pos.CENTER); // Căn giữa nội dung trong cell
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        };

        colRent.setCellFactory(cellFactory);
        // Kết thúc phần logic cho cột Action

        BikeDB bikeService = new BikeDB();
        bikes = bikeService.getAllBikes();
        System.out.println(bikes);
        ObservableList<Bike> observableList = FXCollections.observableArrayList(bikes);
        tableView.setItems(observableList);
    }
}
