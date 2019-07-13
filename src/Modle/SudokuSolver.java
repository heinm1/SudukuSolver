package Modle;

/**
 * Created by maxhein on 17/01/2018.
 */
public class SudokuSolver {

    // Stores the solved board
    private Board board;

    /**
     *  Creates a new board class
     */
    public SudokuSolver(){
        board = new Board();
    }

    /**
     *  Solves a board, according to the sudoku rules. Uses backtracking
     *
     * @param b is a 9x9 Board
     * @return a boolean true or false depending if it was successful or not
     */
    public boolean solveBoard(Board b){

        int row = -1;
        int col = -1;

        // gets the first instance in the board where there is now assigned value
        // row and col are assigned to these values
        int[] t = getNext(b);
        row = t[0];
        col = t[1];

        // if all board positions are assigned it is solved, return.
        if(row == -1 && col == -1){
            board = b;
            System.out.println(b);
            return true;
        }

        // try to assign a number from 1 to 9 to the unassigned position
        for(int num = 1; num <= 9; ++num){

            // checks if the number we are trying to assign is allowed by the rules of sudoku
            if(isSafe(b,row,col,num)){
                b.setVal(row,col,num);

                // check if this iteration if the board results in a solved one
                // and if so return it. Else try another iteration
                if (solveBoard(b)) {
                    board = b;
                    return true;
                } else { b.setVal(row,col,0); }

            }
        }
        return false;

    }

    // finds the next unassigned location in the board
    private int[] getNext(Board b){
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                if(b.getVal(i,j) == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // if the value is legal by checking the row, col and box
    private boolean isSafe(Board b, int row, int col, int num){

        return checkRowCol(b,row,col,num) && checkBox(b,row,col,num);

    }

    // checks the row and col
    private boolean checkRowCol(Board b, int row, int col, int num){
        for(int i = 0; i < 9; ++i){
            if(b.getVal(row,i) == num) return false;
            if(b.getVal(i,col) == num) return false;
        }
        return true;
    }

    // checks the 3x3 box for the given cell
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
     * returns the current state of the board (complete, empty)
     *
     * @return a Board Object
     */
    public Board getBoard(){
        return board;
    }

}
