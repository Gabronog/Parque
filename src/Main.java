import Personal.Ayudantes;
import Personal.Responsables;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Ayudantes ayudante1 = new Ayudantes("David", 36664214, 'G');
        Responsables Pedro = Ayudantes.Ascender(ayudante1);
        ayudante1 = null;
        System.gc();
        System.out.println(Pedro);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
