import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CountConnectionsInterface extends Remote
{
	int countMeIn() throws RemoteException;
	int dontCountMeIn() throws RemoteException;
}