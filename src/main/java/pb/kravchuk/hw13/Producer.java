package pb.kravchuk.hw13;

import java.util.Queue;

public class Producer implements Runnable{

    private final int SIZE;
    private Queue<Double> sharedQueue;

    public Producer(int SIZE, Queue<Double> sharedQueue) {
        this.SIZE = SIZE;
        this.sharedQueue = sharedQueue;
    }
    private double produce() throws InterruptedException{
        synchronized (sharedQueue){
            if (sharedQueue.size()==SIZE){
                sharedQueue.wait();
            }
            double newVal = Math.random();
            sharedQueue.add(newVal);
            sharedQueue.notify();
            return newVal;
        }
    }

    @Override
    public void run() {
while (true){
    try {
        System.out.println("Produced: "+ produce());
    } catch (InterruptedException e){
        e.printStackTrace();
    }
}
    }
}
