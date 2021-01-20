/**
 * @author fujiew
 * @TODO : wait notify 实现交替打印
 * @Create on : 2021/1/20 16:32
 **/
public class AlternatePrint {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        WaitNotify waitNotify = new WaitNotify(1,5);

        Thread t1 = new Thread(() -> {
            waitNotify.print("I am t1", 1, 2);
        }, "t1");

        Thread t2 = new Thread(() -> {
            waitNotify.print("I am t2", 2, 3);
        }, "t2");

        Thread t3 = new Thread(() -> {
            waitNotify.print("I am t3", 3, 1);
        }, "t3");

        t2.start();
        t1.start();
        t3.start();
    }
}

class WaitNotify {
    // 等待标记
    private int flag;

    // 循环次数
    private int loopNumber;


    // 打印方法
    public void print(String content, int waitFlag, int nextFlag) {
        for (int i = 0; i < this.loopNumber; i++) {
            synchronized (this) {
                while (this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(content);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }

    public int getLoopNumber() {
        return loopNumber;
    }

    public void setLoopNumber(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public WaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}