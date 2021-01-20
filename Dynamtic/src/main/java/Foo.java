/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/20 16:51
 **/
public class Foo {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> {
            System.out.println("first");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("second");
        });

        Thread t3 = new Thread(() -> {
            System.out.println("third");
        });

        /*t1.start();
        t2.start();
        t3.start();*/
        foo.first(t1);
        foo.second(t2);
        foo.third(t3);

    }
    private static final Object lock = new Object();
    private static int flag; // 1 2 3
    public Foo() {
        flag = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            while (flag != 1) {
                lock.wait();
            }
            printFirst.run();
            flag = 2;
            lock.notifyAll();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {

        synchronized (lock) {
            while (flag != 2) {
                lock.wait();
            }
            printSecond.run();
            flag = 3;
            lock.notifyAll();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (flag != 3) {
                lock.wait();
            }
            printThird.run();
            flag = 1;
            lock.notifyAll();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }
}

