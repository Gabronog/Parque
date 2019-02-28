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

    private int calcularAyudantes(int TipoDeAtraccion){
        switch(TipoDeAtraccion){
            case 1: return 6;
            case 2: return 5;
            case 3: return 3;
            case 4: return 5;
            case 5: return 7;
            default:
                System.out.println("Se ha producido un error al intentar añadir la atraccion");
                System.exit(-1);
        }
        System.out.println("Se ha producido un error al intentar añadir la atraccion");
        System.exit(-1);
        return -1;
    }

    public Atraccion(int TipoDeAtraccion,ResponsablesDeAtraccion responsable){
        int aux1 = 0;
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        aux1 = calcularAyudantes(TipoDeAtraccion);
            Ayudantes = new ArrayList<>(aux1);
            this.Responsable = responsable;
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }

    public Atraccion(int TipoDeAtraccion,String nombre,int sueldo,int DNI,char letra){
        int aux1 = 0;
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        aux1 = calcularAyudantes(TipoDeAtraccion);
            Ayudantes = new ArrayList<>(aux1);
            Responsable = new ResponsablesDeAtraccion(nombre,sueldo,DNI,letra);
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }
    //TODO public Atraccion(int TipoDeAtraccion)
    private void comun(ResponsablesDeAtraccion Responsable,int TipoDeAtraccion,int numeroAtraccion){
        Responsable.setTipoAtraccion(TipoDeAtraccion);
        Responsable.setNumeroDeAtraccion(numeroAtraccion);
    }

    abstract ArrayList LlenarAtraccion();

    //TODO abstract void desactivar(); .
    //TODO abstract void activar();

}
