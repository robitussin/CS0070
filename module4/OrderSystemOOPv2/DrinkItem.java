package com.mycompany.ordersystemoopv2;

class DrinkItem extends MenuItem {
    private String size; // e.g., "Small", "Large"

    public DrinkItem(String name, double price, String size) {
        super(name, price); // Call parent constructor
        this.size = size;
    }

    // Polymorphic implementation of abstract method
    @Override
    public String getDetails() {
        return name + " (" + size + ") - $" + price;
    }
}
