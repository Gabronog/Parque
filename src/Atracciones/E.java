package Atracciones;

import personal.Ayudantes;
import personal.Responsables;

import java.io.Serializable;


public class E extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo E
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int TIPO_DE_ATRACCION = 5;
    private static final boolean VIP = true;

    public E(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6, Ayudantes A7) {
        super(TIPO_DE_ATRACCION, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null && A7 != null) {
            insertar(A1, A2, A3);
            insertar(A4, A5, A6);
            insertar(A7);            //Asignamos la atraccion a cada Ayudante
            asignarAtraccion(TIPO_DE_ATRACCION);
            //Activamos la atraccion
            this.activada = true;
            //Guardamos la atraccion en nuestra lista
            GestorAtracciones.add(this);


        }
    }

    public E(String nombreresp, int DNIresp, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6, Ayudantes A7) {
        super(TIPO_DE_ATRACCION, nombreresp, DNIresp);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null && A7 != null) {
            insertar(A1, A2, A3);
            insertar(A4, A5, A6);
            insertar(A7);
            asignarAtraccion(TIPO_DE_ATRACCION);
            this.activada = true;
        }
    }
}
