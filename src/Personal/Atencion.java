package personal;

import java.io.Serializable;

public class Atencion extends Empleado implements Serializable {
    /**
     * @param Nombre   Nombre del Trabajador
     * @param sueldo   Sueldo del Trabajador
     * @param DNI      Dni del Trabajador
     */
    private final static int SUELDO = (int) (950 * 1.1);
    private static final String nTipo = "ATENCION";

    public Atencion(String Nombre, int DNI) {
        super(Nombre,SUELDO, DNI);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) + 1);
    }
    public static int GetSueldo(){
        return SUELDO;
    }
}
