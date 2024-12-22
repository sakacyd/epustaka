package com.eperpus.model;

public class Book extends Item {
    private String author;

    public Book(String title, String author, double price, String type, String status) {
        super(title, price, type, status);
        this.author = author;
    }

    // Getter dan setter untuk author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void buy() {
        if (getStatus().equals("available")) {
            setStatus("purchased"); // Mengubah status menjadi purchased
            System.out.println("Book '" + getTitle() + "' has been purchased.");
        } else {
            System.out.println("Book '" + getTitle() + "' is not available for purchase.");
        }
    }

    @Override
    public void borrow() {
        if (getStatus().equals("available")) {
            setStatus("borrowed"); // Mengubah status menjadi borrowed
            System.out.println("Book '" + getTitle() + "' has been borrowed.");
        } else {
            System.out.println("Book '" + getTitle() + "' is not available for borrowing.");
        }
    }
}
