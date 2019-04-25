package models;
import java.io.*;
import java.net.*;
import java.util.*;
public class Game implements Serializable {
    private Board board;
    final static long serialVersionUID = 2;
    private int turn=1, who=1;
    private Player player1;
    private Player player2;
    public Game(){
    }
    public Game(Player player1,Player player2){
        board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }
    public Board getBoard(){
        return board;
    }
    public boolean Play(Pair p){
        if(won() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nTurn "+turn);
            System.out.println("It's turn of Player " + who() );
            if(who()==1)
                player1.play(board,p);
            else
                player2.play(board,p);
            if(board.fullBoard()){
                System.out.println("Full Board. Draw!");
                return false;
            }
            who++;
            turn++;

            return true;
        } else{
            if(won() == -1 )
                System.out.println("Player 1 won!");
            else
                System.out.println("Player 2 won!");

            return false;
        }

    }
    public int who(){
        if(who%2 == 1)
            return 1;
        else
            return 2;
    }

    public int won(){
        if(board.checkLines() == 1)
            return 1;
        if(board.checkColumns() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;

        if(board.checkLines() == -1)
            return -1;
        if(board.checkColumns() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;

        return 0;
    }


}
