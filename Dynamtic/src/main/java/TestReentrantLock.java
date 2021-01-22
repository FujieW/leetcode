import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/22 10:58
 **/
public class TestReentrantLock {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                // 如果没有竞争，此方法就会获取lock对象锁
                // 如果有竞争，就会进入阻塞队列
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                System.out.println("t1被打断了");
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();

        // 主线程加锁，使 t1 阻塞
        lock.lock();
        System.out.println("主线程获得锁");
        TimeUnit.SECONDS.sleep(2);
        // 打断 t1
        System.out.println("打断t1");
        t1.interrupt();

    }
}
