package concurrenthashmap;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by walmt on 2017/9/19.
 */
public class HashMapTest {
    final HashMap<String, String> map = new HashMap<String, String>(2);
    //    new Thread(() -> {
//        for (int i = 0; i < 10000; i++) {
//            new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "ftf" + i).start();
//        }
//    }, "ftf");
    Thread t = new Thread(() -> {

    })
}
