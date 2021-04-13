package concurrency;

public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        threadA.join();
        System.out.println(Thread.currentThread().getName());
    }
}
