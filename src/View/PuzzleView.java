package View;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by maxhein on 19/01/2018.
 */
public class PuzzleView extends Stage {

    private TextField[][] grid;
    private Button solveButton;
    private Button resetButton;

    public PuzzleView() {

        grid = new TextField[9][9];

        setUpSolveButton();
        setUpResetButton();

        BorderPane screen = new BorderPane();
        HBox hbox = new HBox();

        screen.setCenter(setUpGrid());
        hbox.getChildren().addAll(solveButton,resetButton);
        screen.setBottom(hbox);

        Scene scene = new Scene(screen, 450, 500);
        this.setTitle("Suduku Solver");
        this.setScene(scene);
        this.setResizable(false);
    }

    private void setUpSolveButton() {
        solveButton = new Button();
        solveButton.setPrefSize(225,50);
        solveButton.setText("Solve");
    }

    private void setUpResetButton() {
        resetButton = new Button();
        resetButton.setPrefSize(225,50);
        resetButton.setText("Reset");
    }

    private GridPane setUpGrid() {
        GridPane boardView = new GridPane();
        for(int row = 0; row < 9; ++row){
            for(int col = 0; col < 9; ++col) {
                boardView.add(getNewBox(row,col),row,col);
            }
        }
        boardView.setGridLinesVisible(true);
        return boardView;
    }

    private TextField getNewBox(int row, int col){
        TextField text = new TextField();
        text.setPrefSize(50.0,50.0);
        text.setAlignment(Pos.CENTER);

        grid[row][col] = text;

        return text;
    }


    public TextField[][] getGrid(){
        return grid;
    }

    public Button getSolveButton(){
        return solveButton;
    }

    public Button getResetButton() { return resetButton; }

    public void updateGridPosition(int x, int y, String num){
        grid[x][y].setText(num);
    }
}
