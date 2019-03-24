package models;
import java.io.*;
import java.util.Scanner;
public class Human extends Player {
   
    final static long serialVersionUID = 1;
    public Human(){
        super();
    }
    public Human(int player){
        super(player);
        this.player = player;
        System.out.println("Player 'Human' created!");
    }
    public int getPlayer(){
        return player;
    }
    @Override
    public String toString() {
        return " I am # " + player + " player";
    }
    @Override
    public void play(Board board,Pair p){
        Try(board,p);
        board.setPosition(attempt, player);
    }
    @Override
    public void Try(Board board,Pair p){
        do {
            do {
                System.out.print("Line: ");
                attempt[0] = p.line;

                if( attempt[0] > 3 ||attempt[0] < 1)
                    System.out.println("Invalid line. It's 1, 2 or 3");

            } while( attempt[0] > 3 ||attempt[0] < 1);

            do {
                System.out.print("Column: ");
                attempt[1] = p.column;

                if(attempt[1] > 3 ||attempt[1] < 1)
                    System.out.println("Invalid column. É 1, 2 or 3");

            } while(attempt[1] > 3 ||attempt[1] < 1);

            attempt[0]--;
            attempt[1]--;

            if(!checkTry(attempt, board))
                System.out.println("Placed already marked. Try other.");
        } while( !checkTry(attempt, board) );
    }
}
