package personal;

import Atracciones.GestorAtracciones;

public abstract class TrabajadorDeAtraccion extends Empleado {

    private int tipoAtraccion = -1;
    int numeroDeAtraccion = -1;

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


    abstract void dejarAtraccion();

}
