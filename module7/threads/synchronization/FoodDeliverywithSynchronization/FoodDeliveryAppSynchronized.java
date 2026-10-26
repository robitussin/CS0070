class Restaurant {
    private int pizzaStock = 1;

    public synchronized void orderPizza(String customerName) {
        if (pizzaStock > 0) {
            System.out.println(customerName + " is ordering the last pizza...");

            pizzaStock--;

            System.out.println("Order accepted for " + customerName);
            System.out.println("Remaining pizzas: " + pizzaStock);
        } else {
            System.out.println("Sorry " + customerName + ", pizza is sold out.");
        }
    }
}

class CustomerOrder implements Runnable {
    private Restaurant restaurant;
    private String customerName;

    public CustomerOrder(Restaurant restaurant, String customerName) {
        this.restaurant = restaurant;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        restaurant.orderPizza(customerName);
    }
}

public class FoodDeliveryAppSynchronized {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Thread customer1 = new Thread(
                new CustomerOrder(restaurant, "Ana"));

        Thread customer2 = new Thread(
                new CustomerOrder(restaurant, "Ben"));

        customer1.start();
        customer2.start();
    }
}