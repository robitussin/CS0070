/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.test;

import java.util.Scanner;

/**
 *
 * @author SLY
 */

public class Test {
    
    static int getsum(int a, int b){
        return a + b;
    }
    
    static void printMenu(String[] coffeelist){

        for(String coffeeselection: coffeelist){
            System.out.println(coffeeselection);
        }
    }

    public static void main(String[] args) {
        
        int x = 5;
        String myname = "Elizer";
        
        System.out.println(x);
        System.out.println(myname);
        
        // Constant value
        final double VAT_RATE = 0.12;
        System.out.println(VAT_RATE);
        
        System.out.println("The vat rate is " + VAT_RATE);
        
        int result = 2 + 3 * 4;
        System.out.println(result);
        
        // Override precedence by using ()
        int result2 = (2 + 3) * 4;
        System.out.println(result2);
        
        // Converting int to double
        // method 1
        int count = 25;
        double d = count;
        System.out.println(d);
        
        // method 2 - casting
        double price = 19.99;
        int p = (int) price;
        System.out.println(p);
        
        // Get the age from keyboard input
        // Create a Scanner object
        Scanner scan = new Scanner(System.in);
        
        // Prints your age
        System.out.print("Enter your Age: ");
        int myage = scan.nextInt(); // use nextInt() for integers   
        System.out.println("Your age is: "+ myage);
       
        // Prints your name
        System.out.print("Enter your Name: ");
        String name = scan.next(); // use next() for strings
        System.out.println("Your name is: "+ name);

        int score = 75;
        if(score == 100){
            System.out.println("You have a perfect score");
        }else
        {
            System.out.println("You do not have a perfect score");
        }
        
        int menu = 5;
        
        switch(menu){
            case 1 -> System.out.println("Chicken");
            case 2 -> System.out.println("Fish");
            default -> System.out.println("None");
        }
          
        String[] mymenu = {"Chicken", "Fish", "Pork"};
         
        // Regular for loop
        for(int i = 0; i < mymenu.length; i++)
        {
            System.out.println(mymenu[i]);
        }

        // Short hand version of for loop
        for(String foodmenu: mymenu)
        {
            System.out.println(foodmenu);
        }

        // Call the function and store the return value to a variable mysum
        int mysum = getsum(1,1);
        System.out.println(mysum);

        // Call the function and put it inside println()
        System.out.println(getsum(2,2));

        // Array
        String[] mycoffeemenu = {"Latte", "Americano", "Mocha"};
        // Call the function and pass the array
        printMenu(mycoffeemenu);
    }
}
