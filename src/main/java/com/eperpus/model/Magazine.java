package com.eperpus.model;

public class Magazine extends Item {
    private String publisher;

    public Magazine(String title, String publisher, double price, String type, String status) {
        super(title, price, type, status);
        this.publisher = publisher;
    }

    // Getter dan setter untuk publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public void buy() {
        if (getStatus().equals("available")) {
            setStatus("purchased"); // Mengubah status menjadi purchased
            System.out.println("Magazine '" + getTitle() + "' has been purchased.");
        } else {
            System.out.println("Magazine '" + getTitle() + "' is not available for purchase.");
        }
    }

    @Override
    public void borrow() {
        if (getStatus().equals("available")) {
            setStatus("borrowed"); // Mengubah status menjadi borrowed
            System.out.println("Magazine '" + getTitle() + "' has been borrowed.");
        } else {
            System.out.println("Magazine '" + getTitle() + "' is not available for borrowing.");
        }
    }
}
