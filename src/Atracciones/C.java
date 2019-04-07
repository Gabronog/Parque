package Atracciones;

import personal.Ayudantes;
import personal.Responsables;

import java.io.Serializable;


public class C extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo C
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int TIPO_DE_ATRACCION = 3;
    private static final boolean VIP = false;

    public C(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3) {
        super(TIPO_DE_ATRACCION, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null) {
            insertar(A1, A2, A3);
            //Asignamos la atraccion a cada Ayudante
            asignarAtraccion(TIPO_DE_ATRACCION);
            //Activamos la atraccion
            this.activada = true;
            //Guardamos la atraccion en nuestra lista
            GestorAtracciones.add(this);


        }
    }

    public C(String nombreresp, int DNIresp, Ayudantes A1, Ayudantes A2, Ayudantes A3) {
        super(TIPO_DE_ATRACCION, nombreresp, DNIresp);
        if (A1 != null && A2 != null && A3 != null) {
            insertar(A1, A2, A3);
            asignarAtraccion(TIPO_DE_ATRACCION);
            this.activada = true;
        }
        GestorAtracciones.add(this);
    }
}
