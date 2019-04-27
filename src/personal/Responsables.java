package personal;

import java.io.Serializable;

public class Responsables extends TrabajadorDeAtraccion implements Serializable {
    private static final int SUELDO = (int) (950 * 1.15);
    private static final String TIPO = "RESPONSABLES";

    public Responsables(String nombre, int dni) {
        super(nombre, dni);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(TIPO, GestorPersonal.obtenerNumero(TIPO) + 1);
    }
    public int getSUELDO() {
        return SUELDO;
    }
}

