package com.rejman;

public class PositonOfInvoice {
    private String name;
    private double price;

    public PositonOfInvoice(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
