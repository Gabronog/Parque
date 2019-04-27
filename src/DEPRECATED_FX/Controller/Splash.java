/*
package FX.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Launch;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Splash extends Borderless implements Initializable {

    @FXML
    private ImageView image;

    private double xOffSet = 0;
    private double yOffSet = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        makeStageDragable();
        Image image1 = new Image("Icons/icons8-delete-64.png");
        image.setImage(image1);
    }

    @FXML
    private void irClientes() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FX/FXML/Clientes.fxml"));
        Launch.stage.setScene(new Scene(root, 1024, 720));
    }

    @FXML
    private void irGerente() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/FX/FXML/Gestor.fxml"));
        Launch.stage.setScene(new Scene(root, 1024, 720));

    }
}
*/
