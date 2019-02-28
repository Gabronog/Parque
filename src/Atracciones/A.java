package Atracciones;

import Personal.AyudantesDeAtraccion;
import Personal.ResponsablesDeAtraccion;

import java.util.ArrayList;


public class A implements Atraccion {

    static final int numeroDeAyudantesDeAtraccion = 6;
    static final int numeroDeResponsablesDeAtraccion = 6;
    private ArrayList<AyudantesDeAtraccion> Ayudantes = new ArrayList<>(6);
    private ResponsablesDeAtraccion Responsable;
    private String nombre;
    private int numeroAtraccion;
    private static int siguientenumero;

    public A(ResponsablesDeAtraccion Responsable) {
        this.Responsable = Responsable;
        numeroAtraccion = siguientenumero;
        Responsable.setNumeroDeAtraccion(numeroAtraccion);
        Responsable.setTipoAtraccion("A");
        siguientenumero++;
    }

    @Override
    public void desactivar() {

    }

    @Override
    public void activar() {

    }


}
