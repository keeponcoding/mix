package com.cll.mix.netty;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @ClassName IOClient1
 * @Description TODO
 * @Author cll
 * @Date 2019-12-16 11:19
 * @Version 1.0
 **/
public class IOClient1 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world from IOClient1").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }

}
