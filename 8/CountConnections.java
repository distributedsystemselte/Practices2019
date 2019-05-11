import java.rmi.*;

public class CountConnections extends java.rmi.server.UnicastRemoteObject
implements CountConnectionsInterface
{
	private int n;
	
	public CountConnections() throws RemoteException
	{
		this.n = 0;
	}
	
	public CountConnections(int n) throws RemoteException
	{
		this.n = n;
	}
	
	public int countMeIn() throws RemoteException
	{
		this.n++;
		return n;
	}
	
	public int dontCountMeIn() throws RemoteException
	{
		return n;
	}
}