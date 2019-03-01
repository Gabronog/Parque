package Atracciones;

import Personal.Responsables;

import java.util.ArrayList;
import java.util.List;

public abstract class Atraccion {
    /**
     * Clase base para el resto de Atracciones
     * Creada por Gabriel Noguerales
     */
    boolean activada;
    List<Personal.Ayudantes> Ayudantes;
    private Responsables Responsable;
    int numeroAtraccion;
    private static int siguientenumero;

/*    private int calcularAyudantes(int TipoDeAtraccion){
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
*/

    public Atraccion(int TipoDeAtraccion, Responsables responsable) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new ArrayList<>();
            this.Responsable = responsable;
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }


    public Atraccion(int TipoDeAtraccion,String nombre,int sueldo,int DNI,char letra){
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new ArrayList<>();
        Responsable = new Responsables(nombre, sueldo, DNI, letra);
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }


    private void comun(Responsables Responsable, int TipoDeAtraccion, int numeroAtraccion) {
        if (null != Responsable) {
            Responsable.setTipoAtraccion(TipoDeAtraccion);
            Responsable.setNumeroDeAtraccion(numeroAtraccion);
        }
    }


    //TODO abstract void desactivar(); .
    //TODO abstract void activar();

}
