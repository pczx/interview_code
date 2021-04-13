package leetcode;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.*;

public class FooBar {
    private int n;

    private BlockingQueue<Integer> b1 = new LinkedBlockingDeque<>();

    private BlockingQueue<Integer> b2 = new LinkedBlockingDeque<>();

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b1.put(i);
            printFoo.run();
            b2.take();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b1.take();
            printBar.run();
            b2.put(i);
        }
    }
}
