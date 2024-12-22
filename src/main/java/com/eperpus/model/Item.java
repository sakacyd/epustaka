package com.eperpus.model;

public abstract class Item {
    
    private String title;  // Judul buku atau majalah
    private double price;  // Harga buku atau majalah
    private String type;   // Tipe (Premium atau Reguler)

    // Konstruktor
    public Item(String title, double price, String type) {
        this.title = title;
        this.price = price;
        this.type = type;
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

    // Metode abstrak untuk membeli item
    public abstract void buy();

    // Metode abstrak untuk meminjam item
    public abstract void borrow();

    // Method untuk menampilkan informasi item
    @Override
    public String toString() {
        return "Item [Judul=" + title + ", Harga=" + price + ", Tipe=" + type + "]";
    }
}