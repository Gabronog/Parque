package personal;

import java.io.Serializable;

public abstract class Empleado implements Serializable {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private int dni;

    Empleado(String nombre, int dni) {
        super();
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }
}
