import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
	public static void main (String [] args){
		
		int port = 12345;
				
		try{
			ServerSocket ss = new ServerSocket(port);
			Socket socket = ss.accept();				
			
			ObjectInputStream input = 
				new ObjectInputStream(socket.getInputStream());
			
						
			ObjectOutputStream outputStream = 
				new ObjectOutputStream(socket.getOutputStream());
							
			Animal a = (Animal)input.readObject();
			
			System.out.println(a.getName());
			
			socket.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
}