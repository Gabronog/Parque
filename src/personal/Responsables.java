package personal;

import Atracciones.GestorAtracciones;

import java.io.Serializable;

public class Responsables extends TrabajadorDeAtraccion implements Serializable {
    private static final int SUELDO = (int) (950 * 1.15);
    private static final String TIPO = "RESPONSABLES";

    public Responsables(String nombre, int dni) {
        super(nombre, dni);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(TIPO, GestorPersonal.obtenerNumero(TIPO) + 1);
    }
    public static int getSUELDO() {
        return SUELDO;
    }
    @Override
    public void dejarAtraccion(){
        TrabajadorDeAtraccion trabajador = GestorAtracciones.obtenerDatos(numeroDeAtraccion).getDNI(this.getDni());
        if ((-1 != trabajador.getNumeroDeAtraccion())
                && (-1 != trabajador.getTipoAtraccion())) {
            GestorAtracciones.obtenerDatos(numeroDeAtraccion).desactivar();
            GestorAtracciones.obtenerDatos(numeroDeAtraccion).delete();
            trabajador.setTipoAtraccion(-1);
            trabajador.setNumeroDeAtraccion(-1);
            GestorPersonal.insertarEmpleado(this);
        } else {
            System.out.println("El trabajador no estaba trabajando ninguna atraccion");
        }
    }
}

