import Controler.GameControler;
import View.PuzzleView;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by maxhein on 16/01/2018.
 */
public class Main extends Application {

    @Override
    public void start(Stage notUsed) throws Exception {

        PuzzleView primaryStage = new PuzzleView();

        GameControler gameControler = new GameControler(primaryStage);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
