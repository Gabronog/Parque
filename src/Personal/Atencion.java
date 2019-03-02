package Personal;

import java.io.Serializable;

public class Atencion extends Empleado implements Serializable {
    /**
     * @param Nombre   Nombre del Trabajador
     * @param sueldo   Sueldo del Trabajador
     * @param DNI      Dni del Trabajador
     * @param letradni Letra del DNI
     */


    Atencion(String Nombre, int sueldo, int DNI, char letradni) {
        super(Nombre, sueldo);
    }
}
