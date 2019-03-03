package Personal;

import java.io.Serializable;

public class Atencion extends Empleado implements Serializable {
    /**
     * @param Nombre   Nombre del Trabajador
     * @param sueldo   Sueldo del Trabajador
     * @param DNI      Dni del Trabajador
     */


    Atencion(String Nombre, int sueldo, int DNI) {
        super(Nombre, sueldo, DNI);
    }
}
