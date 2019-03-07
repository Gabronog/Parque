package Personal;

import java.io.Serializable;

public class Ayudantes extends TrabajadorDeAtraccion implements Serializable {
    /**
     * @param TipoAtraccion Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
     * @param numeroDeAtraccion Numero de la atraccion que trabaja
     */

    private static final int SUELDO_AYUDANTE = 950;
    private static final String nTipo = "AYUDANTE";

    public Ayudantes(String Nombre, int DNI) {
        super(Nombre, SUELDO_AYUDANTE, DNI);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) + 1);
    }

    public void Ascender() {
        Responsables R1 = new Responsables(getNombre(), getDNI());
        if (getTipoAtraccion() != -1 && getNumeroDeAtraccion() != -1) {
            this.DejarAtraccion();
        } else {
            GestorPersonal.borrar(this.getDNI());
        }
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) - 1);
    }
}
