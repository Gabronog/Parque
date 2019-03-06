package main;

import Atracciones.GestorAtracciones;
import Persona.GestorUsuarios;
import Personal.GestorPersonal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        CargarDatos(); //Carga los datos serializados previamente de atracciones y clientes
        //Ayudantes res = new Ayudantes("Victor",112612);
        //TODO launch(args); 20%
        //System.out.println(GestorPersonal.Obtener(12818).getNombre());
        GuardarDatos(); //Guarda los datos de las atracciones y de los clientes
    }

    private static void CargarDatos() {
        GestorUsuarios.Cargar();
        GestorAtracciones.Cargar();
        GestorPersonal.Cargar();
    }

    private static void GuardarDatos() {
        GestorAtracciones.Guardar();
        GestorUsuarios.Guardar();
        GestorPersonal.Guardar();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Launch.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("../FX/splash.fxml"));
        Launch.stage.setScene(new Scene(root, 600, 400));
        Launch.stage.show();
    }
}
