import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
	
	public static void main(String [] args){
		int port=12345;
		String computer = "localhost";
		
		Animal animal = new Animal("Cat Joe");
		
		try{
			Socket socket = new Socket(computer, port);
			
			ObjectOutputStream outputStream = 
				new ObjectOutputStream(socket.getOutputStream());
				
			ObjectInputStream input = 
				new ObjectInputStream(socket.getInputStream());
				
			outputStream.writeObject(animal);
			
			System.out.println(animal.getName());
			
			outputStream.close();
			
			input.readObject();
			
			
			
		}catch(Exception e){
			System.out.println(e);
			
		}
	}
	
	
	
}
