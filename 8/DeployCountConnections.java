import java.rmi.registry.*;

public class DeployCountConnections
{
	public static void main(String[] args) throws Exception
	{
		final int PORT = 12346;
		
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("StartFromZero", new CountConnections());
		registry.rebind("StartFromFive", new CountConnections(5));
	}
}