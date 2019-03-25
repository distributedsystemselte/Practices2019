import java.util.*;
import java.io.*;
import java.net.*;
import models.Game;
import models.Pair;
import models.*;

public class TicTacToeServer {
    public static void main(String[] args) throws Exception{
        int port = 1234;
        Player player1 = new Human(1);
        Player player2 = new Human(2);
        Scanner userInput = new Scanner(System.in);
        try (ServerSocket ss = new ServerSocket(port);
            Socket socket = ss.accept();
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
	        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ) {
            
            Game game = new Game(player1,player2);         
            while (true)  
            { 
                socket = ss.accept();   
                Scanner dis = new Scanner(s.getInputStream()); 
                PrintWriter dos = new PrintWriter(s.getOutputStream());   
                ChatClient mtch = new ChatClient(s,"user_" + i, dis, dos); 
                Thread t = new Thread(mtch); 
                System.out.println("Adding this client to active client list"); 
                ar.add(mtch);
                t.start(); 
                i++; 
            }
        }

    }
}

class ServerThread implements Runnable{
	Socket socket;
	Scanner scanner;
	PrintWriter writer;
	
	public ServerThread(Socket s) throws Exception{
		this.socket = s;
		this.scanner = new Scanner(s.getInputStream());
		this.writer = new PrintWriter(s.getOutputStream());
	}
	
	public void run(){
		String text;
		while(true)
		while(scanner.hasNextLine()){
			text = scanner.nextLine();
			System.out.println(text);
		}
		
		
	}
	
}