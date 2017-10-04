package threadpoolExecutor;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by walmt on 2017/10/1.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new SynchronousQueue<>());
        threadPoolExecutor.execute(() -> {
            // TODO: 2017/10/2
        });
    }
}
