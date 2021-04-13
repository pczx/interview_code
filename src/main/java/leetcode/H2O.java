package leetcode;

public class H2O {

    private volatile int hNum = 0;

    public H2O() {

    }


    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
       synchronized (this) {
           while (hNum == 2) {
               wait();
           }
           releaseHydrogen.run();
           hNum++;
           notifyAll();
       }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (hNum != 2) {
                wait();
            }
            releaseOxygen.run();
            hNum = 0;
            notifyAll();
        }
    }
}
