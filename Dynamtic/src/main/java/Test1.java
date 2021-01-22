import java.util.concurrent.TimeUnit;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/22 09:30
 **/
public class Test1 {

    private static final Object room = new Object();
    private static boolean hasCigarette = false;

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (room) {
                System.out.println("有烟没");
                while (!hasCigarette) {
                    try {
                        System.out.println("没烟，先歇会");
                        room.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("有烟没" + hasCigarette);
                System.out.println("可以开始干活了");
            }
        }, "小南").start();

        new Thread(() -> {
            synchronized (room) {
                hasCigarette = true;
                System.out.println("送烟的");
                room.notifyAll();
            }
        }, "送烟的").start();
    }
}
