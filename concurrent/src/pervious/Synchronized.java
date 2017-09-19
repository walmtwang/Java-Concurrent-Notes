package pervious;

/**
 * Created by walmt on 2017/8/26.
 */
public class Synchronized {
    public static void main(String[] args) {
        //对Synchronized Class对象进行加锁
        synchronized (Synchronized.class) {
        }

        //静态同步方法，对Synchronized Class对象进行加锁
        m();
    }

    public static synchronized void m() {
    }
}
