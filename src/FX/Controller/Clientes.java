package FX.Controller;

import FX.Controller.Borderless;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Clientes extends Borderless implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
    }
}
