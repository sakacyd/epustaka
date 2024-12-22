package com.eperpus.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private String userId; // ID User
    private String username; // Username
    private String password; // Password
    private String email; // Email
    private Membership membership; // Status Membership (Premium atau Reguler)

    public User() {
    }

    // Konstruktor
    @JsonCreator
    public User(
            @JsonProperty("userId") String userId,
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("membership") Membership membership) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.membership = membership;
    }

    // Getter dan setter untuk userId
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    // Getter dan setter untuk username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter dan setter untuk password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter dan setter untuk email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter dan setter untuk membership
    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    // Method untuk menampilkan informasi user
    @Override
    public String toString() {
        return "User [ID=" + userId + ", Username=" + username + ", Email=" + email + ", Membership="
                + membership.getType() + "]";
    }
}