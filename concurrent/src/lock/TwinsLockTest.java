package lock;

import java.util.concurrent.locks.Lock;

/**
 * Created by walmt on 2017/9/8.
 */
public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }
        // 启动线程
        for (int i = 0; i < 10; ++i) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }
        // 每隔1秒换行
        for (int i = 0; i < 10; i++) {
            SleepUtils.second(1);
            System.out.println();
        }
    }
}
