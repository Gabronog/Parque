package Atracciones;

import Personal.Ayudantes;
import Personal.GestorPersonal;
import Personal.Responsables;

import java.io.Serializable;
import java.util.HashMap;

abstract class Atraccion implements Serializable {
    /**
     * Clase base para el resto de Atracciones
     * Creada por Gabriel Noguerales
     */
    boolean activada; //Controla si la atraccion esta abierta al publico o cerrada.
    public int numeroAtraccion; //Numero de Atraccion
    private Responsables Responsable; //Responsable de la atraccion
    HashMap<Integer, Personal.Ayudantes> Ayudantes; //Lista de ayudantes de la atraccion
    private static int siguientenumero; //Numero a asignar a la siguiente atraccion

    Atraccion(int TipoDeAtraccion, Responsables responsable) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new HashMap<>();
        this.Responsable = responsable;
        comun(Responsable, TipoDeAtraccion, numeroAtraccion);
    }


    Atraccion(int TipoDeAtraccion, String nombre, int DNI) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new HashMap<>();
        Responsable = new Responsables(nombre, DNI);
            comun(Responsable,TipoDeAtraccion,numeroAtraccion);
    }


    private void comun(Responsables Responsable, int TipoDeAtraccion, int numeroAtraccion) {
        if (null != Responsable) {
            Responsable.setTipoAtraccion(TipoDeAtraccion);
            Responsable.setNumeroDeAtraccion(numeroAtraccion);
        }
    }

    public void desactivar() {
        this.activada = false;
    }

    protected void LlenarAyudantes(int nAyudantes, int TipoDeAtraccion) {
        for (int i = 0; i < nAyudantes; i++) {
            Personal.Ayudantes empleado = this.Ayudantes.get(i);
            if (GestorPersonal.contiene(empleado.getDNI())) {
                GestorPersonal.borrar(empleado.getDNI());
            }
            empleado.setNumeroDeAtraccion(this.numeroAtraccion);
            empleado.setTipoAtraccion(TipoDeAtraccion);
        }
    }


    public void Activar(int nAyudantes) {
        if (Ayudantes.size() == nAyudantes) {
            this.activada = true;
        } else {
            System.out.println("Error: No hay suficientes trabajadores asignados a la atracción");
        }
    }

    public Ayudantes Obtener(int DNI) {
        return Ayudantes.get(DNI);
    }

    public void BorrarTrabajador(int DNI) {
        Ayudantes.remove(DNI);
    }
}
