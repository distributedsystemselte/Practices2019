import java.util.*;
import java.io.*;
import java.net.*;


public class TelnetClient{
	
	public static void main (String [] args) throws Exception{
		String machine = args[0];
		int port  = Integer.parseInt(args[1]);
		
		try(
			Socket socket = new Socket(machine,port);
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			Scanner scanner = new Scanner(socket.getInputStream());
		){
			Thread printerThread = new Thread(new ClientToSrvThread(pw));
			Thread writterThread = new Thread(new SrvToClientThread(scanner));
			printerThread.start();
			
			writterThread.start();
			
			printerThread.join();
			writterThread.join();
		}
		
	}
}

class ClientToSrvThread implements Runnable{
	PrintWriter pw;
	
	ClientToSrvThread(PrintWriter pw){
		this.pw = pw;
	}
	
	@Override
	public void run(){
		Scanner scanner = new Scanner(System.in);
		while(true)			
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				pw.println(line);
				pw.flush();
			}
		
	}
}

class SrvToClientThread implements Runnable{
	Scanner sc;
	
	public SrvToClientThread(Scanner scanner){		
		this.sc = scanner;
	}
	
	public void run(){
		while(true)
		while(sc.hasNextLine()){			
			String str = sc.nextLine();
			System.out.println(str);
			System.out.flush();
		}
	}
}