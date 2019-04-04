import java.util.*;
import java.io.*;
import java.net.*;

public class Server 
{    
    public static void main(String[] args)
        throws Exception
    {
        int port = 12345;

        try (
            ServerSocket ss = new ServerSocket(port);
            Socket socket  = ss.accept();
            Scanner scanner = new Scanner(socket.getInputStream());
        ) {
            Object obj = new Object();
            String isReady = scanner.nextLine();
            if(isReady.equals("ready")){
            while(true){
                ServerThread serverThread = new ServerThread(socket,obj);
                new Thread(serverThread).start();
                }
            }
        }
    }
}

