package Personal;

import io.IO;

import java.util.HashMap;

public abstract class GestorPersonal {
    private static final String ARCHIVO = "DATA/Empleados";
    private static final String ARCHIVO2 = "DATA/INT";
    /**
     * Gestor de personal no asignado a una atraccion
     */
    private static HashMap<Integer, Empleado> Empleados;
    private static HashMap<String, Integer> nPersonal;

    public static void insertarEmpleado(Empleado empleado) {
        Empleados.put(empleado.getDNI(), empleado);
    }

    public static void insertarNumero(String Tipo, int numero) {
        nPersonal.put(Tipo, numero);
    }
    public static void Borrar(){
        nPersonal.clear();
        Empleados.clear();
    }
    public static int obtenerNumero(String Tipo) {
        return nPersonal.getOrDefault(Tipo,0);
    }


    public static Boolean contiene(int DNI) {
        return Empleados.containsKey(DNI);
    }

    public static Empleado Obtener(int DNI) {
        return Empleados.get(DNI);
    }

    public static void borrar(int DNI) {
        Empleados.remove(DNI);
    }

    public static void Guardar() {
        IO.Guardar(ARCHIVO, Empleados);
        IO.Guardar(ARCHIVO2, nPersonal);
    }

    public static void Cargar() {
        Empleados = (HashMap<Integer, Empleado>) IO.Cargar(ARCHIVO);
        nPersonal = (HashMap<String, Integer>) IO.Cargar(ARCHIVO2);
    }

}
