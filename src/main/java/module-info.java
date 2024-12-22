module com.eperpus {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    opens com.eperpus to javafx.fxml;
    opens com.eperpus.controller to javafx.fxml;
    opens com.eperpus.model to javafx.fxml;
    opens com.eperpus.util to javafx.fxml;
    
    exports com.eperpus;
    exports com.eperpus.controller;
    exports com.eperpus.model;
    exports com.eperpus.util;
}
