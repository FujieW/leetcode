import java.util.concurrent.locks.LockSupport;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/20 16:23
 **/
public class PrintInOrder2 {
    // park unpark 实现按顺序打印
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println(1);
        }, "t1");
        t1.start();

        new Thread(() -> {
            System.out.println(2);
            LockSupport.unpark(t1);
        }, "t2").start();
    }
}
