package Modle;

import org.junit.Test;

import static Modle.TestData.grid;
import static Modle.TestData.solvedGrid;
import static org.junit.Assert.*;

/**
 * Created by maxhein on 21/01/2018.
 */
public class SudokuSolverTest {

    private SudokuSolver sudokuSolver;

    public SudokuSolverTest() {
        sudokuSolver = new SudokuSolver();
    }

    @Test
    public void solveBoard() {
        sudokuSolver.solveBoard(new Board(grid));

        for(int row = 0; row < 9; ++row){
            for(int col = 0; col < 9; ++col){
                assertEquals(sudokuSolver.getBoard().getVal(row, col), solvedGrid[row][col]);
            }
        }
    }

}