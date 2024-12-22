package com.eperpus.controller;

import com.eperpus.model.User;
import com.eperpus.util.JsonUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoginController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;

    private User currentUser;

    @FXML
    public void handleLogin() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (isValidLogin(email, password)) {
            // Login berhasil
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("Welcome to E-Perpus!");
            alert.showAndWait();

            // Pindah ke main_layout.fxml dan kirimkan currentUser ke MainController
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/eperpus/view/main_layout.fxml"));
                Scene mainScene = new Scene(loader.load());

                // Mendapatkan referensi ke MainController
                MainController mainController = loader.getController();
                mainController.setCurrentUser(currentUser); // Pass currentUser ke MainController

                Stage currentStage = (Stage) loginButton.getScene().getWindow();
                currentStage.setScene(mainScene);
                currentStage.show();
            } catch (IOException e) {
                e.printStackTrace();
                Alert alertError = new Alert(Alert.AlertType.ERROR);
                alertError.setTitle("Error");
                alertError.setContentText("Failed to load main layout.");
                alertError.showAndWait();
            }
        } else {
            // Login gagal
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email or password.");
            alert.showAndWait();
        }
    }

    private boolean isValidLogin(String email, String password) {
        try {
            // Membaca data dari users_data.json menggunakan JsonUtil
            List<User> users = JsonUtil.readUsersFromFile("users_data.json");

            // Memeriksa apakah email dan password cocok
            for (User user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    currentUser = user; // Set the current user
                    return true; // Login valid
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Login invalid
    }

}