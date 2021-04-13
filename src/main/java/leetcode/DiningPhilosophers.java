package leetcode;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    private ReentrantLock[] locks = new ReentrantLock[5];

    public DiningPhilosophers() {
        Arrays.fill(locks, new ReentrantLock());
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftFork = (philosopher + 1) % 5;
        int rightFork = philosopher;

        if (philosopher % 2 == 0) {
            locks[leftFork].lock();
            locks[rightFork].lock();
        } else {
            locks[rightFork].lock();
            locks[leftFork].lock();
        }

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        locks[leftFork].unlock();
        locks[rightFork].unlock();
    }
}
