package Controler;

import Modle.Board;
import Modle.SudokuSolver;
import View.PuzzleView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by maxhein on 16/01/2018.
 */

public class GameController {

    private Button solveButton;
    private Button resetButton;
    private PuzzleView puzzleView;

    /**
     * Creates a controller for the sudoku game
     */
    public GameController(){

        puzzleView = new PuzzleView();
        solveButton = puzzleView.getSolveButton();
        resetButton = puzzleView.getResetButton();

        setSolveButtonActionEvent();
        setResetButtonAction();

        puzzleView.show();

    }

    // Adds an action to clear the contents of the board view
    private void setResetButtonAction(){
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                for(int i = 0; i < 9; ++i) {
                    for (int j = 0; j < 9; ++j) {
                        puzzleView.updateGridPosition(i,j,"");
                    }
                }
                System.out.println("Board Reset");
            }
        });
    }

    // adds an action to solve the current state of the board view
    private void setSolveButtonActionEvent() {
        solveButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Solving ...");
                System.out.println("");

                SudokuSolver sudukuSolver = new SudokuSolver();
                Board board = new Board(format(puzzleView.getGrid()));
                try{
                    if(sudukuSolver.solveBoard(board))
                        updateGrid(sudukuSolver.getBoard());
                } catch(Exception e){
                    System.out.println("Error !");
                }

                System.out.println("Solved");
            }
        });
    }

    // converts the grid of text fields into am int grid
    private int[][] format(TextField[][] grid){

        int[][] b = new int[9][9];

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){

                String temp = grid[i][j].getText();

                if(temp.equals("")){
                    b[i][j] = 0;
                } else {
                    b[i][j] = Integer.parseInt(grid[i][j].getText());
                }
            }
        }
        return b;
    }

    // updates the text fields with the contents of the given int grid
    private void updateGrid(Board board){

        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){

                puzzleView.updateGridPosition(i,j,board.getVal(i,j)+"");
            }
        }
    }


}
