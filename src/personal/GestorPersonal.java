package personal;

import io.IO;

import java.util.HashMap;
import java.util.logging.Logger;

import static main.LOG.getStackTrace;

public final class GestorPersonal extends IO{
    /**
     * Gestor de personal no asignado a una atraccion
     * Guarda tanto el personal no asignado a una atraccion como el numero de empleados
     */
    private static HashMap<Integer, Empleado> empleados;
    private static HashMap<String, Integer> nPersonal;
    private static final String ARCHIVO = "DATA/empleados";
    private static final String ARCHIVO2 = "DATA/INT";
    private static final Logger LOGGER = Logger.getLogger(GestorPersonal.class.getName());

    public static void insertarEmpleado(Empleado empleado) {
        empleados.put(empleado.getDni(), empleado);
        LOGGER.info("Guardado el empleado con DNI" + empleado.getDni());
    }

    public static void insertarNumero(String tipo, int numero) {
        nPersonal.put(tipo, numero);
    }
    public static void borrar(){
            try{
                nPersonal.clear();
                empleados.clear();
            }
            catch (NullPointerException n){
                LOGGER.warning(getStackTrace(n));
                LOGGER.warning("Lista ya vacia");
            }
    }
    public static int obtenerNumero(String tipo) {
        return nPersonal.getOrDefault(tipo,0);
    }


    public static Boolean contiene(int dni) {
        return empleados.containsKey(dni);
    }

    public static Empleado obtener(int dni) {
        return empleados.get(dni);
    }

    public static void borrar(int dni) {
        empleados.remove(dni);
    }

    private GestorPersonal(){
        LOGGER.info("NO SE PUEDEN INSTANCIAR LOS METODOS ESTATICOS POR FAVOR USE SUS METODOS ESTATICOS");
    }

    public static void save() {
        guardar(ARCHIVO, empleados);
        guardar(ARCHIVO2, nPersonal);
    }

    public static void load() {
        empleados = (HashMap<Integer, Empleado>) cargar(ARCHIVO);
        nPersonal = (HashMap<String, Integer>) cargar(ARCHIVO2);
    }

}
