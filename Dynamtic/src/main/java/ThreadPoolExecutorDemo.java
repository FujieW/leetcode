import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/2/2 10:51
 **/
public class ThreadPoolExecutorDemo {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MyRunnable("" + i);
            executor.execute(worker);

        }

        executor.shutdown();
        while (!executor.isTerminated()) {

        }
        System.out.println("Finished all threads.");

    }
}
