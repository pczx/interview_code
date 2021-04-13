package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class Foo {

    private AtomicInteger firstJobDone = new AtomicInteger(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
        }
        firstJobDone.incrementAndGet();
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (firstJobDone.get() != 2) {
        }
        printThird.run();
    }
}
