package Modle;

import org.junit.Test;

import static Modle.TestData.grid;
import static org.junit.Assert.*;

/**
 * Created by maxhein on 21/01/2018.
 */
public class BoardTest {

    private Board board;

    public BoardTest() {
        board = new Board(grid);
    }

    @Test
    public void getValueTest() {
        for(int row = 0; row < board.getSize(); ++row){
            for(int col = 0; col < board.getSize(); ++col){
                assertEquals(board.getVal(row,col),grid[row][col]);
            }
        }
    }

    @Test
    public void setValTest() {
        Board board2 = new Board();
        for(int row = 0; row < board.getSize(); ++row){
            for(int col = 0; col < board.getSize(); ++col){
                board2.setVal(row,col,grid[row][col]);
                assertEquals(board2.getVal(row,col),grid[row][col]);
            }
        }
    }

    @Test
    public void sizeTest() {
        assertEquals(board.getSize(), 9);
    }
}