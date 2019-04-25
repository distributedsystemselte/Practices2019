import java.rmi.registry.*;

public class RMIDeploy{
	public static void main (String [] args) throws Exception{
		final int PORT = 12345;
		Registry registry = LocateRegistry.createRegistry(PORT);
		registry.rebind("calculateOne", new CalculatorOne(10));
		registry.rebind("calculateTwo", new CalculatorTwo());		
	}
}