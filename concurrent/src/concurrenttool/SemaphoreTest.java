package concurrenttool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by walmt on 2017/9/28.
 */
public class SemaphoreTest {
    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(()->{
                try {
                    s.acquire();
                    System.out.println("save data");
                } catch (InterruptedException ignored) {
                } finally {
                    s.release();
                }
            });
        }
        threadPool.shutdown();
    }
}
