package personal;

import Atracciones.GestorAtracciones;

public abstract class TrabajadorDeAtraccion extends Empleado {

    private int tipoAtraccion = -1;
    private int numeroDeAtraccion = -1;

    TrabajadorDeAtraccion(String nombre, int dni) {
        super(nombre, dni);
    }

    public int getTipoAtraccion() {
        return tipoAtraccion;
    }

    public void setTipoAtraccion(Integer tipoAtraccion) {
        this.tipoAtraccion = tipoAtraccion;
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public void setNumeroDeAtraccion(Integer numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }


    public void dejarAtraccion() {
        TrabajadorDeAtraccion trabajador = GestorAtracciones.obtenerDatos(numeroDeAtraccion).getDNI(this.getDni());
        if ((-1 != trabajador.getNumeroDeAtraccion())
                && (-1 != trabajador.getTipoAtraccion())) {
            GestorAtracciones.obtenerDatos(numeroDeAtraccion).desactivar();
            GestorAtracciones.obtenerDatos(numeroDeAtraccion).delete(this.getDni());
            trabajador.setTipoAtraccion(-1);
            trabajador.setNumeroDeAtraccion(-1);
            GestorPersonal.insertarEmpleado(this);
        } else {
            System.out.println("El trabajador no estaba trabajando ninguna atraccion");
        }
    }
}
