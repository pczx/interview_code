package leetcode;

public class leecode1114 {

    private volatile int flag = 1;

    public leecode1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            while (flag != 1) {
                wait();
            }
            printFirst.run();
            flag = 2;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (flag != 2) {
                wait();
            }
            printSecond.run();
            flag = 3;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (flag != 3) {
                wait();
            }
            printThird.run();
            notifyAll();
        }
    }
}
