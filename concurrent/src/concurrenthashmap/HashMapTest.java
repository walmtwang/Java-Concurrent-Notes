package concurrenthashmap;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by walmt on 2017/9/19.
 */
public class HashMapTest {
    final HashMap<String, String> map = new HashMap<>(2);

    public void hashMapTest() throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "ftf" + i).start();
            }
            System.out.println(map.size());
        }, "ftf");
        t.start();
        t.join();
    }

    public static void main(String[] args) throws InterruptedException {
        HashMapTest hashMapTest = new HashMapTest();
        hashMapTest.hashMapTest();
    }
}
