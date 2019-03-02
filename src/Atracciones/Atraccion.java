package Atracciones;

import Personal.Responsables;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract class Atraccion implements Serializable {
    /**
     * Clase base para el resto de Atracciones
     * Creada por Gabriel Noguerales
     */
    boolean activada; //Controla si la atraccion esta abierta al publico o cerrada.
    List<Personal.Ayudantes> Ayudantes; //Lista de ayudantes de la atraccion
    private Responsables Responsable; //Responsable de la atraccion
    int numeroAtraccion; //Numero de Atraccion
    private static int siguientenumero; //Numero a asignar a la siguiente atraccion

    Atraccion(int TipoDeAtraccion, Responsables responsable) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new ArrayList<>();
            this.Responsable = responsable;
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }


    Atraccion(int TipoDeAtraccion, String nombre, int sueldo, int DNI, char letra) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new ArrayList<>();
        Responsable = new Responsables(nombre);
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
