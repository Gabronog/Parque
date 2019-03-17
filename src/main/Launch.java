package main;

import Atracciones.*;
import Estadisticas.GestorGastos;
import Persona.GestorUsuarios;
import Personal.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static main.DatosEnunciado.cargarDatosEnunciado;

public class Launch extends Application {
    public static Stage stage;

    public static void main(String[] args) {
        CargarDatos(); //Carga los datos serializados previamente de atracciones y clientes

        //cargarDatosEnunciado();

        //TODO GUI 35%

        GuardarDatos(); //Guarda los datos de las atracciones y de los clientes
        ComprobarFecha.comprobar();
    }

    private static void CargarDatos() {
        GestorUsuarios.Cargar();
        GestorAtracciones.Cargar();
        GestorPersonal.Cargar();
        GestorGastos.Cargar();
    }

    private static void GuardarDatos() {
        GestorAtracciones.Guardar();
        GestorUsuarios.Guardar();
        GestorPersonal.Guardar();
        GestorGastos.Guardar();
    }

    static void BorrarDatos(){
        GestorAtracciones.Borrar();
        GestorUsuarios.Borrar();
        GestorPersonal.Borrar();
        GuardarDatos();
    }



    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Launch.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("../FX/FXML/splash.fxml"));
        Launch.stage.setScene(new Scene(root, 600, 400));
        Launch.stage.show();
    }
}
