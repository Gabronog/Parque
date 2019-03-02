package Personal;

import java.io.Serializable;

public class Responsables extends Ayudantes implements Serializable {
    public Responsables(String Nombre) {
        super(Nombre);
        this.Sueldo = (int) (950 * 1.15);
    }
}

