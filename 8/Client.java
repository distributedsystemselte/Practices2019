import java.util.*;
import java.io.*;
import java.net.*;
import java.rmi.registry.*;

public class Client
{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost", 12345);
			PrintWriter pw = new PrintWriter(s.getOutputStream());
			Scanner sc = new Scanner(s.getInputStream());
			
			pw.println("ready");
			pw.flush();
			
			ObjectInputStream input =
				new ObjectInputStream(s.getInputStream());
			
			ConnectionToRMI c1 = new ConnectionToRMI("", 0, "");
			ConnectionToRMI c2 = new ConnectionToRMI("", 0, "");
			
			c1 = (ConnectionToRMI) input.readObject();
			c2 = (ConnectionToRMI) input.readObject();
			
			System.out.println(c1.getUrl() + " " + c1.getPort() + " " + c1.getServiceName());
			System.out.println(c2.getUrl() + " " + c2.getPort() + " " + c2.getServiceName());
			
			//input.close();
			
			Registry registery1 = LocateRegistry.getRegistry(c1.getUrl(), c1.getPort());
			Registry registery2 = LocateRegistry.getRegistry(c2.getUrl(), c2.getPort());

			CountConnectionsInterface cc1  =
			  (CountConnectionsInterface) registery1.lookup(c1.getServiceName());

			System.out.println(cc1.countMeIn());

			CountConnectionsInterface cc2  =
			  (CountConnectionsInterface) registery2.lookup(c2.getServiceName());

			System.out.println(cc2.dontCountMeIn());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}