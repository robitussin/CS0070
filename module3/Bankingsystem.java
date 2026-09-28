package com.mycompany.bankingsystem;

// Inline class
class Customer {
    // Attributes of Customer Class
    public String name;
    public int accountNumber;
    
    // This is only accessible inside the Customer Class
    private double balance;
    
    // 
    public static int count = 0;
    
    // Constructor
    public Customer(String customerName, int customerAccountNumber){
        this.name = customerName;
        this.accountNumber = customerAccountNumber;
    }
    
    public void displayName(){
        System.out.println("The customer name is: " + this.name);
    }
    
    // Getter
    public double getBalance(){
        return balance;
    }
    
    // Setter
    public void setBalance(double customerbalance){
        this.balance = customerbalance;
    }
};

public class Bankingsystem {

    public static void main(String[] args) {
        
        // Object 
        Customer myfirstcustomer = new Customer("Elizer", 12345);
        System.out.println(myfirstcustomer.name);
        System.out.println(myfirstcustomer.accountNumber);
        
        // Results in an error
//       System.out.println(myfirstcustomer.balance);

         // Results in an error
//       myfirstcustomer.balance = 500.00;
    
        // Setter
        // myfirstcustomer.setBalance(500.00);
        // Getter
        // System.out.println(myfirstcustomer.getBalance());
       
//        myfirstcustomer.name = "Elizer Ponio Jr.";
//        myfirstcustomer.accountNumber = 1234567890;
        
//        System.out.println(myfirstcustomer.name);
//        System.out.println(myfirstcustomer.accountNumber);
        
        Customer mysecondcustomer = new Customer("Pia", 55555);
        System.out.println(mysecondcustomer.name);
        System.out.println(mysecondcustomer.accountNumber);
        
        
        myfirstcustomer.count = 1;
        
        System.out.println(myfirstcustomer.count);
        
        System.out.println(mysecondcustomer.count);
    }
}
