package com.eperpus.model;

public enum Membership {
    
    REGULAR("Regular"),  // Tipe membership Reguler
    PREMIUM("Premium");  // Tipe membership Premium

    private final String type;

    // Konstruktor enum
    Membership(String type) {
        this.type = type;
    }

    // Getter untuk tipe membership
    public String getType() {
        return type;
    }
}
