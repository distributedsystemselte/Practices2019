package Utils;
import java.util.*;
import java.io.*;
import java.net.*;

public class User extends Thread {
	private Socket socket;
	private PrintWriter printWriter;
	private Scanner scanner;
	private Object obj;
	private String name;
	public User(Socket socket,Object obj,Scanner scanner,PrintWriter printWriter) throws Exception{
		this.socket = socket;	
		this.obj = obj;
		this.scanner = scanner;
		this.printWriter = printWriter;
	}
	public String getUserName(){
		return name;
	}
	public PrintWriter getPrintWriter()
	{
		return printWriter;
	}
	public Scanner getScanner(){
		return scanner;
	}
	public Socket getSocket(){
		return socket;
	}
	public void sendAMsg(User secondUser){
		String text = secondUser.getScanner().nextLine();
		System.out.println(text);
		printWriter.println();
		printWriter.println(text.length());
	}
	@Override
	public void run(){
		synchronized(obj){
			try{
				name = scanner.nextLine();
		        System.out.println("name of the user:" + name);
	        }
	        catch(Exception e){
	        	System.out.println(e);
	        }
        }
	}
}