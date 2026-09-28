package com.mycompany.ordersystemoopv2;

class Order implements Discountable {
    // 4. POLYMORPHISM: Array holds parent type (MenuItem), but stores child objects
    private MenuItem[] items;
    private int itemCount;

    public Order(int capacity) {
        this.items = new MenuItem[capacity];
        this.itemCount = 0;
    }

    public void addItem(MenuItem item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
            System.out.println("Added: " + item.getName());
        } else {
            System.out.println("Order is full! Cannot add more items.");
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getPrice();
        }
        return total;
    }

    // Implementing the interface method
    @Override
    public double applyDiscount(double rate) {
        double discountAmount = calculateTotal() * rate;
        return calculateTotal() - discountAmount;
    }

    public void displayOrder() {
        System.out.println("\n--- Your Final Order (OOP) ---");
        if (itemCount == 0) {
            System.out.println("No items ordered.");
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            // Polymorphism in action: Calls the correct getDetails() for Food or Drink
            System.out.println("- " + items[i].getDetails());
        }

        double total = calculateTotal();
        System.out.println("Subtotal: $" + total);

        // Apply a 10% discount using the interface method
        double discountedTotal = applyDiscount(0.10);
        System.out.println("Total after 10% discount: $" + discountedTotal);
    }
}