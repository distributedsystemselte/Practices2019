package models;


public class Board {
    private int[][] Board= new int[3][3];

    public Board(){
        clearBoard();
    }

    public void clearBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                Board[line][column]=0;
    }

    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){

            for(int column=0 ; column<3 ; column++){

                if(Board[line][column]==-1){
                    System.out.print(" X ");
                }
                if(Board[line][column]==1){
                    System.out.print(" O ");
                }
                if(Board[line][column]==0){
                    System.out.print("   ");
                }

                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }

    }

    public int getPosition(int[] attempt){
        return Board[attempt[0]][attempt[1]];
    }

    public void setPosition(int[] attempt, int player){
        if(player == 1)
            Board[attempt[0]][attempt[1]] = -1;
        else
            Board[attempt[0]][attempt[1]] = 1;
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (Board[line][0] + Board[line][1] + Board[line][2]) == -3)
                return -1;
            if( (Board[line][0] + Board[line][1] + Board[line][2]) == 3)
                return 1;
        }

        return 0;

    }

    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (Board[0][column] + Board[1][column] + Board[2][column]) == -3)
                return -1;
            if( (Board[0][column] + Board[1][column] + Board[2][column]) == 3)
                return 1;
        }

        return 0;

    }

    public int checkDiagonals(){
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == -3)
            return -1;
        if( (Board[0][0] + Board[1][1] + Board[2][2]) == 3)
            return 1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == -3)
            return -1;
        if( (Board[0][2] + Board[1][1] + Board[2][0]) == 3)
            return 1;

        return 0;
    }

    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( Board[line][column]==0 )
                    return false;
        return true;
    }
}
