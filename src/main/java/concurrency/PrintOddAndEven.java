package concurrency;

/**
 * 交替打印(0-100)奇数偶数
 *
 * @author chenzhengpeng
 */
public class PrintOddAndEven {

    private int count = 0;

    private Object mutex = new Object();

    class TurningRunner implements Runnable {
        @Override
        public void run() {
            synchronized (mutex) {
                while (count <= 100) {
                    System.out.println(Thread.currentThread() + " -> " + count++);
                    mutex.notifyAll();
                    try {
                        if (count <= 100) {
                            mutex.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void turning() {
        new Thread(new TurningRunner(), "打印偶数线程").start();
        new Thread(new TurningRunner(), "打印奇数线程").start();
    }

    public static void main(String[] args) {
        new PrintOddAndEven().turning();
    }
}
