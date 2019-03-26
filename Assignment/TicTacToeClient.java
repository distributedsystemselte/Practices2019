import java.util.*;
import java.io.*;
import java.net.*;
import models.*;

public class TicTacToeClient {
    public static void main(String[] args) throws Exception {
        int ServerPort = 1234;
        Scanner scn = new Scanner(System.in);           
        Socket s = new Socket("localhost", ServerPort);           
        Scanner dis = new Scanner(s.getInputStream()); 
        PrintWriter dos = new PrintWriter(s.getOutputStream()); 
        Object obj = new Object();
        Thread sendMessage = new Thread(
	        new Runnable()  
	        { 
	            @Override
	            public void run() {
                    synchronized(obj){
	                while (true) { 
                        System.out.println("Enter receipent: ");
                        String msg = scn.nextLine();
                        System.out.println("Enter the line: ");
                        int line = scn.nextInt();
                        System.out.println("Enter the row: ");
                        int row = scn.nextInt();
                        dos.println(msg);
                        dos.println(line);
                        dos.println(row);
	                    dos.flush();
	                } 
                } 
             }
	        }
        ); 
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
                synchronized(obj){
                while (true) { 
                    String msg = dis.nextLine();

                    System.out.println(msg); 
                }
               }
            } 
        }); 
  
        sendMessage.start(); 
        readMessage.start(); 
    }
}