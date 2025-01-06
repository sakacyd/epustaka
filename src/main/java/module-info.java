module com.eperpus {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    opens com.eperpus to javafx.fxml;
    opens com.eperpus.controller to javafx.fxml;
    opens com.eperpus.model to javafx.fxml;
    opens com.eperpus.util to javafx.fxml;
    
    exports com.eperpus;
    exports com.eperpus.controller;
    exports com.eperpus.model;
    exports com.eperpus.util;
}
