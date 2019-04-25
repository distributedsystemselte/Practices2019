import java.net.*;
import java.io.*;
import java.util.*;
public class TelnetClient{
 public static void main(String[] args) throws Exception{
   String machine = args[0];
   int port = Integer.parseInt(args[1]);
   try(
	Socket socket = new Socket(machine,port);
	PrintWriter pw = new PrintWriter(socket.getOutputStream());

    ) {
	Thread printerThread = new Thread(new ClientToSrvThread(pw));
	printerThread.start();
    }
 }
}

class ClientToSrvThread implements Runnable{
  PrintWriter pw;
  
  public ClientToSrvThread(PrintWriter pw){
    this.pw = pw;
    }
  @Override
  public void run(){
	Scanner scanner = new Scanner(System.in);
	while(true)
	    while(scanner.hasNextLine()){
		String line = scanner.nextLine();
		pw.println(line);
		pw.flush();
	    }
  }
}
