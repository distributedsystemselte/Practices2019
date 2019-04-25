import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
// instruction run this with : java Client user_1 -> means first 0th client wants to talk to 1st client
// second client should connect to the first one by writing java Client user_0
public class Client  
{ 
    final static int ServerPort = 1234; 
    public static void main(String args[]) throws UnknownHostException, IOException  
    { 
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