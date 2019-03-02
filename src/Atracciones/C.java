package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;


public class C extends Atraccion implements Serializable {
    /**
     * Atraccion Tipo C
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 3;
    private static final int TipoDeAtraccion = 3;
    private static final boolean VIP = false;


    public C(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null) {
            Ayudantes = Arrays.asList(A1, A2, A3);
            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes();
            //Activamos la atraccion
            this.activada = true;
        }
    }

    public C(Responsables responsable, List<Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, responsable);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes();
            this.activada = true;
        }

    }

    public C(String nombre, int sueldo, int DNI, char letra, Ayudantes A1, Ayudantes A2, Ayudantes A3) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
        if (A1 != null && A2 != null && A3 != null) {
            Ayudantes = Arrays.asList(A1, A2, A3);
            LlenarAyudantes();
            this.activada = true;
        }
    }

    public C(String nombre, int sueldo, int DNI, char letra, List<Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes();
            this.activada = true;
        }

    }

    private void LlenarAyudantes() {
        for (int i = 0; i < nAyudantes; i++) {
            this.Ayudantes.get(i).setNumeroDeAtraccion(this.numeroAtraccion);
            this.Ayudantes.get(i).setTipoAtraccion(TipoDeAtraccion);
        }
    }

}
