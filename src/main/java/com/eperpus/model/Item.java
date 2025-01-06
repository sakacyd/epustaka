package com.eperpus.model;

public abstract class Item {
    private String title;  // Judul buku atau majalah
    private double price;  // Harga buku atau majalah
    private String type;   // Tipe item (book atau magazine)
    private String subscription; // Tipe subscription (Premium atau Regular)
    private String status; // Status item (available, borrowed, purchased)

    // Konstruktor
    public Item(String title, double price, String type, String subscription, String status) {
        this.title = title;
        this.price = price;
        this.type = type;
        this.subscription = subscription;
        this.status = status;
    }

    // Getter dan setter untuk title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter dan setter untuk price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter dan setter untuk type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter dan setter untuk subscription
    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    // Getter dan setter untuk status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Metode abstrak untuk membeli item
    public abstract void buy();

    // Metode abstrak untuk meminjam item
    public abstract void borrow();
}