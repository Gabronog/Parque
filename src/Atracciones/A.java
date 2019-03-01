package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;

import java.util.Arrays;
import java.util.List;


public class A extends Atraccion {
    /**
     * Atraccion Tipo A
     * Extiende Atraccion
     * Creado por Gabriel Noguerales
     */

    static final int numeroDeAyudantesDeAtraccion = 6;
    static final int TipoDeAtraccion = 0;

    public A(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
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

    public A(Responsables responsable, List<Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, responsable);
        if (numeroDeAyudantesDeAtraccion == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes();
            this.activada = true;
        }

    }

    public A(String nombre, int sueldo, int DNI, char letra, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
        if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
            Ayudantes = Arrays.asList(A1, A2, A3, A4, A5, A6);
            LlenarAyudantes();
            this.activada = true;
        }
    }

    public A(String nombre, int sueldo, int DNI, char letra, List<Personal.Ayudantes> Ayudantes) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
        if (numeroDeAyudantesDeAtraccion == Ayudantes.size()) {
            this.Ayudantes = Ayudantes;
            LlenarAyudantes();
            this.activada = true;
        }

    }

    private void LlenarAyudantes() {
        for (int i = 0; i < numeroDeAyudantesDeAtraccion; i++) {
            this.Ayudantes.get(i).setNumeroDeAtraccion(this.numeroAtraccion);
            this.Ayudantes.get(i).setTipoAtraccion(TipoDeAtraccion);
        }
    }


    public A(String nombre, int sueldo, int DNI, char letra) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
    }

}
