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
        InputStream inputStream = JsonUtil.class.getResourceAsStream("/com/eperpus/data/" + filename);
        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream,
                objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
    }

    public static List<Item> readItemsFromFile(String filename) throws IOException {
        InputStream inputStream = JsonUtil.class.getResourceAsStream("/com/eperpus/data/" + filename);
        if (inputStream == null) {
            throw new IOException("File not found: " + filename);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(inputStream);
        List<Item> items = new ArrayList<>();

        for (JsonNode node : rootNode) {
            String type = node.get("type").asText(); // Mendapatkan tipe item

            if ("book".equalsIgnoreCase(type)) {
                String title = node.get("title").asText();
                String author = node.get("author").asText();
                double price = node.get("price").asDouble();
                String itemType = node.get("type").asText();
                String status = node.has("status") ? node.get("status").asText() : "available"; // Default status
                items.add(new Book(title, author, price, itemType, status));
            } else if ("magazine".equalsIgnoreCase(type)) {
                String title = node.get("title").asText();
                String publisher = node.get("publisher").asText();
                double price = node.get("price").asDouble();
                String itemType = node.get("type").asText();
                String status = node.has("status") ? node.get("status").asText() : "available"; // Default status
                items.add(new Magazine(title, publisher, price, itemType, status));
            }
        }

        return items;
    }

    // Memperbarui status item menjadi 'borrowed' atau 'purchased'
    public static void updateItemStatus(List<Item> items, Item targetItem, String status) throws IOException {
        for (Item item : items) {
            if (item.equals(targetItem)) {
                item.setStatus(status); // Mengupdate status item
                break;
            }
        }
        writeItemsToFile(items, "items_data.json"); // Menyimpan kembali ke file
    }

    public static void writeUsersToFile(List<User> items, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new java.io.File(filename), items);
    }

    public static void writeItemsToFile(List<Item> items, String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new java.io.File(filename), items);
    }
}
