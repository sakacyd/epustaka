package com.eperpus;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage primaryStage) throws IOException {
        // Load the login view (FXML)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eperpus/view/login.fxml"));
        Scene scene = new Scene(loader.load());
        
        // Set up the primary stage
        primaryStage.setTitle("E-Perpus - Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
