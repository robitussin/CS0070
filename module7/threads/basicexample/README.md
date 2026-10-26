# Basic Java Thread Syntax

This example shows the two basic ways to create and start threads in Java:

1. Extend the `Thread` class.
2. Implement the `Runnable` interface.

Threads allow tasks to run independently from the main program. In this example, one thread prints **"Thread is running"** while another prints **"Job is running"**.

## Complete Code

```java
class Job implements Runnable {

    public void run() {
        System.out.println("Job is running");
    }

}

class Worker extends Thread {

    public void run() {
        System.out.println("Thread is running");
    }
}

public class App {
    public static void main(String[] args) {

        Worker worker1 = new Worker();
        // Start the worker thread
        worker1.start();

        Job job1 = new Job();
        Thread thread1 = new Thread(job1);
        // Start the job thread
        thread1.start();
    }
}
```

## Method 1: Extending `Thread`

Create a class that extends `Thread`, then place the task inside the `run()` method.

```java
class Worker extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}
```

Create an object and call `start()`:

```java
Worker worker1 = new Worker();
worker1.start();
```

## Method 2: Implementing `Runnable`

Create a class that implements `Runnable`, then place the task inside the `run()` method.

```java
class Job implements Runnable {
    public void run() {
        System.out.println("Job is running");
    }
}
```

Create the task, give it to a `Thread`, and call `start()`:

```java
Job job1 = new Job();
Thread thread1 = new Thread(job1);
thread1.start();
```

## Important Syntax

| Code                  | Meaning                                                    |
| --------------------- | ---------------------------------------------------------- |
| `run()`               | Contains the work the thread will do.                      |
| `start()`             | Creates and starts a new thread, which then calls `run()`. |
| `extends Thread`      | A way to create a thread directly.                         |
| `implements Runnable` | A way to define a task that a thread will run.             |
| `new Thread(job1)`    | Creates a thread that will run `job1`.                     |

> Always call `start()` to run code in a separate thread. Calling `run()` directly works like a normal method call and does not create a new thread.

## Expected Output

```text
Thread is running
Job is running
```

The order may sometimes change because both threads run independently.

## How to Run

1. Save the code in a file named `App.java`.
2. Open a terminal in the folder where you saved the file.
3. Compile the code:

   ```bash
   javac App.java
   ```

4. Run the program:

   ```bash
   java App
   ```
