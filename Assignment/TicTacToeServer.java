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
        ) {
            Game game = new Game(player1,player2);
            boolean won = false;
            while(true){
                System.out.println("Enter line: ");
                int line = userInput.nextInt();
                System.out.println("Enter row: ");
                int row  =  userInput.nextInt();    
                Pair serverPair = new Pair(line,row);
                won = game.Play(serverPair);
                pw.println(won);
                pw.flush();
                if(!won){
                    break;
                }
                int lineClient = sc.nextInt();
                int rowClient = sc.nextInt();
                Pair pairClient = new Pair(lineClient,rowClient);
                won = game.Play(pairClient);
                pw.println(won);
                pw.flush();
                if(!won){
                    break;
                }  
            }
            socket.close();
        }

    }
}