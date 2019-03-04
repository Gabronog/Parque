package Personal;

import io.IO;

import java.util.HashMap;

public abstract class GestorPersonal {
    private static final String ARCHIVO = "DATA/Empleados";
    /**
     * Gestor de personal no asignado a una atraccion
     */
    private static HashMap<Integer, Empleado> Empleados;

    public static void insertar(Empleado empleado) {
        Empleados.put(empleado.getDNI(), empleado);
    }

    public static boolean contiene(int DNI) {
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
    }

    public static void Cargar() {
        Empleados = (HashMap<Integer, Empleado>) IO.Cargar(ARCHIVO);
    }
}
