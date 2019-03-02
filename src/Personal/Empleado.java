package Personal;

import java.io.Serializable;

public abstract class Empleado implements Serializable {
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getSueldo() {
        return Sueldo;
    }

    private String Nombre;
    int Sueldo;

    Empleado(String Nombre, int sueldo) {
        super();
        this.Sueldo = sueldo;
        this.Nombre = Nombre;
    }
}
