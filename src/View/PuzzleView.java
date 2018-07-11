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

        solveButton = new Button();
        solveButton.setPrefSize(225,50);
        solveButton.setText("Solve");

        resetButton = new Button();
        resetButton.setPrefSize(225,50);
        resetButton.setText("Reset");

        BorderPane screen = new BorderPane();
        GridPane boardView = new GridPane();
        HBox hbox = new HBox();

        for(int r = 0; r < 9; ++r){
            for(int c = 0; c < 9; ++c) {
                boardView.add(getNewBox(r,c),r,c);
            }
        }

        boardView.setGridLinesVisible(true);

        screen.setCenter(boardView);
        hbox.getChildren().addAll(solveButton,resetButton);
        screen.setBottom(hbox);

        Scene scene = new Scene(screen, 450, 500);
        this.setTitle("Suduku Solver");
        this.setScene(scene);
        this.setResizable(false);
    }

    private TextField getNewBox(int r, int c){
        TextField text = new TextField();
        text.setPrefSize(50.0,50.0);
        text.setAlignment(Pos.CENTER);

        grid[r][c] = text;

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
