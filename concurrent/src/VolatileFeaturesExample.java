/**
 * Created by walmt on 2017/8/16.
 */
//public class VolatileFeaturesExample {
//
//    volatile long v1 = 0L;  //使用volatile声明64位的long型变量
//
//    public void set(long l) {   //单个volatile变量的写
//        v1 = l;
//    }
//
//    public void getAndIncrement() { //复合（多个）volatile变量的读/写
//        v1++;
//    }
//
//    public long get() { //单个volatile变量的读
//        return v1;
//    }
//}
public class VolatileFeaturesExample {

    long v1 = 0L;  //使64位的long型变量

    public synchronized void set(long l) {   //对单个的普通变量的写用同一个锁同步
        v1 = l;
    }

    public void getAndIncrement() { //普通方法调用
        long temp = get();          //调用已同步的读方法
        temp += 1L;                 //普通写操作
        set(temp);                  //调用已同步的写方法
    }

    public synchronized long get() { //对单个的普通变量的读用同一个锁同步
        return v1;
    }
}
