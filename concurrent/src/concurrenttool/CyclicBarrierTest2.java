package concurrenttool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by walmt on 2017/9/28.
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2, new A());

    public static void main(String[] args) {
        new Thread(()->{
            try {
                c.await();
            } catch (Exception ignored) {
            }
            System.out.println(1);
        }).start();
        try {
            c.await();
        } catch (Exception ignored) {
        }
        System.out.println(2);
    }

    static class A implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
