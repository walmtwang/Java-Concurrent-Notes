package concurrenttool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by walmt on 2017/9/28.
 */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                c.await();
            } catch (Exception ignored) {
            }
        });
        thread.start();
        thread.interrupt();
        try {
            c.await();
        } catch (Exception e) {
            System.out.println(c.isBroken());
        }
    }
}
