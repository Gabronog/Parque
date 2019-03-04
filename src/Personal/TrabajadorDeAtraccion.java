package Personal;

import Atracciones.GestorAtracciones;

public abstract class TrabajadorDeAtraccion extends Empleado {

    private int TipoAtraccion = -1;
    private int numeroDeAtraccion = -1;

    TrabajadorDeAtraccion(String Nombre, int sueldo, int DNI) {
        super(Nombre, sueldo, DNI);

    }

    public int getTipoAtraccion() {
        return TipoAtraccion;
    }

    public void setTipoAtraccion(Integer tipoAtraccion) {
        TipoAtraccion = tipoAtraccion;
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public void setNumeroDeAtraccion(Integer numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }


    public void DejarAtraccion() {
        Ayudantes empleado;
        GestorAtracciones.ObtenerDatos(numeroDeAtraccion).desactivar();
        empleado = GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI());
        empleado.eliminarAtraccion();
        GestorAtracciones.ObtenerDatos(numeroDeAtraccion).BorrarTrabajador(empleado);
    }

    void eliminarAtraccion() {
        this.setTipoAtraccion(-1);
        this.setNumeroDeAtraccion(-1);
        GestorPersonal.insertar(this);
    }

}
