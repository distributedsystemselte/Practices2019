import java.io.*;
import java.net.*;
import java.util.*;

public class Server{
  public static void main(String[] args){
    try {
     int port = 12345;
     ServerSocket ss = new ServerSocket(port);
     Socket socket = ss.accept();
     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
     Animal a = (Animal)input.readObject();
     System.out.println(a.getName());
     input.close();
    } 
   catch(Exception e){
  
   }
 }
}
