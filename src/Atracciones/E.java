package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;

import java.io.Serializable;


public class E extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo E
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 7;
    private static final int TipoDeAtraccion = 5;
    private static final boolean VIP = true;

    public E(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6, Ayudantes A7) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null && A7 != null) {
            insertar(A1, A2, A3);
            insertar(A4, A5, A6);
            insertar(A7);            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            //Activamos la atraccion
            this.activada = true;
            //Guardamos la atraccion en nuestra lista
            GestorAtracciones.add(this);


        }
    }

    public E(String nombreresp, int DNIresp, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6, Ayudantes A7) {
        super(TipoDeAtraccion, nombreresp, DNIresp);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null && A7 != null) {
            insertar(A1, A2, A3);
            insertar(A4, A5, A6);
            insertar(A7);
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }
    }
}
