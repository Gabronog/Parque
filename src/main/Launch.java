package main;

import Atracciones.*;
import Persona.GestorUsuarios;
import Personal.Ayudantes;
import Personal.GestorPersonal;
import Personal.Responsables;
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

        cargarDatosEnunciado();

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

    public static void BorrarDatos(){
        GestorAtracciones.Borrar();
        GestorUsuarios.Borrar();
        GestorPersonal.Borrar();
        GuardarDatos();
    }

    public static void cargarDatosEnunciado(){
        BorrarDatos();
        int UltimoAyudante = 0,UltimoResponsable = 0;
        for(int i=1;i<131;i++){
            GestorPersonal.insertarEmpleado(new Ayudantes("A"+i,i));
        }
        for(int i=131;i<157;i++){
            GestorPersonal.insertarEmpleado(new Responsables("R"+i,i));
        }
        for(int i=0;i<4;i++){
            Ayudantes[] ayudantes = new Ayudantes[6];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(131+i);
            UltimoResponsable = 131+i;
            for(int k=1;k<7;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(k+(i*6));
                UltimoAyudante = k+(i*6);
            }
            new A(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4],ayudantes[5]);
        }
        UltimoResponsable++;
        UltimoAyudante++;
        for(int i=0;i<5;i++){
            Ayudantes[] ayudantes = new Ayudantes[5];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<6;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new B(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        UltimoResponsable++;
        UltimoAyudante++;
        for(int i=0;i<4;i++){
            Ayudantes[] ayudantes = new Ayudantes[3];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<4;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new C(r1,ayudantes[0],ayudantes[1],ayudantes[2]);
        }
        for(int i=0;i<3;i++){
            Ayudantes[] ayudantes = new Ayudantes[5];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<6;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new D(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        for(int i=0;i<7;i++){
            Ayudantes[] ayudantes = new Ayudantes[7];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<8;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new E(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4],ayudantes[5],ayudantes[6]);
        }

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
