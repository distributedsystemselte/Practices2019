import java.rmi.*;

public class CalculatorTwo
	extends java.rmi.server.UnicastRemoteObject
	implements CalculatorInterface{
	int num;
	public CalculatorTwo()throws RemoteException {
		this.num = 0;
    }
    @Override
	public void setNum(int num){
        this.num = num;
    }
	@Override
	public int add(int num) throws RemoteException{
		return this.num+num;
    }
    @Override
	public int sub(int num) throws RemoteException{
		return this.num-num;
    }	@Override
	public int div(int num) throws RemoteException{
        if(num == 0) return 0;
		return this.num/num;
    }	@Override
	public int mul(int num) throws RemoteException{
		return this.num*num;
    }
}