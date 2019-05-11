import java.rmi.*;

public class CalculatorOne
	extends java.rmi.server.UnicastRemoteObject
	implements CalculatorInterface {
	int num;
	// potato
	@Override
	public void setNum(int num) throws RemoteException {
		this.num = num;
	}
	public CalculatorOne(int num)throws RemoteException {
		this.num = num;
	}
	@Override
	public int add(int num) throws RemoteException{
		return this.num+num;
    }
    @Override
	public int sub(int num) throws RemoteException{
		return this.num-num;
	}
	@Override
	public int div(int num) throws RemoteException{
        if(num == 0) return 0;
		return this.num/num;
	}
	@Override
	public int mul(int num) throws RemoteException{
		return this.num*num;
		}

}