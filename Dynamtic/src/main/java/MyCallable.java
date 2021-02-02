import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/2/2 14:20
 **/
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return Thread.currentThread().getName();
    }
}
