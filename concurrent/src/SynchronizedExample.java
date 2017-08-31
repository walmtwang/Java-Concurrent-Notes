/**
 * Created by walmt on 2017/8/16.
 */
public class SynchronizedExample {

    int a = 0;
    boolean flag = false;

    public synchronized void writer(int i) {  //获取锁
        a = 1;
        System.out.println("w" + i);
        flag = true;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }                                   //释放锁

    public synchronized void reader(int a) { //获取锁
        if (flag) {
            int i = a;
            System.out.println("r" + a);
            //……
        }
    }                                   //释放锁

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SynchronizedExample s = new SynchronizedExample();
            int finalI = i;
            Thread t1 = new Thread(()->{
                s.writer(finalI);
            });
            Thread t2 = new Thread(()->{
                s.reader(finalI);
            });
            t1.start();
            t2.start();
        }
    }
}
