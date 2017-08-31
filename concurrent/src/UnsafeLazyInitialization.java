/**
 * Created by walmt on 2017/8/20.
 */
public class UnsafeLazyInitialization {

    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null) {
            instance = new Instance();
        }
        return instance;
    }

//    public static Instance getInstance() {
//        if (instance == null)           //1：A线程执行
//            instance = new Instance();  //2：B线程执行
//        return instance;
//    }
}

class Instance {

}
