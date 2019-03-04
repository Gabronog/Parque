package Atracciones;

import Personal.Ayudantes;
import Personal.GestorPersonal;
import Personal.Responsables;

import java.io.Serializable;
import java.util.HashMap;


public class A extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo A
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 6;
    private static final int TipoDeAtraccion = 1;
    private static final boolean VIP = true;

    public A(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
            if (-1 == A1.getTipoAtraccion() && -1 == A1.getNumeroDeAtraccion()) GestorPersonal.borrar(A1.getDNI());
            else GestorAtracciones.ObtenerDatos(A1.getNumeroDeAtraccion()).BorrarTrabajador(A1);
            this.Ayudantes.put(A1.getDNI(), A1);
            if (-1 == A2.getTipoAtraccion() && -1 == A2.getNumeroDeAtraccion()) GestorPersonal.borrar(A2.getDNI());
            else GestorAtracciones.ObtenerDatos(A2.getNumeroDeAtraccion()).BorrarTrabajador(A2);
            this.Ayudantes.put(A2.getDNI(), A2);
            if (-1 == A3.getTipoAtraccion() && -1 == A3.getNumeroDeAtraccion()) GestorPersonal.borrar(A3.getDNI());
            else GestorAtracciones.ObtenerDatos(A3.getNumeroDeAtraccion()).BorrarTrabajador(A3);
            this.Ayudantes.put(A3.getDNI(), A3);
            if (-1 == A4.getTipoAtraccion() && -1 == A4.getNumeroDeAtraccion()) GestorPersonal.borrar(A4.getDNI());
            else GestorAtracciones.ObtenerDatos(A4.getNumeroDeAtraccion()).BorrarTrabajador(A4);
            this.Ayudantes.put(A4.getDNI(), A4);
            if (-1 == A5.getTipoAtraccion() && -1 == A5.getNumeroDeAtraccion()) GestorPersonal.borrar(A5.getDNI());
            else GestorAtracciones.ObtenerDatos(A5.getNumeroDeAtraccion()).BorrarTrabajador(A5);
            this.Ayudantes.put(A5.getDNI(), A5);
            if (-1 == A6.getTipoAtraccion() && -1 == A6.getNumeroDeAtraccion()) GestorPersonal.borrar(A6.getDNI());
            else GestorAtracciones.ObtenerDatos(A6.getNumeroDeAtraccion()).BorrarTrabajador(A6);
            this.Ayudantes.put(A6.getDNI(), A6);
            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            //Activamos la atraccion
            this.activada = true;
            //Guardamos la atraccion en nuestra lista
            GestorAtracciones.add(this);


        }
    }

    public A(Responsables responsable, HashMap<Integer, Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, responsable);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }

    }

    public A(String nombre, int DNI, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
        super(TipoDeAtraccion, nombre, DNI);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
            this.Ayudantes.put(A1.getDNI(), A1);
            this.Ayudantes.put(A2.getDNI(), A2);
            this.Ayudantes.put(A3.getDNI(), A3);
            this.Ayudantes.put(A4.getDNI(), A4);
            this.Ayudantes.put(A5.getDNI(), A5);
            this.Ayudantes.put(A6.getDNI(), A6);
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }
    }

    public A(String nombre, int DNI, HashMap<Integer, Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, nombre, DNI);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }
    }
}
