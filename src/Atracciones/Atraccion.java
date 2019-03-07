package Atracciones;

import Personal.Ayudantes;
import Personal.GestorPersonal;
import Personal.Responsables;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Atraccion implements Serializable {
    /**
     * Clase base para el resto de Atracciones
     * Creada por Gabriel Noguerales
     */
    boolean activada; //Controla si la atraccion esta abierta al publico o cerrada.
    private int numeroAtraccion; //Numero de Atraccion
    private Responsables Responsable; //Responsable de la atraccion
    private HashMap<Integer, Personal.Ayudantes> Ayudantes; //Lista de ayudantes de la atraccion
    private static int siguientenumero; //Numero a asignar a la siguiente atraccion

    Atraccion(int TipoDeAtraccion, Responsables responsable) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new HashMap<>();
        this.Responsable = responsable;
        if (responsable.getNumeroDeAtraccion() != -1 && responsable.getNumeroDeAtraccion() != -1) {
            GestorAtracciones.ObtenerDatos(responsable.getNumeroDeAtraccion()).activada = false;
            GestorAtracciones.ObtenerDatos(responsable.getNumeroDeAtraccion()).Responsable = null;
        } else {
            GestorPersonal.borrar(responsable.getDNI());
        }
        comun(Responsable, TipoDeAtraccion, numeroAtraccion);
    }


    Atraccion(int TipoDeAtraccion, String nombre, int DNI) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        Ayudantes = new HashMap<>();
        Responsable = new Responsables(nombre, DNI);
        GestorPersonal.borrar(DNI);
        comun(Responsable, TipoDeAtraccion, numeroAtraccion);
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

    public void Activar(int nAyudantes) {
        if (Ayudantes.size() == nAyudantes && Responsable != null) {
            this.activada = true;
        } else {
            System.out.println("Error: No hay suficientes trabajadores asignados a la atracción");
        }
    }

    void insertar(Ayudantes A1) {
        if (-1 == A1.getTipoAtraccion() || -1 == A1.getNumeroDeAtraccion()) GestorPersonal.borrar(A1.getDNI());
        else A1.DejarAtraccion();
        this.Ayudantes.put(A1.getDNI(), A1);
    }

    void insertar(Ayudantes A1, Ayudantes A2) {
        insertar(A1);
        insertar(A2);
    }

    void insertar(Ayudantes A1, Ayudantes A2, Ayudantes A3) {
        insertar(A1, A2);
        insertar(A3);
    }

    public Ayudantes Obtener(int DNI) {
        return Ayudantes.get(DNI);
    }

    public void Borrar(int DNI) {
        Ayudantes.remove(DNI);
    }

    void LlenarAyudantes(int nAyudantes, int TipoDeAtraccion) {
        Ayudantes.forEach((k,v) -> {
            if (GestorPersonal.contiene(v.getDNI())) {
                GestorPersonal.borrar(v.getDNI());
            }
            v.setNumeroDeAtraccion(this.numeroAtraccion);
            v.setTipoAtraccion(TipoDeAtraccion);
        });
    }
}
