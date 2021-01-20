/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/20 16:11
 **/
public class PrintInOrder {
    // wait  notify 实现按顺序打印
    private static final Object lock = new Object();
    private static boolean t2Run = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!t2Run) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("1");
            }

        }, "t1");


        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("2");
                t2Run = true;
                lock.notifyAll();
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
