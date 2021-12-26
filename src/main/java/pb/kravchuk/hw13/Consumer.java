package pb.kravchuk.hw13;

import java.util.Queue;

public class Consumer implements Runnable {

    private final Queue<Double> sharedQueue;

    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    private Double consume() throws InterruptedException {
            synchronized (sharedQueue) {
                if (sharedQueue.isEmpty()) {
                    System.out.println("Consumer is waiting");
                    sharedQueue.wait();
                }
                sharedQueue.notify();
                return sharedQueue.poll();
            }
        }


    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: "+ consume());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
