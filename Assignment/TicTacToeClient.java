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
        String name = args[0];
        Thread sendMessage = new Thread(
	        new Runnable()  
	        { 
	            @Override
	            public void run() { 
	                while (true) { 
	                	String msg = scn.nextLine(); 
	                	String response=msg+"#"+name;
	                    dos.println(response); 
	                    dos.flush();
	                } 
	            } 
	        }
        ); 
        Thread readMessage = new Thread(new Runnable()  
        { 
            @Override
            public void run() { 
  
                while (true) { 
                    String msg = dis.nextLine(); 
                    System.out.println(msg); 
                } 
            } 
        }); 
  
        sendMessage.start(); 
        readMessage.start(); 
    }
}