package pervious;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by walmt on 2017/8/18.
 */
public class ReentrantLockExample {

    int a = 0;
    ReentrantLock lock = null;

    public ReentrantLock getLock() {
        return lock;
    }

    public void setLock(ReentrantLock lock) {
        this.lock = lock;
    }

    public void writer() {
        lock.lock();        //获取锁
        try {
            a++;
        } finally {
            lock.unlock();  //释放锁
        }
    }

    public void reader() {
        lock.lock();        //获取锁
        try {
            int i = a;
            //……
        } finally {
            lock.lock();    //释放锁
        }
    }

    public void test() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final ReentrantLockExample reentrantLockExample = new ReentrantLockExample();
        reentrantLockExample.setLock(new ReentrantLock(true));
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "is run");
            reentrantLockExample.test();
        };

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 20; i++) {
            threads[i].start();
        }
    }
}
