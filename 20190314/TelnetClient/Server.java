import java.util.*;
import java.io.*;
import java.net.*;

public class Server{
    public static void main(String[] args)
        throws Exception
    {
        int port = 12345;

        try (
            ServerSocket ss = new ServerSocket(port);
        ) {
			while(true){
				Socket s  = ss.accept();			
				System.out.println("First guy aboard");
				Thread serverThread = new Thread(
								new ServerThread(s));
				
				serverThread.start();
			}
			//serverThread.join();

        }catch(Exception e ){}

    }
}

class ServerThread implements Runnable{
	Socket socket;
	Scanner scanner;
	PrintWriter writer;
	
	public ServerThread(Socket s) throws Exception{
		this.socket = s;
		this.scanner = new Scanner(s.getInputStream());
		this.writer = new PrintWriter(s.getOutputStream());
	}
	
	public void run(){
		String text;
		while(true)
		while(scanner.hasNextLine()){
			text = scanner.nextLine();
			System.out.println(text);
		}
		
		
	}
	
}
