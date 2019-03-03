package Personal;

import Atracciones.*;

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
        switch (TipoAtraccion) {
            case 1:
                A a = (A) GestorAtracciones.ObtenerDatos(numeroDeAtraccion);
                a.desactivar();
                empleado = a.Obtener(this.getDNI());
                empleado.eliminarAtraccion();
                a.BorrarTrabajador(empleado.getDNI());
                break;

            case 2:
                B b = (B) GestorAtracciones.ObtenerDatos(numeroDeAtraccion);
                b.desactivar();
                empleado = b.Obtener(this.getDNI());
                empleado.eliminarAtraccion();
                b.BorrarTrabajador(empleado.getDNI());
                break;

            case 3:
                C c = (C) GestorAtracciones.ObtenerDatos(numeroDeAtraccion);
                c.desactivar();
                empleado = c.Obtener(this.getDNI());
                empleado.eliminarAtraccion();
                c.BorrarTrabajador(empleado.getDNI());
                break;
            case 4:
                D d = (D) GestorAtracciones.ObtenerDatos(numeroDeAtraccion);
                d.desactivar();
                empleado = d.Obtener(this.getDNI());
                empleado.eliminarAtraccion();
                d.BorrarTrabajador(empleado.getDNI());
                break;
            case 5:
                E e = (E) GestorAtracciones.ObtenerDatos(numeroDeAtraccion);
                e.desactivar();
                empleado = e.Obtener(this.getDNI());
                empleado.eliminarAtraccion();
                e.BorrarTrabajador(empleado.getDNI());
                break;
            default:
                System.out.println("ERROR: OUTOFINDEX TIPOATRACCION");
        }

    }

    void eliminarAtraccion() {
        this.setTipoAtraccion(-1);
        this.setNumeroDeAtraccion(-1);
        GestorPersonal.insertar(this);
    }
}
