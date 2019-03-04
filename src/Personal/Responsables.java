package Personal;

import java.io.Serializable;

public class Responsables extends TrabajadorDeAtraccion implements Serializable {
    private final static int SUELDO = (int) (950 * 1.15);

    public Responsables(String Nombre, int DNI) {
        super(Nombre, SUELDO, DNI);
    }
}

