import java.util.*;
import java.io.*;
import java.net.*;
import Utils.User;

public class Server{
        public static void main(String[] args){
        int PORT = 12345;
        String computer = "localhost";
        ServerSocket serverSocket = null;
        PrintWriter printToUsers = null;
        Scanner scanner = null;
        Socket socket = null;
        Object obj = new Object();

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<User> users = new ArrayList<>();
        int n=0;
        while (true) {
            try {
                socket = serverSocket.accept();
                printToUsers = new PrintWriter(socket.getOutputStream());
                scanner = new Scanner(socket.getInputStream());
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            try{
            	n++;
            	System.out.println("Connected users= "+n);
            	User user1 = new User(socket,obj,scanner,printToUsers);
            	users.add(user1);
		        user1.start();
	        }            
            catch (Exception e){
            	System.out.println(e);
            }
            if(n == 2){
            	System.out.println("init the msgs = " + n);
            	users.get(0).getPrintWriter().println(1);
            	users.get(0).getPrintWriter().flush();
            	users.get(1).getPrintWriter().println(1);
            	users.get(1).getPrintWriter().flush();
            	String name0 = users.get(0).getUserName();
            	String name1 = users.get(1).getUserName();
            	String user0Text = users.get(0).getScanner().nextLine();
            	String user1Text = users.get(1).getScanner().nextLine();
            	users.get(0).getPrintWriter().println(user1Text);
            	users.get(0).getPrintWriter().flush();
            	users.get(1).getPrintWriter().println(user0Text);
            	users.get(1).getPrintWriter().flush();
            	System.out.println(name0+ " says: " + user0Text);
            	System.out.println(name1+ " says: " + user1Text);
            }
        }
        	
	}
 }

