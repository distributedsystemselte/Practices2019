package models;


import java.util.Scanner;

public class Human extends Player{
    public Scanner input = new Scanner(System.in);

    public Human(int player){
        super(player);
        this.player = player;
        System.out.println("Player 'Human' created!");
    }

    @Override
    public void play(Board board){
        Try(board);
        board.setPosition(attempt, player);
    }

    @Override
    public void Try(Board board){
        do{
            do{
                System.out.print("Line: ");
                attempt[0] = input.nextInt();

                if( attempt[0] > 3 ||attempt[0] < 1)
                    System.out.println("Invalid line. It's 1, 2 or 3");

            }while( attempt[0] > 3 ||attempt[0] < 1);

            do{
                System.out.print("Column: ");
                attempt[1] = input.nextInt();

                if(attempt[1] > 3 ||attempt[1] < 1)
                    System.out.println("Invalid column. É 1, 2 or 3");

            }while(attempt[1] > 3 ||attempt[1] < 1);

            attempt[0]--;
            attempt[1]--;

            if(!checkTry(attempt, board))
                System.out.println("Placed already marked. Try other.");
        }while( !checkTry(attempt, board) );
    }
}
