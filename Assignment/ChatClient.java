
import java.util.*;
import java.io.*;
import java.net.*;
import models.*;
class ChatClient implements Runnable {
    Scanner scn = new Scanner(System.in);
    Object sync;
    private String name;
    final Scanner dis;
    final PrintWriter dos;
    Socket s;
    boolean isloggedin;
    Game game;
    public ChatClient(Socket s, String name, 
                            Scanner dis, PrintWriter dos,Game game,Object sync) { 
        this.dis = dis; 
        this.dos = dos; 
        this.name = name; 
        this.s = s; 
        this.sync = sync;
        this.game = game;
        this.isloggedin=true; 
    }

    @Override
    public void run() { 
            String received;
            int line,row;
            while (true)  
            { 
                    System.out.println("Enter receipent: ");
                    String recipient = "user_"+dis.nextLine(); 
                    System.out.println("Enter the line: ");
                    line = dis.nextInt();
                    System.out.println("Enter the row: ");
                    row  = dis.nextInt();
                    System.out.println("sending to "+ recipient + ": <" + line + "," + row + ">" );
                    for (ChatClient mc : TicTacToeServer.ar)  
                    { 
                        System.out.println(mc.name + " <-> " + this.name);
                        if (mc.name.equals(recipient) && mc.isloggedin)  
                        { 
                            System.out.println(this.name + ": <" + line + "," + row + ">" );
                            Pair pair = new Pair(line,row);
                            game.Play(pair);
                            game.getBoard().showBoard();
                            // mc.dos.println(this.name + ": <" + line + "," + row + ">" );
                            // mc.dos.flush();
                            break; 
                        } 
                    } 
               }   
    }

} 