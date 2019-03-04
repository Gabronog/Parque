import Atracciones.GestorAtracciones;
import Persona.GestorUsuarios;
import Personal.Ayudantes;
import Personal.GestorPersonal;

public class Main {
    public static void main(String[] args) {
        CargarDatos(); //Carga los datos serializados previamente de atracciones y clientes
        Ayudantes Ayudante = new Ayudantes("Pepe", 48226519);
        System.out.println(GestorPersonal.contiene(48226519));
        //GestorUsuarios.MeterUsuario((Integer)48226519,"Pepe",19,180);
        //GestorUsuarios.ObtenerDatos(48226519);
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
