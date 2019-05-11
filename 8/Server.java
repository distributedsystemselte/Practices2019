import java.util.*;
import java.io.*;
import java.net.*;

public class Server
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss = new ServerSocket(12345);
			while(true)
			{
				Socket s = ss.accept();
				Object lock = new Object();
				
				Thread serverThread = new Thread(new ServerThread(s, lock));
				
				serverThread.start();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class ServerThread implements Runnable
{
	Socket s;
	Object lock;
	Scanner sc;
	PrintWriter pw;
	ObjectOutputStream output;
	
	public ServerThread(Socket s, Object lock) throws Exception
	{
		this.s = s;
		this.lock = lock;
		
		sc = new Scanner(s.getInputStream());
		pw = new PrintWriter(s.getOutputStream());
		output = new ObjectOutputStream(s.getOutputStream());
	}
	
	public void run()
	{
		try
		{
			synchronized(lock)
			{
				String text = sc.nextLine();
				if(text.equals("ready"))
				{
					ConnectionToRMI c1 = new ConnectionToRMI("localhost", 12346, "StartFromZero");
					ConnectionToRMI c2 = new ConnectionToRMI("localhost", 12346, "StartFromFive");
					
					output.writeObject(c1);
					output.writeObject(c2);
				}
			}
			
			//output.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}		
	}
}