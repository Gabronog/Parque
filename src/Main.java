import Atracciones.GestorAtracciones;
import Persona.GestorUsuarios;
import Personal.GestorPersonal;

public class Main {
    public static void main(String[] args) {
        CargarDatos(); //Carga los datos serializados previamente de atracciones y clientes

        //TODO GUI

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
}
