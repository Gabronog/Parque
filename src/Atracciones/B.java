package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;

import java.io.Serializable;
import java.util.HashMap;


public class B extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo B
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 5;
    private static final int TipoDeAtraccion = 2;
    private static final boolean VIP = false;

    public B(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
            this.Ayudantes.put(A1.getDNI(), A1);
            this.Ayudantes.put(A2.getDNI(), A2);
            this.Ayudantes.put(A3.getDNI(), A3);
            this.Ayudantes.put(A4.getDNI(), A4);
            this.Ayudantes.put(A5.getDNI(), A5);
            this.Ayudantes.put(A6.getDNI(), A6);
            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            //Activamos la atraccion
            this.activada = true;
        }
    }

    public B(Responsables responsable, HashMap<Integer, Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, responsable);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }

    }

    public B(String nombre, int DNI, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
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

    public B(String nombre, int DNI, HashMap<Integer, Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, nombre, DNI);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes(nAyudantes, TipoDeAtraccion);
            this.activada = true;
        }
    }
}
