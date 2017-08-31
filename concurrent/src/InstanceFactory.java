/**
 * Created by walmt on 2017/8/20.
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //这里讲导致InstanceHolder类被初始化
    }
}
