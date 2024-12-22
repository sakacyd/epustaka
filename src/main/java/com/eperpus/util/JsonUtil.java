package com.eperpus.util;

import com.eperpus.model.Book;
import com.eperpus.model.Item;
import com.eperpus.model.Magazine;
import com.eperpus.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    public static List<User> readUsersFromFile(String filename) throws IOException {
        // Menggunakan classloader untuk mendapatkan file di resources
        InputStream inputStream = JsonUtil.class.getResourceAsStream("/com/eperpus/data/" + filename);

        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream,
                objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
    }

    // Membaca data pengguna dari file JSON
    public static List<Item> readItemsFromFile(String filename) throws IOException {
        // Menggunakan classloader untuk mendapatkan file di resources
        InputStream inputStream = JsonUtil.class.getResourceAsStream("/com/eperpus/data/" + filename);

        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputStream); // Membaca file JSON sebagai tree
        List<Item> items = new ArrayList<>();

        for (JsonNode node : rootNode) {
            String type = node.get("type").asText(); // Mendapatkan tipe item (book/magazine)

            if ("book".equalsIgnoreCase(type)) {
                // Parsing objek Book
                String title = node.get("title").asText();
                String author = node.get("author").asText();
                double price = node.get("price").asDouble();
                String itemType = node.get("type").asText();
                items.add(new Book(title, author, price, itemType));
            } else if ("magazine".equalsIgnoreCase(type)) {
                // Parsing objek Magazine
                String title = node.get("title").asText();
                String publisher = node.get("publisher").asText();
                double price = node.get("price").asDouble();
                String itemType = node.get("type").asText();
                items.add(new Magazine(title, publisher, price, itemType));
            }
        }

        return items; // Mengembalikan list Item yang berisi Book dan Magazine
    }

    // Menyimpan data pengguna ke file JSON
    public static void writeUsersToFile(List<User> items, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new java.io.File(filename), items);
    }

    // Menyimpan data pengguna ke file JSON
    public static void writeItemsToFile(List<Item> items, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new java.io.File(filename), items);
    }
}
