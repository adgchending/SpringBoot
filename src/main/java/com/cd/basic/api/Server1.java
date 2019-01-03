package com.cd.basic.api;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    private ServerSocket server;
    Server1() throws Exception {
        try {
            server = new ServerSocket(8088);// 设置端口号
        } catch (Exception e) {
            throw e;
        }
    }
    private void start() {
        try {

            System.out.println("等待一个客户连接...");

            Socket socket = server.accept();//监听服务器,等待客户端连接
            System.out.println("已连接服务器!");
            InputStream in = socket.getInputStream();// 字节流
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");// 转换流
            BufferedReader br = new BufferedReader(isr);// 字符缓存输入流
            OutputStream os = socket.getOutputStream();// 字节流
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            PrintWriter pw = new PrintWriter(osw, true);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println("客户端:" + line);// 读取到的内容
                pw.println("服务器:" + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            Server1 server1 = new Server1();// 实例化服务器
            server1.start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}
