package personal;

import java.io.Serializable;

public abstract class Empleado implements Serializable {
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    private String Nombre;
    private int DNI;
    private final int sueldo;

    Empleado(String Nombre, int sueldo, int DNI) {
        super();
        this.sueldo = sueldo;
        this.Nombre = Nombre;
        this.DNI = DNI;
    }

    public int getDNI() {
        return DNI;
    }
}
