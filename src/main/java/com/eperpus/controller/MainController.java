package com.eperpus.controller;

import com.eperpus.model.User;
import com.eperpus.model.Book;
import com.eperpus.model.Item;
import com.eperpus.model.Magazine;
import com.eperpus.util.JsonUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class MainController {

    @FXML
    private Label usernameLabel;

    @FXML
    private TableView<Book> bookTable;

    @FXML
    private TableColumn<Book, String> bookTitleColumn;

    @FXML
    private TableColumn<Book, String> bookAuthorColumn;

    @FXML
    private TableColumn<Book, Double> bookPriceColumn;

    @FXML
    private TableColumn<Book, Button> bookActionColumn;

    @FXML
    private TableView<Magazine> magazineTable;

    @FXML
    private TableColumn<Magazine, String> magazineTitleColumn;

    @FXML
    private TableColumn<Magazine, String> magazinePublisherColumn;

    @FXML
    private TableColumn<Magazine, Double> magazinePriceColumn;

    @FXML
    private TableColumn<Magazine, Button> magazineActionColumn;

    private User currentUser;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        updateUsernameLabel();
    }

    private void updateUsernameLabel() {
        if (currentUser != null) {
            usernameLabel.setText("Welcome, " + currentUser.getUsername());
        }
    }

    public void initialize() {
        updateUsernameLabel();

        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        bookActionColumn.setCellFactory(param -> createBookActionCell());

        magazineTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        magazinePublisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        magazinePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        magazineActionColumn.setCellFactory(param -> createMagazineActionCell());

        loadItems();
    }

    private TableCell<Book, Button> createBookActionCell() {
        return new TableCell<>() {
            private final Button btnPinjam = new Button("Pinjam");
            private final Button btnBeli = new Button("Beli");

            {
                btnPinjam.setOnAction(e -> handlePinjam(getTableRow().getItem()));
                btnBeli.setOnAction(e -> handleBeli(getTableRow().getItem()));
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hBox = new HBox(10);
                    hBox.getChildren().addAll(btnPinjam, btnBeli);
                    setGraphic(hBox);
                }
            }
        };
    }

    private TableCell<Magazine, Button> createMagazineActionCell() {
        return new TableCell<>() {
            private final Button btnPinjam = new Button("Pinjam");
            private final Button btnBeli = new Button("Beli");

            {
                btnPinjam.setOnAction(e -> handlePinjam(getTableRow().getItem()));
                btnBeli.setOnAction(e -> handleBeli(getTableRow().getItem()));
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox hBox = new HBox(10);
                    hBox.getChildren().addAll(btnPinjam, btnBeli);
                    setGraphic(hBox);
                }
            }
        };
    }

    private void loadItems() {
        try {
            List<Item> items = JsonUtil.readItemsFromFile("items_data.json");
            @SuppressWarnings("unchecked")
            List<Book> books = (List<Book>) (List<?>) items.stream().filter(item -> item instanceof Book)
                    .collect(Collectors.toList());
            @SuppressWarnings("unchecked")
            List<Magazine> magazines = (List<Magazine>) (List<?>) items.stream()
                    .filter(item -> item instanceof Magazine).collect(Collectors.toList());

            bookTable.getItems().setAll(books);
            magazineTable.getItems().setAll(magazines);
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Failed to load items.");
            alert.showAndWait();
        }
    }

    public static void handlePinjam(Item item) {
        try {
            List<Item> items = JsonUtil.readItemsFromFile("items_data.json");
            JsonUtil.updateItemStatus(items, item, "borrowed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void handleBeli(Item item) {
        try {
            List<Item> items = JsonUtil.readItemsFromFile("items_data.json");
            JsonUtil.updateItemStatus(items, item, "purchased");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused")
    private static void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void showAccountDetails() {
        System.out.println("Account details clicked");
    }
}