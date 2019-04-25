import java.io.*;
import java.net.*;
import java.util.*;

public class PersonClient{
	public static void main(String[] args){
	 int port = 12345;  
	 try{
	    String computer = "localhost";
	    Person person1 = new Person("Joe","Black","");
	    Person person2 = new Person("Carla","Cameron","");
	    Socket socket = new Socket(computer,port);
	    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
	    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
	    outputStream.writeObject(person1);
	    outputStream.writeObject(person2);
	    Person a = (Person)input.readObject();
	    System.out.println(a.message);
	    input.close();
	    outputStream.close();
	}
	 catch(Exception e){
	      System.out.println(e);
	  }
	}
}