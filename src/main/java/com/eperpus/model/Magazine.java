package com.eperpus.model;

public class Magazine extends Item {
    
    private String publisher;  // Penerbit majalah

    // Constructor untuk Magazine
    public Magazine(String title, String publisher, double price, String type) {
        super(title, price, type);  // Memanggil constructor superclass Item
        this.publisher = publisher;
    }

    // Getter dan setter untuk publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Implementasi metode untuk membeli majalah
    @Override
    public void buy() {
        System.out.println("Majalah '" + getTitle() + "' berhasil dibeli dengan harga Rp" + getPrice());
    }

    // Implementasi metode untuk meminjam majalah
    @Override
    public void borrow() {
        System.out.println("Majalah '" + getTitle() + "' berhasil dipinjam.");
    }

    @Override
    public String toString() {
        return "Majalah [Judul=" + getTitle() + ", Penerbit=" + publisher + ", Harga=" + getPrice() + ", Tipe=" + getType() + "]";
    }
}
