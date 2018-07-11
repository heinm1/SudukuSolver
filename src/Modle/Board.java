package Modle;

/**
 * Created by maxhein on 16/01/2018.
 */
public class Board {

    private int size;
    private int[][] board;

    /**
     * Creats a new instance of a board class
     */
    public Board(){
        size = 9;
        board = new int[size][size];
    }

    /**
     * Creats a new instance of a board class
     *
     * @param board is a 2d integer list
     */
    public Board(int[][] board){
        size = 9;
        this.board = board;
    }

    /**
     * returns a integer at position x,y from the board
     *
     * @param x the row in which the value we want is in
     * @param y the col in which the value we want is in
     * @return
     */
    public int getVal(int x, int y) {
        return board[x][y];
    }

    /**
     * Sets the value at board position x,y to v
     *
     * @param x the row of the board
     * @param y the col of the board
     * @param v the value we wish to assign
     */
    public void setVal(int x, int y, int v){
        board[x][y] = v;
    }

    /**
     *  Returns the size of the board
     *
     * @return the width (or height) of the board
     */
    public int getSize(){
        return size;
    }

    /**
     * Used as a test board
     */
    public void testInitalise(){

        int[][] board = {{5,0,0,4,0,0,0,2,1},
                         {1,0,0,0,6,8,0,4,0},
                         {0,0,8,2,1,3,0,0,0},
                         {3,0,0,0,4,0,0,6,0},
                         {0,6,5,0,0,0,9,3,0},
                         {0,1,0,0,3,0,0,0,8},
                         {0,0,0,3,5,1,2,0,0},
                         {0,9,0,7,8,0,0,0,6},
                         {7,5,0,0,0,2,0,0,3}};

        this.board = board;

    }

    /**
     *  To String method prints the board
     *
     * @return the board as a string
     */
    public String toString(){
        String var = "";

        for (int[] a : board){
            for(int i : a){
                System.out.print(i);
            }
            System.out.println("");
        }

        return var;
    }
}
