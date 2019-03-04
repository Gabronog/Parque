package Atracciones;

import Personal.Ayudantes;
import Personal.GestorPersonal;
import Personal.Responsables;

import java.io.Serializable;


public class C extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo C
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 3;
    private static final int TipoDeAtraccion = 3;
    private static final boolean VIP = false;

    public C(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null) {
            insertar(A1, A2, A3, A4, A5);
            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            //Activamos la atraccion
            this.activada = true;
            //Guardamos la atraccion en nuestra lista
            GestorAtracciones.add(this);


        }
    }

    public C(String nombreresp, int DNIresp, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5) {
        super(TipoDeAtraccion, nombreresp, DNIresp);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null) {
            insertar(A1, A2, A3, A4, A5);
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }
    }

    private void insertar(Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5) {
        if (-1 == A1.getTipoAtraccion() && -1 == A1.getNumeroDeAtraccion()) GestorPersonal.borrar(A1.getDNI());
        else GestorAtracciones.ObtenerDatos(A1.getNumeroDeAtraccion()).BorrarTrabajador(A1);
        this.Ayudantes.put(A1.getDNI(), A1);
        if (-1 == A2.getTipoAtraccion() && -1 == A2.getNumeroDeAtraccion()) GestorPersonal.borrar(A2.getDNI());
        else GestorAtracciones.ObtenerDatos(A2.getNumeroDeAtraccion()).BorrarTrabajador(A2);
        this.Ayudantes.put(A2.getDNI(), A2);
        if (-1 == A3.getTipoAtraccion() && -1 == A3.getNumeroDeAtraccion()) GestorPersonal.borrar(A3.getDNI());
        else GestorAtracciones.ObtenerDatos(A3.getNumeroDeAtraccion()).BorrarTrabajador(A3);
        this.Ayudantes.put(A3.getDNI(), A3);
    }
}
