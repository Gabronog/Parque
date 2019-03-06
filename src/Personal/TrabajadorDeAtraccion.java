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
        if (-1 != GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI()).getNumeroDeAtraccion()
                && -1 != GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI()).getTipoAtraccion()) {
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).desactivar();
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI()).setTipoAtraccion(-1);
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI()).setNumeroDeAtraccion(-1);
            GestorPersonal.insertarEmpleado(this);
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Borrar(this.getDNI());
        } else {
            System.out.println("El trabajador no estaba trabajando ninguna atraccion");
        }
    }

}
