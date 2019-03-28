import java.rmi.registry.*;

public class RMIDeploy{
	public static void main (String [] args) throws Exception{
		final int PORT = 12345;
		
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("rmiAppendGuy", new AppendText("tomato"));
		registry.rebind("rmiAppendGirl", new AppendText("ooowwGirl"));
		
	}
	
}