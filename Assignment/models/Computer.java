package models;

public class Computer extends Player{

    public Computer(int player){
        super(player);
        System.out.println("Player 'Computer' created");
    }

    @Override
    public void play(Board board){

    }

    @Override
    public void Try(Board board){

    }
}
