class PaymentTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Processing payment...");

        try {
            Thread.sleep(2000); // Simulates a 2-second payment process
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Payment successful!");
    }
}

class NotifyRestaurantTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Notifying restaurant...");

        try {
            Thread.sleep(1000); // Simulates a 1-second notification
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Restaurant received the order!");
    }
}

public class FoodDeliveryRunnable {
    public static void main(String[] args) {
        Runnable paymentTask = new PaymentTask();
        Runnable notificationTask = new NotifyRestaurantTask();

        Thread paymentThread = new Thread(paymentTask);
        Thread notificationThread = new Thread(notificationTask);

        paymentThread.start();
        notificationThread.start();

        System.out.println("Your order is being processed.");
    }
}