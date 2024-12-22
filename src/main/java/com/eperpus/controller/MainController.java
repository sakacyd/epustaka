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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableCell;

import java.util.List;
import java.util.stream.Collectors;

public class MainController {

    @FXML
    private Label usernameLabel;

    @FXML
    private TableView<Book> bookTable; // Tabel untuk buku

    @FXML
    private TableColumn<Book, String> bookTitleColumn;

    @FXML
    private TableColumn<Book, String> bookAuthorColumn;

    @FXML
    private TableColumn<Book, Double> bookPriceColumn;

    @FXML
    private TableColumn<Book, Button> bookActionColumn;

    @FXML
    private TableView<Magazine> magazineTable; // Tabel untuk majalah

    @FXML
    private TableColumn<Magazine, String> magazineTitleColumn;

    @FXML
    private TableColumn<Magazine, String> magazinePublisherColumn;

    @FXML
    private TableColumn<Magazine, Double> magazinePriceColumn;

    @FXML
    private TableColumn<Magazine, Button> magazineActionColumn;

    private User currentUser; // Store the current logged-in user

    // Method untuk menyet currentUser
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        updateUsernameLabel(); // Memastikan username ditampilkan setelah currentUser diset
    }

    // Memperbarui label dengan username
    private void updateUsernameLabel() {
        if (currentUser != null) {
            usernameLabel.setText("Welcome, " + currentUser.getUsername());
        }
    }

    // Menampilkan data item dan informasi user
    public void initialize() {
        updateUsernameLabel();

        // Menginisialisasi kolom tabel buku
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Tombol aksi untuk buku
        bookActionColumn.setCellFactory(column -> new TableCell<Book, Button>() {
            private final Button btn = new Button("Action");

            {
                btn.setOnAction(e -> handleAction(getTableRow().getItem()));
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        // Menginisialisasi kolom tabel majalah
        magazineTitleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        magazinePublisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        magazinePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Tombol aksi untuk majalah
        magazineActionColumn.setCellFactory(column -> new TableCell<Magazine, Button>() {
            private final Button btn = new Button("Action");

            {
                btn.setOnAction(e -> handleAction(getTableRow().getItem()));
            }

            @Override
            protected void updateItem(Button item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(btn);
                }
            }
        });

        // Memuat data item (buku/majalah) dari file JSON
        loadItems();
    }

    // Handle aksi tombol Beli/Pinjam
    private void handleAction(Item item) {
        if (item != null) {
            // Implement your action logic here
            System.out.println("Item clicked: " + item.getTitle());
        }
    }

    // Memuat data buku dan majalah dari file JSON
    private void loadItems() {
        try {
            List<Item> items = JsonUtil.readItemsFromFile("items_data.json");
            // Pisahkan buku dan majalah
            @SuppressWarnings("unchecked")
            List<Book> books = (List<Book>) (List<?>) items.stream().filter(item -> item instanceof Book)
                    .collect(Collectors.toList());
            @SuppressWarnings("unchecked")
            List<Magazine> magazines = (List<Magazine>) (List<?>) items.stream()
                    .filter(item -> item instanceof Magazine).collect(Collectors.toList());

            // Set data untuk masing-masing tabel
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

    // Menampilkan detail akun pengguna saat tombol 'Account' diklik
    @FXML
    private void showAccountDetails(MouseEvent event) {
        System.out.println("Account details clicked");
    }
}