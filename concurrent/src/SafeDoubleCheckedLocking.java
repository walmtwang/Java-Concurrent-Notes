/**
 * Created by walmt on 2017/8/20.
 */
public class SafeDoubleCheckedLocking {

    private volatile static Instance instance;

    public static Instance getInstance() {
        if (instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (instance == null) {
                    instance = new Instance();  //instance为volatile，现在没问题了
                }
            }
        }
        return instance;
    }
}
