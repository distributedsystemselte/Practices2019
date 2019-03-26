package models;
import java.io.*;
import java.util.Scanner;

public abstract class Player implements Serializable {
    final static long serialVersionUID = 1;
    protected int[] attempt = new int[2];
    protected int player;
    public Player(){

    }
    public Player(int player){
        this.player = player;
    }
    public abstract void play(Board board,Pair p);
    public abstract boolean Try(Board board,Pair p);
    public boolean checkTry(int[] attempt, Board board){
        if(board.getPosition(attempt) == 0)
            return true;
        else
            return false;
    }
}
