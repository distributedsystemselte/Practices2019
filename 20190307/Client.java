import java.io.*;
import java.net.*;
import java.util.*;
public class Client{
  public static void main(String[] args){
    int port = 12345;
    try{
      String computer = "localhost";
      Animal animal = new Animal("Cat Joe");
      Socket socket = new Socket(computer,port);
      ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
      outputStream.writeObject(animal);
      outputStream.close();
    }
    catch (Exception e){
      System.out.println(e);
    }
  }
}
