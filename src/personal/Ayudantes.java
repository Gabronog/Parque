package personal;

import Atracciones.GestorAtracciones;

import java.io.Serializable;

public class Ayudantes extends TrabajadorDeAtraccion implements Serializable {
    /**
     * @param TipoAtraccion Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
     * @param numeroDeAtraccion Numero de la atraccion que trabaja
     */

    private static final int SUELDO = 950;
    private static final String nTipo = "AYUDANTE";

    public Ayudantes(String nombre, int dni) {
        super(nombre, dni);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) + 1);
    }

    public void Ascender() {
        new Responsables(getNombre(), getDni());
        if (getTipoAtraccion() != -1 && getNumeroDeAtraccion() != -1) {
            this.dejarAtraccion();
        } else {
            GestorPersonal.borrar(this.getDni());
        }
        GestorPersonal.insertarNumero(nTipo, GestorPersonal.obtenerNumero(nTipo) - 1);
    }

    public static int getSUELDO() {
        return SUELDO;
    }

    @Override
    public void dejarAtraccion(){
        if ((-1 != this.getNumeroDeAtraccion())
                && (-1 != this.getTipoAtraccion())) {
            GestorAtracciones.obtenerDatos(this.numeroDeAtraccion).desactivar();
            GestorAtracciones.obtenerDatos(this.numeroDeAtraccion).delete(this.getDni());
            this.setTipoAtraccion(-1);
            this.setNumeroDeAtraccion(-1);
            GestorPersonal.insertarEmpleado(this);
        } else {
            System.out.println("El trabajador no estaba trabajando ninguna atraccion");
        }
    }
}
