import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by walmt on 2017/8/11.
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);

    private Integer i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(100);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用CAS实现线程安全计数器
     */
    public void safeCount() {
        while (true) {
            int i = atomicI.get();
            if (atomicI.compareAndSet(i, ++i)) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    public void count() {
        i++;
    }
}
