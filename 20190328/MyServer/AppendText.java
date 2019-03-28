import java.rmi.*;

public class AppendText
	extends java.rmi.server.UnicastRemoteObject
	implements AppendTextInterface{
	
	String text;
	// potato
	

	public AppendText(String text)throws RemoteException {
		this.text = text;
	}
	
	// append("tomato")
	public String append(String sentText) throws RemoteException{
		// tomatopotato
		return "a"+sentText+text;
	}
}