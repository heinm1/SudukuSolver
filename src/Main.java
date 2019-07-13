import Controler.GameController;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by maxhein on 16/01/2018.
 */
public class Main extends Application {

    @Override
    public void start(Stage notUsed) throws Exception {
        new GameController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
