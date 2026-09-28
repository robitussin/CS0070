package com.mycompany.ordersystem;

import java.util.Scanner;

public class OrderSystem {

    public static double calculateTotal(double[] prices, int count) {
        double total = 0.0;
        for (int i = 0; i < count; i = i + 1) {
            total = total + prices[i];
        }
        return total;
    }

    public static void printMenu(String[] names, double[] prices) {
        System.out.println("\n=== Menu ===");
        for (int i = 0; i < names.length; i = i + 1) {
            System.out.println((i + 1) + ". " + names[i] + " - $" + prices[i]);
        }
        System.out.println((names.length + 1) + ". Checkout / Exit");
    }

    public static void displayOrder(String[] names, double[] prices, int count) {
        System.out.println("\n--- Your Final Order ---");
        if (count == 0) {
            System.out.println("No items ordered.");
            return;
        }

        for (int i = 0; i < count; i = i + 1) {
            System.out.println("- " + names[i] + ": $" + prices[i]);
        }
        System.out.println("Total: $" + calculateTotal(prices, count));
    }

    public static void main(String[] args) {
        String[] menuNames = new String[] {"Burger", "Fries", "Soda", "Ice Cream"};
        double[] menuPrices = new double[] {8.99, 2.99, 1.99, 3.49};

        String[] selectedNames = new String[10];
        double[] selectedPrices = new double[10];
        int selectedCount = 0;

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            printMenu(menuNames, menuPrices);
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == menuNames.length + 1) {
                running = false; // Exit loop
            } else if (choice >= 1 && choice <= menuNames.length) {
                if (selectedCount < selectedNames.length) {
                    int index = choice - 1;
                    
                    selectedNames[selectedCount] = menuNames[index];
                    selectedPrices[selectedCount] = menuPrices[index];
                    selectedCount = selectedCount + 1;

                    System.out.println("Added: " + menuNames[index]);
                } else {
                    System.out.println("Order full!");
                }
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        displayOrder(selectedNames, selectedPrices, selectedCount);
        scanner.close();
    }
}