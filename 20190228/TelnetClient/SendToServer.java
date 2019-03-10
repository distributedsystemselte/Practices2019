import java.util.*;
import java.io.*;
import java.net.*;

public class SendToServer implements Runnable{
	public Socket socket;
	public PrintWriter pw;
	public SendToServer(Socket socket) throws Exception{
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream());
	}
	public void sendAmsg(String msg){
		synchronized(socket){
			pw.println(msg);
			pw.flush();
		}
	}
	@Override
	public void run(){
		synchronized(socket){
			
		}
	}
}