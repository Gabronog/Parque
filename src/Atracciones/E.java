package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;

import java.util.Arrays;
import java.util.List;


public class E extends Atraccion {
    /**
     * Atraccion Tipo C
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    private static final int nAyudantes = 3;
    private static final int TipoDeAtraccion = 3;

    public E(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
        super(TipoDeAtraccion, responsable);
        //Comprobamos que todos los ayudantes tienen datos
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
            Ayudantes = Arrays.asList(A1, A2, A3, A4, A5, A6);
            //Asignamos la atraccion a cada Ayudante
            LlenarAyudantes();
            //Activamos la atraccion
            this.activada = true;
        }
    }

    public E(Responsables responsable, List<Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, responsable);
        if (nAyudantes == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes();
            this.activada = true;
        }

    }

    public E(String nombre, int sueldo, int DNI, char letra, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6, Ayudantes A7) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null && A7 != null) {
            Ayudantes = Arrays.asList(A1, A2, A3, A4, A5, A6, A7);
            LlenarAyudantes();
            this.activada = true;
        }
    }

    public E(String nombre, int sueldo, int DNI, char letra, List<Personal.Ayudantes> Ayudantes) {
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

