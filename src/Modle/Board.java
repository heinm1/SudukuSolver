package Modle;

/**
 * Created by maxhein on 16/01/2018.
 */
public class Board {

    private int size;
    private int[][] board;

    /**
     * Creates a new instance of a board class
     */
    public Board(){
        size = 9;
        board = new int[size][size];
    }

    /**
     * Creates a new instance of a board class
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
     * @return the value of the board at the given position
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
