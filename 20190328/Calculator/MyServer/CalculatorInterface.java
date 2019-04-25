import java.rmi.Remote;
import java.rmi.RemoteException;


public interface CalculatorInterface extends Remote{
	void setNum(int num) throws RemoteException;
	int add(int num) throws RemoteException;
	int sub(int num) throws RemoteException;
	int div(int num) throws RemoteException;
	int mul(int num) throws RemoteException;
}