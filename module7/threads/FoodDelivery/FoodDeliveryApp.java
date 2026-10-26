class PaymentProcess extends Thread {
    public void run() {
        System.out.println("Processing payment...");
        try {
            Thread.sleep(2000); // Pretend payment takes 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Payment successful!");
    }
}

class RestaurantNotification extends Thread {
    public void run() {
        System.out.println("Notifying restaurant...");
        try {
            Thread.sleep(1000); // Pretend notification takes 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Restaurant received the order!");
    }
}

public class FoodDeliveryApp {
    public static void main(String[] args) {
        PaymentProcess payment = new PaymentProcess();
        RestaurantNotification restaurant = new RestaurantNotification();

        payment.start(); // Starts payment in a separate thread
        restaurant.start(); // Starts notification in another thread

        System.out.println("Your order is being processed.");
    }
}