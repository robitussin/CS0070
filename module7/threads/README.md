# Java Threads

This project contains two simple Java examples `FoodDelivery` and `FoodDeliveryV2` that show how threads can run tasks at the same time. Both examples use a food-delivery app situation: while a customer's payment is being processed, the restaurant can be notified at the same time.

## Examples

### 1. Extending `Thread`

The first example uses classes that **extend `Thread`**:

- `PaymentProcess` processes the customer's payment.
- `RestaurantNotification` sends the order to the restaurant.
- `FoodDeliveryApp` starts both tasks.

```java
payment.start();
restaurant.start();
```

Calling `start()` creates a separate thread for each task, so the payment process and restaurant notification can happen concurrently.

### 2. Implementing `Runnable`

The second example uses classes that **implement `Runnable`**:

- `PaymentTask` contains the payment task.
- `NotifyRestaurantTask` contains the restaurant-notification task.
- `FoodDeliveryRunnable` creates `Thread` objects to run the tasks.

```java
Runnable paymentTask = new PaymentTask();
Thread paymentThread = new Thread(paymentTask);
paymentThread.start();
```

With `Runnable`, the task and the thread are separate:

| Part       | Purpose                          |
| ---------- | -------------------------------- |
| `Runnable` | Describes the task to perform.   |
| `Thread`   | Runs the task in the background. |

This approach is commonly preferred because a class that implements `Runnable` can still extend another class when needed.

## Expected Output

The messages may appear in a different order each time because the tasks run independently. For example:

```text
Your order is being processed.
Processing payment...
Notifying restaurant...
Restaurant received the order!
Payment successful!
```

## Using `start()` vs `run()`

Use `start()`, not `run()`, to begin a new thread. Calling `run()` directly runs the code like a normal method and does not create a separate thread.
