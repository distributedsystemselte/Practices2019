import java.util.*;
import java.io.*;
import java.net.*;
import models.*;
class ChatClient implements Runnable {
    private Scanner scn = new Scanner(System.in);
    private Object sync;
    private String name;
    private final Scanner dis;
    private final PrintWriter dos;
    private Socket s;
    private boolean isloggedin;
    private Game game;
    private int index;
    public ChatClient(Socket s, String name, int index,
        Scanner dis, PrintWriter dos, Game game) {
        this.dis = dis;
        this.index = index;
        this.dos = dos;
        this.name = name;
        this.s = s;
        this.game = game;
        this.isloggedin = true;
    }
    @Override
    public void run() {
        String received;
        int line, row;
        while (true) {
            if (TicTacToeServer.ar.size() == 2) {
                System.out.println("Enter the line: ");
                line = dis.nextInt();
                System.out.println("Enter the row: ");
                row = dis.nextInt();
                System.out.println("Move: <" + line + "," + row + ">");
                Pair pair = new Pair(line, row);
                if(!game.Play(pair)){
                    break;
                }
                game.getBoard().showBoard();
            }
        }

    }

}