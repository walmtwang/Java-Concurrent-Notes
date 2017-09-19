package pervious;

import java.util.concurrent.TimeUnit;

/**
 * Created by walmt on 2017/8/24.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
