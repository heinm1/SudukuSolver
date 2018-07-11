package Modle;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by maxhein on 21/01/2018.
 */
public class BoardTest {

    private int[][] grid =
            {{5,0,0,4,0,0,0,2,1},
            {1,0,0,0,6,8,0,4,0},
            {0,0,8,2,1,3,0,0,0},
            {3,0,0,0,4,0,0,6,0},
            {0,6,5,0,0,0,9,3,0},
            {0,1,0,0,3,0,0,0,8},
            {0,0,0,3,5,1,2,0,0},
            {0,9,0,7,8,0,0,0,6},
            {7,5,0,0,0,2,0,0,3}};
    private Board board = new Board(grid);


    @Test
    public void getValueTest() throws Exception {
        for(int r = 0; r < board.getSize(); ++r){
            for(int c = 0; c < board.getSize(); ++c){
                assertEquals(board.getVal(r,c),grid[r][c]);
            }
        }
    }

    @Test
    public void sizeTest() throws Exception {
        assertEquals(board.getSize(), 9);
    }

    @Test
    public void setValTest() throws Exception {
        Board board2 = new Board();
        for(int r = 0; r < board.getSize(); ++r){
            for(int c = 0; c < board.getSize(); ++c){
                board2.setVal(r,c,grid[r][c]);
                assertEquals(board2.getVal(r,c),grid[r][c]);
            }
        }
    }
}