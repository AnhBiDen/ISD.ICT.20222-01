module com.ict.capstoneproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires com.dlsc.formsfx;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.ict.capstoneproject to javafx.fxml;
    opens com.ict.capstoneproject.entity.dock to javafx.base;
    opens com.ict.capstoneproject.entity.bike to javafx.base;

    exports com.ict.capstoneproject;
    exports com.ict.capstoneproject.views;
    exports com.ict.capstoneproject.controller;
}