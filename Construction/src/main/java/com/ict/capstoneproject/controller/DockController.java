package com.ict.capstoneproject.controller;

import com.ict.capstoneproject.HomeController;
import com.ict.capstoneproject.database.DockDB;
import com.ict.capstoneproject.entity.dock.Dock;
import com.ict.capstoneproject.views.ConfigViews;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;

import java.util.List;
import java.util.stream.Collectors;

public class DockController {

    @FXML
    public TableView<Dock> tableView;

    @FXML
    public TableColumn<Dock, Integer> colId;

    @FXML
    public TableColumn<Dock, String> colName;

    @FXML
    public TableColumn<Dock, String> colAddress;

    @FXML
    public TableColumn<Dock, Integer> colAvailableBike;

    @FXML
    public TableColumn<Dock, Integer> colDistance;

    @FXML
    public TableColumn<Dock, Integer> colWalkingTime;

    @FXML
    public TableColumn<Dock, String> colAction;

    @FXML
    public TextField txtFilterDock;

    private List<Dock> docks;

    @FXML
    public void initialize() throws Exception {
        colId.setCellValueFactory(new PropertyValueFactory<>("dockId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("dockName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colAvailableBike.setCellValueFactory(new PropertyValueFactory<>("availableBikes"));
        colDistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        colWalkingTime.setCellValueFactory(new PropertyValueFactory<>("walkingTime"));
        colAction.setCellValueFactory(new PropertyValueFactory<>("Action"));

        // Action logic
        Callback<TableColumn<Dock, String>, TableCell<Dock, String>> cellFactory
                = param -> new TableCell<Dock, String>() {
            final Button btn = new Button("View Detail");

            {
                btn.setStyle("-fx-background-color: green; -fx-text-fill: white;");
                btn.setOnAction(event -> {
                    Dock dock = getTableView().getItems().get(getIndex());

                    // Chuyển đến trang chi tiết khi nút "View Detail" được nhấn
                    navigateToDetailPage(dock);
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

        colAction.setCellFactory(cellFactory);
        // Kết thúc phần logic cho cột Action

        DockDB dockService = new DockDB();
        docks = dockService.getAllDocks();
        ObservableList<Dock> observableList = FXCollections.observableArrayList(docks);
        tableView.setItems(observableList);
    }

    @FXML
    public void onSearchTyped(KeyEvent event) {
        String current_string;
        if (event.getCharacter().length() == 1) {
            current_string = txtFilterDock.getText() + event.getText();
        } else {
            current_string = txtFilterDock.getText();
        }
        List<Dock> filteredDocks = docks.stream().filter(dock -> dock.getDockName().toLowerCase().contains(current_string.toLowerCase())).collect(Collectors.toList());
        ObservableList<Dock> observableList = FXCollections.observableArrayList(filteredDocks);
        tableView.setItems(observableList);
    }

    private void navigateToDetailPage(Dock dock) {
        HomeController.loadPage(ConfigViews.VIEW_DOCK_DETAIL_PATH);
    }
}
