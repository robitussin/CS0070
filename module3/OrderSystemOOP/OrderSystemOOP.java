package com.mycompany.ordersystemoop;

import java.util.Scanner;

// Represents a menu item
class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

// Manages the order items and calculation
class Order {
    Item[] items;
    int itemCount;

    public Order(int capacity) {
        this.items = new Item[capacity];
        this.itemCount = 0;
    }

    // Adds an item to the order array
    public void addItem(Item item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount = itemCount + 1;
            System.out.println("Added: " + item.name);
        } else {
            System.out.println("Order is full! Cannot add more items.");
        }
    }

    // Calculates total using a standard loop
    public double calculateTotal() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i = i + 1) {
            total = total + items[i].price;
        }
        return total;
    }

    // Displays order details
    public void displayOrder() {
        System.out.println("\n--- Your Final Order (OOP) ---");
        if (itemCount == 0) {
            System.out.println("No items ordered.");
            return;
        }

        for (int i = 0; i < itemCount; i = i + 1) {
            System.out.println("- " + items[i].name + ": $" + items[i].price);
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

public class OrderSystemOOP {
    public static void main(String[] args) {
 
        Item[] menu = new Item[4];
        menu[0] = new Item("Burger", 8.99);
        menu[1] = new Item("Fries", 2.99);
        menu[2] = new Item("Soda", 1.99);
        menu[3] = new Item("Ice Cream", 3.49);

        Order order = new Order(10); // Order can hold up to 10 items
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            for (int i = 0; i < menu.length; i = i + 1) {
                System.out.println((i + 1) + ". " + menu[i].name + " - $" + menu[i].price);
            }
            System.out.println((menu.length + 1) + ". Checkout / Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == menu.length + 1) {
                break; // Exit loop
            } else if (choice >= 1 && choice <= menu.length) {
                order.addItem(menu[choice - 1]);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        order.displayOrder();
        scanner.close();
    }
}