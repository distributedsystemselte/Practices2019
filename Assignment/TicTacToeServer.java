import java.util.*;
import java.io.*;
import java.net.*;
import models.Game;
import models.Pair;
import models.*;

public class TicTacToeServer {
    static Vector<ChatClient> ar = new Vector<>(); 
    static int i = 0;  
    public static void main(String[] args) throws Exception{
        int port = 1234;
        Player player1 = new Human(1);
        Player player2 = new Human(2);
        Scanner userInput = new Scanner(System.in);
        try (ServerSocket ss = new ServerSocket(port);
           
            // Scanner sc = new Scanner(socket.getInputStream());
            // PrintWriter pw = new PrintWriter(socket.getOutputStream());
            // ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
	        // ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
        ) {
            
            Game game = new Game(player1,player2); 
            Object sync = new Object();
            while (true)  
            { 
                Socket socket = ss.accept();   
                Scanner dis = new Scanner(socket.getInputStream()); 
                PrintWriter dos = new PrintWriter(socket.getOutputStream()); 
                ChatClient mtch = new ChatClient(socket,"user_" + i, dis, dos,game,sync); 
                System.out.println("user_"+i + " is connected");  
                Thread t = new Thread(mtch); 
                System.out.println("Adding this client to active client list"); 
                ar.add(mtch);
                t.start(); 
                i++; 
            }
        }

    }
}
