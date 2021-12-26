package pb.kravchuk.hw13;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        int SIZE = 5;
        Queue sharedQueue = new ArrayDeque();
        Thread produceThread = new Thread(new Producer(SIZE, (Queue<Double>) sharedQueue));
        Thread consumeThread = new Thread(new Consumer((Queue<Double>) sharedQueue));
        produceThread.start();
        consumeThread.start();
}
}
