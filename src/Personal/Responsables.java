package Personal;

import java.io.Serializable;

public class Responsables extends TrabajadorDeAtraccion implements Serializable {
    private final static int SUELDO = (int) (950 * 1.15);
    private final static String nTipo = "RESPONSABLES";

    public Responsables(String Nombre, int DNI) {
        super(Nombre, SUELDO, DNI);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) + 1);
    }

    public static int GetSueldo(){
        return SUELDO;
    }
}

