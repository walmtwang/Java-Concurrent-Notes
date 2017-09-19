package pervious;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


/**
 * Created by walmt on 2017/8/25.
 */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Thread printThread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Run at " + sdf.format(new Date()));
                SleepUtils.second(1);
            }
        }, "PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //将PrintThread进行暂停，输出内容工作停止
        printThread.suspend();
        System.out.println("main suspend PrintThread at " + sdf.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //将PrintThread进行恢复，输出内容继续
        printThread.resume();
        System.out.println("main resume PrintThread at " + sdf.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        //将PrintThread进行终止，输出内容停止
        printThread.stop();
        System.out.println("main stop PrintThread at " + sdf.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
    }
}
