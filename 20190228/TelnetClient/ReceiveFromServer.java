import java.util.*;
import java.io.*;
import java.net.*;
public class ReceiveFromServer implements Runnable{
	public Socket socket;
	public Scanner sc;
	public ReceiveFromServer(Socket socket) throws Exception{
		this.socket = socket;
		sc = new Scanner(socket.getInputStream());
	}
	public String getMsg(){
		synchronized(socket){
			return sc.nextLine();
		}
	}

	@Override
	public void run(){
		synchronized(socket){
			System.out.println("server says: " + sc.nextLine());
		}
	}
}