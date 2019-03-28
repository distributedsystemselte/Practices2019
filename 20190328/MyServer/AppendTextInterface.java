import java.rmi.Remote;
import java.rmi.RemoteException;


public interface AppendTextInterface extends Remote{
	
	String append(String text) throws RemoteException;

}