// * Create and object Person (String name, String family_name, String message);
// * send two of them to the server and add the Family Name of the first one to the second one;
// * Add the message "happy wedding" and send it back to the client;
// * Print the received information from the server.

import java.io.*;
import java.net.*;
import java.util.*;

public class PersonServer{
  public static void main(String[] args){
    try {
     int port = 12345;
     ServerSocket ss = new ServerSocket(port);
     Socket socket = ss.accept();
     ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
	 ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
     Person person1 = (Person)input.readObject();
     Person person2 = (Person)input.readObject();
     person2.familyName = person1.familyName;
     person2.message = "Happy Wedding";
     outputStream.writeObject(person2);
     outputStream.close();
     input.close();
    } 
   catch(Exception e){
  
   }
 }
}
