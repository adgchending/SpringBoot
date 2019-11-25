package com.cd.basic.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    private ServerSocket server;

    Server1() throws Exception {
        try {
            // 设置端口号
            server = new ServerSocket(8088);
        } catch (Exception e) {
            throw e;
        }
    }

    private void start() {
        try {

            System.out.println("等待一个客户连接...");
            //监听服务器,等待客户端连接
            Socket socket = server.accept();
            System.out.println("已连接服务器!");
            // 字节流
            InputStream in = socket.getInputStream();
            // 转换流
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            // 字符缓存输入流
            BufferedReader br = new BufferedReader(isr);
            // 字节流
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            PrintWriter pw = new PrintWriter(osw, true);
            String line = null;
            while ((line = br.readLine()) != null) {
                // 读取到的内容
                System.out.println("客户端:" + line);
                pw.println("服务器:" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // 实例化服务器
            Server1 server1 = new Server1();
            server1.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}
