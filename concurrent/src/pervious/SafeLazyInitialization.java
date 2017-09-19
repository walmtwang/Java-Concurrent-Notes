package pervious;

/**
 * Created by walmt on 2017/8/20.
 */
public class SafeLazyInitialization {

    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }
}