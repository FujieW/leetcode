import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/22 14:09
 **/
public class TestReentrantLock3 {

    private static final ReentrantLock ROOM = new ReentrantLock();

    // 等外卖
    private static final Condition waitTakeout = ROOM.newCondition();
    // 等烟
    private static final Condition waitCigarette = ROOM.newCondition();

    private static boolean hasCigarette = false;

    private static boolean hasTakeout = false;

    public static void main(String[] args) throws InterruptedException {

        /*// 创建一个新的条件变量（可以理解为休息室）
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        lock.lock();
        // 进入休息室1 等待
        condition1.await();

        // 叫醒休息室1里的某一个线程
        condition1.signal();
        // 叫醒休息室1里的全部线程
        condition1.signalAll();*/
        new Thread(() -> {
            ROOM.lock();
            try {
                System.out.println("有吃的没 " + hasTakeout);
                while (!hasTakeout) {
                    try {
                        System.out.println("没有吃的");
                        waitTakeout.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //
                System.out.println("外卖来了，吃完了干活");
            } finally {
                ROOM.unlock();
            }
        }, "小女").start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            ROOM.lock();
            try{
                System.out.println("你好，你的外卖到了");
                hasTakeout = true;
                waitTakeout.signal();
            } finally {
                ROOM.unlock();
            }
        }).start();
    }
}
