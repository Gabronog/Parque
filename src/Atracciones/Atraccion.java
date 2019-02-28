package Atracciones;

import Personal.AyudantesDeAtraccion;
import Personal.ResponsablesDeAtraccion;

import java.util.ArrayList;

public abstract class Atraccion {
    private boolean activada;
    private ArrayList<AyudantesDeAtraccion> Ayudantes;
    private ResponsablesDeAtraccion Responsable;
    private int numeroAtraccion;
    private static int siguientenumero;

    public Atraccion(int TipoDeAtraccion){
        int aux1 = 0;
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        switch(TipoDeAtraccion){
            case 1: aux1 = 6;break;
            case 2: aux1 = 5;break;
            case 3: aux1 = 3;break;
            case 4: aux1 = 5;break;
            case 5: aux1 = 7;break;
            default:
                System.out.println("Se ha producido un error al intentar añadir la atraccion");
                System.exit(-1);
        }
        if(0!=aux1) { //this should always be true but just in case
            Ayudantes = new ArrayList<>(aux1);
            for(int i=0;i<=)
        }

    }
    //TODO abstract void desactivar(); .
    //TODO abstract void activar();

}
