package com.mycompany.ordersystemoopv2;

class FoodItem extends MenuItem {
    private boolean isSpicy;

    public FoodItem(String name, double price, boolean isSpicy) {
        super(name, price); // Call parent constructor
        this.isSpicy = isSpicy;
    }

    // Polymorphic implementation of abstract method
    @Override
    public String getDetails() {
        String spicyText = isSpicy ? " [Spicy]" : "";
        return name + spicyText + " - $" + price;
    }
}
