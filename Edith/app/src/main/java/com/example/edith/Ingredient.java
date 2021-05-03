package com.example.edith;
import java.util.Date;

public class Ingredient {

    String name;
    Integer quantity;
    Date expiryDate;

    public Ingredient() {

    }

    public Ingredient(String name, Integer quantity, Date expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity.toString();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getExpiryDate() {
        return expiryDate.toString();
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
}