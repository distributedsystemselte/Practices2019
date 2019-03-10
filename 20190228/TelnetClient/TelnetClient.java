import java.util.*;
import java.io.*;
import java.net.*;

public class TelnetClient{
// 4.  Make an application that acts in a similar way to a telnet client. 
// The application gets a machine name and a port number
// as its two command line arguments.
// The application then connects to the port on the machine.
// Supposing the connection can be established, the application does two things simultaneously:
// if the local user types in a line on the standard input,
// the application transmits it to the server;
// in parallel to that, if the application receives a line of text from the server,
// it prints it on the standard input.

	public static void main(String[] args) throws Exception{
		String machineName = args[0];
		int portNumber = Integer.parseInt(args[1]);
		Socket socket = new Socket(machineName, portNumber);
		Scanner stdIn = new Scanner(System.in);
		SendToServer sendToServer = new SendToServer(socket);
		ReceiveFromServer receiveFromServer = new ReceiveFromServer(socket);
		new Thread(receiveFromServer).start();
		new Thread(sendToServer).start();
		while(true){
			String msg = stdIn.nextLine();
			System.out.println("you sent: " + msg);
			sendToServer.sendAmsg(msg);
			System.out.println(receiveFromServer.getMsg());
		}
	}
}