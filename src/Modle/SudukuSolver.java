package Modle;

/**
 * Created by maxhein on 17/01/2018.
 */
public class SudukuSolver {

    private Board board;

    /**
     *  Creats a new board class
     */
    public SudukuSolver(){
        board = new Board();
    }

    /**
     *  Solves a board, according to the suduku rules. Uses backtracking
     *
     * @param b is a 9x9 Board
     * @return a boolean true or false depending if it was sucsessfull or not
     */
    public boolean solveBoard(Board b){

        int r = -1;
        int c = -1;

        //gets the first instance in the board where there is now assigned value
        //r and c are assigned to these values
        int[] t = getNext(b);
        r = t[0];
        c = t[1];

        //if all board positions are assigned it is solved, return.
        if(r == -1 && c == -1){
            board = b;
            System.out.println(b);
            return true;
        }

        //try to assign a number from 1 to 9 to the unassigned position
        for(int num = 1; num <= 9; ++num){

            //checks if the number we are trying to assign is allowd by the rules of suduku
            if(isSafe(b,r,c,num)){
                b.setVal(r,c,num);

                //check if this iteration if the board results in a solved one
                //and if so return it. Else try another iteration
                if (solveBoard(b)) {
                    board = b;
                    return true;
                } else { b.setVal(r,c,0); }

            }
        }
        return false;

    }

    //finds the next unasign location in the board
    private int[] getNext(Board b){
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(b.getVal(i,j) == 0) {
                    int[] temp = {i, j};
                    return temp;
                }
            }
        }
        int[] temp = {-1, -1};
        return temp;
    }

    //checks if the value is leagal by checking the row, col and box
    private boolean isSafe(Board b, int row, int col, int num){

        if(checkRowCol(b,row,col,num) && checkBox(b,row,col,num))
            return true;
        else
            return false;

    }

    //checks the row and col
    private boolean checkRowCol(Board b, int row, int col, int num){
        for(int i = 0; i < 9; ++i){
            if(b.getVal(row,i) == num) return false;
            if(b.getVal(i,col) == num) return false;
        }
        return true;
    }

    //checks the box
    private boolean checkBox(Board b, int row, int col, int num){
        int i1 = (row/3)*3;
        int i2 = i1+2;
        int x1 = (col/3)*3;
        int x2 = x1+2;

        for(int i = i1; i <= i2; ++i){
            for(int x = x1; x <= x2; ++x){
                if(b.getVal(i,x) == num) { return false; }
            }
        }
        return true;
    }

    /**
     * returns the current state of the board (Compleat, empty)
     *
     * @return a Board Object
     */
    public Board getBoard(){
        return board;
    }

}
