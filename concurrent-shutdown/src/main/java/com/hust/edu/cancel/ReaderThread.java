package com.hust.edu.cancel;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * locate com.hust.edu.cancel
 * Created by MasterTj on 2019/1/9.
 */
public class ReaderThread extends Thread {
    private final Socket socket;
    private final InputStream inputStream;
    public static final int BUFSIZE=1024;

    public ReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.inputStream=socket.getInputStream();
    }

    @Override
    public void interrupt() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            super.interrupt();
        }
    }

    @Override
    public void run() {
        byte [] buf=new byte[BUFSIZE];
        try {
            while (true) {
                int count= inputStream.read(buf);
                //dosomething
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
