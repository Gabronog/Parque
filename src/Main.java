import Atracciones.GestorAtracciones;
import Persona.GestorUsuarios;

public class Main {
    public static void main(String[] args) {
        CargarDatos(); //Carga los datos serializados previamente de atracciones y clientes

        GuardarDatos(); //Guarda los datos de las atracciones y de los clientes
    }

    private static void CargarDatos() {
        GestorUsuarios.Cargar();
        GestorAtracciones.Cargar();
    }

    private static void GuardarDatos() {
        GestorAtracciones.Guardar();
        GestorUsuarios.Guardar();
    }
}
