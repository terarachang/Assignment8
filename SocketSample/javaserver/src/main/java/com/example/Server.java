package com.example;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Created by Gary on 16/5/28.
 */
public class Server extends JFrame implements Runnable{
    private Thread thread;
    private ServerSocket servSock;
    private JFrame frame = new JFrame();
    private JLabel label = new JLabel();

    public Server(){
        frame.setSize(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        frame.setVisible(true);

        try {
            // Detect server ip
            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("IP of my system is := "+IP.getHostAddress());
            System.out.println("Waitting to connect......");

            // Create server socket
            servSock = new ServerSocket(2000);

            // Create socket thread
            thread = new Thread(this);
            thread.start();
        } catch (java.io.IOException e) {
            System.out.println("Socket啟動有問題 !");
            System.out.println("IOException :" + e.toString());
        } finally{

        }
    }

    @Override
    public void run(){
        // Running for waitting multiple client
        while(true){
            try{
                // After client connected, create client socket connect with client
                Socket clntSock = servSock.accept();
                InputStream in = clntSock.getInputStream();

                System.out.println("Connected!!");

                // Transfer data
                byte[] b = new byte[1024];

                while (true) {
                    int length = in.read(b);
                    String s = new String(b);
                    System.out.println("[Server Said]" + s);
                    label.setText(s);
                }
            }
            catch(Exception e){
                //System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
