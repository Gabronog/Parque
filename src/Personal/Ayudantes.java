package Personal;

import Atracciones.GestorAtracciones;

import java.io.Serializable;

public class Ayudantes extends TrabajadorDeAtraccion implements Serializable {
    /**
     * @param TipoAtraccion Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
     * @param numeroDeAtraccion Numero de la atraccion que trabaja
     */


    private static final int SUELDO_AYUDANTE = 950;

    public Ayudantes(String Nombre, int DNI) {
        super(Nombre, SUELDO_AYUDANTE, DNI);
        GestorPersonal.insertar(this);
    }

    public void Ascender() {
        Responsables R1 = new Responsables(getNombre(), getDNI());
        R1.setNumeroDeAtraccion(-1);
        R1.setTipoAtraccion(-1);
        GestorPersonal.insertar(R1);
        if (getTipoAtraccion() != -1 && getNumeroDeAtraccion() != -1) {
            GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion()).BorrarTrabajador(this);
            GestorPersonal.insertar(R1);
        } else {
            GestorPersonal.borrar(this.getDNI());
            GestorPersonal.insertar(R1);
        }
    }
}
