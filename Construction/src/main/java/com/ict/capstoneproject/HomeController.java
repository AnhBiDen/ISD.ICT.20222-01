package com.ict.capstoneproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.util.Duration;
import com.ict.capstoneproject.views.ConfigViews;
import javafx.animation.FadeTransition;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController extends Application {

    private static Stage stage;
    private final String[] fxmlFiles = {ConfigViews.START_SCREEN_PATH, ConfigViews.VIEW_DOCK_SCREEN_PATH};
    private int currentIndex = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
//        stage.initStyle(StageStyle.UNDECORATED);
        loadNextFXML();
        primaryStage.show();
    }
    public static void loadPage(String path) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HomeController.class.getResource(path));
            System.out.println(HomeController.class.getResource(path));
            Parent root = fxmlLoader.load();

            stage.setTitle("Dock Detail");
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNextFXML() {
        if (currentIndex < fxmlFiles.length) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFiles[currentIndex]));
                System.out.println(getClass().getResource(fxmlFiles[currentIndex]));

                Parent root = fxmlLoader.load();

                // Set up fade transition
                FadeTransition fadeTransition = new FadeTransition(Duration.millis(2000), root);
                fadeTransition.setFromValue(0.0);
                fadeTransition.setToValue(1.0);
                fadeTransition.setOnFinished(event -> {
                    currentIndex++;
                    loadNextFXML();
                });
                fadeTransition.play();

                // Show the scene
                Scene scene = new Scene(root);
                stage.setScene(scene);

//                if (fxmlFiles[currentIndex].equals(ConfigViews.VIEW_DOCK_SCREEN_PATH)) {
////                    TableView<Dock> tableView = (TableView) scene.lookup("#tableView");
////                    initializeTableView(tableView);
//                } else {
//                    System.out.println("else in HelloApp");
//                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    private void initializeTableView(TableView<Dock> tableView) {
//        TableColumn<Dock, Integer> colId = new TableColumn<>("ID");
//        TableColumn<Dock, String> colName = new TableColumn<>("Name");
//        TableColumn<Dock, String> colAddress = new TableColumn<>("Address");
//        TableColumn<Dock, Integer> colAvailableBike = new TableColumn<>("Available bike");
//        TableColumn<Dock, Integer> colDistance = new TableColumn<>("Distance");
//        TableColumn<Dock, Integer> colWalkingTime = new TableColumn<>("Walking time");
//    }

    public static void main(String[] args) {
        launch(args);
    }
}
