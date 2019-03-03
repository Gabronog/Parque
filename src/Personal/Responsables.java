package Personal;

import java.io.Serializable;

public class Responsables extends Empleado implements Serializable {
    private final static int SUELDO = (int) (950 * 1.15);
    private int TipoAtraccion = -1;
    private int numeroDeAtraccion = -1;

    public Responsables(String Nombre, int DNI) {
        super(Nombre, SUELDO, DNI);
    }

    public void setTipoAtraccion(int tipoDeAtraccion) {
        this.TipoAtraccion = tipoDeAtraccion;
    }

    public void setNumeroDeAtraccion(int numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }
}

