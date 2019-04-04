import java.util.*;
import java.io.*;
import java.net.*;

public class ServerThread implements Runnable{
    Object obj;
    PrintWriter pw;
    Scanner scanner;
    ObjectOutputStream outputStream;
    public ServerThread(Socket socket,Object obj) throws Exception{
        this.obj = obj;
        scanner = new Scanner(socket.getInputStream());
        pw = new PrintWriter(socket.getOutputStream());
        outputStream = new ObjectOutputStream(socket.getOutputStream());
    }
    @Override
    public void run(){
        synchronized(obj){
            String isReady = scanner.nextLine();
            if(isReady.equals("ready")){
                ConnectionToRMI connectionRMI = new ConnectionToRMI("localhost", 1234, "something");
                try{
                    outputStream.writeObject(connectionRMI);
                    outputStream.close();
                }
                catch(Exception e){
                    System.out.println("in run : " + e);
                }
            }
        }
    }
}