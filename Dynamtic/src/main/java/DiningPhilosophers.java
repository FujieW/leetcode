import java.util.concurrent.locks.ReentrantLock;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/22 15:41
 **/
class DiningPhilosophers {

    private ReentrantLock chops[] = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            chops[i] = new ReentrantLock();
        }

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int fork1 = philosopher;
        int fork2 = (philosopher + 1) % 5;

        chops[fork1].lock();
        chops[fork2].lock();
        // 拿起左右筷子
        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        // 放下左右筷子
        putLeftFork.run();
        putRightFork.run();

        chops[fork2].unlock();
        chops[fork1].unlock();
    }
}
