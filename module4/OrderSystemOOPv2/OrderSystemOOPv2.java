package com.mycompany.ordersystemoopv2;

import java.util.Scanner;

public class OrderSystemOOPv2 {
    public static void main(String[] args) {

        // Polymorphic array holding child class instances
        MenuItem[] menu = new MenuItem[4];
        menu[0] = new FoodItem("Burger", 8.99, false);
        menu[1] = new FoodItem("Spicy Wings", 6.99, true);
        menu[2] = new DrinkItem("Soda", 1.99, "Large");
        menu[3] = new DrinkItem("Iced Tea", 2.49, "Medium");

        Order order = new Order(10);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu ===");
            for (int i = 0; i < menu.length; i++) {
                // Calls getDetails() dynamically based on item type
                System.out.println((i + 1) + ". " + menu[i].getDetails());
            }
            System.out.println((menu.length + 1) + ". Checkout / Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            if (choice == menu.length + 1) {
                break;
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