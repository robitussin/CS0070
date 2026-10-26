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
