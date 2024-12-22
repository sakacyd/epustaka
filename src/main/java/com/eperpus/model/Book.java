package com.eperpus.model;

public class Book extends Item {
    
    private String author;  // Penulis buku

    // Constructor untuk Book
    public Book(String title, String author, double price, String type) {
        super(title, price, type);  // Memanggil constructor superclass Item
        this.author = author;
    }

    // Getter dan setter untuk author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Implementasi metode untuk membeli buku
    @Override
    public void buy() {
        System.out.println("Buku '" + getTitle() + "' berhasil dibeli dengan harga Rp" + getPrice());
    }

    // Implementasi metode untuk meminjam buku
    @Override
    public void borrow() {
        System.out.println("Buku '" + getTitle() + "' berhasil dipinjam.");
    }

    @Override
    public String toString() {
        return "Buku [Judul=" + getTitle() + ", Penulis=" + author + ", Harga=" + getPrice() + ", Tipe=" + getType() + "]";
    }
}