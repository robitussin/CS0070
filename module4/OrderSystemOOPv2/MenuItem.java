package com.mycompany.ordersystemoopv2;

abstract class MenuItem {
    // Protected fields can be accessed by child classes
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Abstract method: Every subclass MUST define how to display its details
    public abstract String getDetails();

    // Regular getter methods
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}