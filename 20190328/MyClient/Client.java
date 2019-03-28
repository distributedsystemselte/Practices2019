import java.rmi.registry.*;

public class Client{
	public static void main (String [] args)throws Exception{
		
		String host = "localhost";
		int port = 12345;
		String srvName = "rmiAppendGuy";
		String text = "potato";
		
		Registry registry = LocateRegistry.getRegistry(host,port);
		
		String [] registers = registry.list();
		
		for(String a :registers)
				System.out.println(a);
		
		AppendTextInterface appendText = 
			(AppendTextInterface)(registry.lookup(srvName));
			
		String response = appendText.append(text);
		System.out.println(response);
		
	}
	
}