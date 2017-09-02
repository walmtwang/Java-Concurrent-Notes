package threadpool;

import java.io.*;
import java.net.Socket;

public class HttpServerTest {
    public static void main(String[] args) throws Exception {
        SimpleHttpServer.setPort(80);
        SimpleHttpServer.setBasePath("C:\\Users\\niklaus\\Desktop\\爸爸\\并发\\html");
        SimpleHttpServer.start();
    }
}
