package basicexample;

class Counter {
    private int count = 0;

    // Only one thread can use this method at a time
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

class CounterTask implements Runnable {
    private Counter counter;

    public CounterTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class App {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(new CounterTask(counter));
        Thread thread2 = new Thread(new CounterTask(counter));

        thread1.start();
        thread2.start();

        // Wait until both threads finish
        thread1.join();
        thread2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}