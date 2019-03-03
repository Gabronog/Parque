package Personal;

import Atracciones.*;

import java.io.Serializable;

public class Ayudantes extends TrabajadorDeAtraccion implements Serializable {
    /**
     * @param TipoAtraccion Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
     * @param numeroDeAtraccion Numero de la atraccion que trabaja
     */


    private static final int SUELDO_AYUDANTE = 950;

    public Ayudantes(String Nombre, int DNI) {
        super(Nombre, SUELDO_AYUDANTE, DNI);
    }

    public Responsables Ascender() {
        Responsables R1 = new Responsables(getNombre(), getDNI());
        R1.setNumeroDeAtraccion(-1);
        R1.setTipoAtraccion(-1);
        GestorPersonal.insertar(R1);
        if (getTipoAtraccion() != -1 && getNumeroDeAtraccion() != -1) {
            switch (getTipoAtraccion()) {
                case 1:
                    A a = (A) GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion());
                    a.desactivar();
                    a.BorrarTrabajador(getDNI());
                    break;
                case 2:
                    B b = (B) GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion());
                    b.desactivar();
                    b.BorrarTrabajador(getDNI());
                    break;

                case 3:
                    C c = (C) GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion());
                    c.desactivar();
                    c.BorrarTrabajador(getDNI());
                    break;
                case 4:
                    D d = (D) GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion());
                    d.desactivar();
                    d.BorrarTrabajador(getDNI());
                    break;
                case 5:
                    E e = (E) GestorAtracciones.ObtenerDatos(getNumeroDeAtraccion());
                    e.desactivar();
                    e.BorrarTrabajador(getDNI());
                    break;
                default:
                    System.out.println("ERROR: OUTOFINDEX TIPOATRACCION");
            }
        }
        return R1;
    }
}
