package com.blue.api.entity;

import java.time.LocalDate;

public class Product {

    private long id;
    private String name;
    private float price;
    private LocalDate expDate;
    private int stock;

    // Constructor vacío
    public Product() {
    }

    // Constructor con parámetros
    public Product(long id, String name, float price, LocalDate expDate, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expDate = expDate;
        this.stock = stock;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public int getStock() {
        return stock;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}