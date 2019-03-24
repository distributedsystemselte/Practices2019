import java.util.*;
import java.io.*;
import java.net.*;
import models.*;

public class TicTacToeClient {
    public static void main(String[] args) throws Exception {
        int port = 1234;
        String computer = "localhost";
        try (
            Scanner userInput = new Scanner(System.in);
            Socket socket = new Socket(computer, port);
            Scanner sc = new Scanner(socket.getInputStream());
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            ){
            while(sc.nextBoolean()){
                System.out.println("Line number : ");
                int line = userInput.nextInt();
                pw.println(line);
                pw.flush();
                System.out.println("ROW number: ");
                int row = userInput.nextInt();
                pw.println(row);
                pw.flush();
            }
            
            socket.close();
            
        } 
    }
}