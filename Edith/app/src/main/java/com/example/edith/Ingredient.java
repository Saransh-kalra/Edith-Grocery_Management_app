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

}