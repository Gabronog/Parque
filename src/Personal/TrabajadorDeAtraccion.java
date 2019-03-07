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
        TrabajadorDeAtraccion trabajador = (TrabajadorDeAtraccion) GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Obtener(this.getDNI());
        if ((-1 != trabajador.getNumeroDeAtraccion())
                && (-1 != trabajador.getTipoAtraccion())) {
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).desactivar();
            GestorAtracciones.ObtenerDatos(numeroDeAtraccion).Borrar(this.getDNI());
            trabajador.setTipoAtraccion(-1);
            trabajador.setNumeroDeAtraccion(-1);
            GestorPersonal.insertarEmpleado(this);
        } else {
            System.out.println("El trabajador no estaba trabajando ninguna atraccion");
        }
    }

}
