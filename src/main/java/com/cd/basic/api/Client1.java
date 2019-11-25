package com.cd.basic.api;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    private Socket socket;

    Client1() throws Exception {//构造方法,开始new就开始尝试连接
        try {
            System.out.println("正在连接服务器");
            socket = new Socket("localhost",8088);
            System.out.println("服务器已连接");
        } catch (Exception e) {
            throw e;
        }
    }

    public void start() throws Exception{//启动
        try {
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            PrintWriter pw = new PrintWriter(osw,true);
            Scanner sc = new Scanner(System.in);
            String str = null;
            while(true){
                System.out.println("输入内容");
                str = sc.nextLine();
                pw.println(str);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void run() throws IOException{
        try {
            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            String message = null;
            while((message=br.readLine())!=null){
                System.out.println(message);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        Client1 client1;
        try {
            //开始尝试连接
            client1 = new Client1();
            client1.start();
            client1.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
