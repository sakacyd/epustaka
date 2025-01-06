package com.eperpus.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    private String username;
    private String email;
    private String itemTitle;
    private String subscriptionType;
    private String itemType;
    private LocalDateTime timestamp;

    public Transaction() {
        // Konstruktor default
    }

    @JsonCreator
    public Transaction(
            @JsonProperty("username") String username,
            @JsonProperty("email") String email,
            @JsonProperty("itemTitle") String itemTitle,
            @JsonProperty("subscriptionType") String subscriptionType,
            @JsonProperty("itemType") String itemType,
            @JsonProperty("timestamp") LocalDateTime timestamp) {
        this.username = username;
        this.email = email;
        this.itemTitle = itemTitle;
        this.subscriptionType = subscriptionType;
        this.itemType = itemType;
        this.timestamp = timestamp;
    }

    // Getter dan Setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}