package Atracciones;

import personal.Ayudantes;
import personal.GestorPersonal;
import personal.Responsables;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.LOG.getStackTrace;

/**
 * Clase abstracta base para todas las atracciones
 */
public abstract class Atraccion implements Serializable {
    boolean activada; //Controla si la atraccion esta abierta al publico o cerrada.
    public final int numeroAtraccion; //Numero de Atraccion
    protected Responsables responsable; //responsable de la atraccion
    protected HashMap<Integer, personal.Ayudantes> ayudantes; //Lista de ayudantes de la atraccion
    private static int siguientenumero; //Numero a asignar a la siguiente atraccion
    static final Logger LOGGER = Logger.getLogger(Atraccion.class.getName());
    /**
     * Constructor base de atracciones reutilizando un responsable ya contratado
     * @param tipoDeAtraccion Tipo de atraccion que se quiere construir
     * @param responsable Responsable al que asignar a la atraccion
     */
    Atraccion(int tipoDeAtraccion, Responsables responsable) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        ayudantes = new HashMap<>();
        this.responsable = responsable;
        if (this.responsable.getNumeroDeAtraccion() != -1 && this.responsable.getTipoAtraccion() != -1) {
            //El responsable esta trabajando una atraccion ya
            //Desactivamos la atraccion que estaba trabajando antes de asignarlo a esta
            try {
                LOGGER.info(String.format("Desactivando la atraccion %d debido a la incorporacion del trabajador con DNI %d " +
                        "en la atraccion %d", responsable.getNumeroDeAtraccion(), responsable.getDni(), this.numeroAtraccion));
                GestorAtracciones.obtenerDatos(responsable.getNumeroDeAtraccion()).activada = false;
                GestorAtracciones.obtenerDatos(responsable.getNumeroDeAtraccion()).responsable = null;
                LOGGER.log(Level.INFO,"Desactivada...");
            }catch(NullPointerException n){
                LOGGER.severe(getStackTrace(n));
            }
        } else {
            GestorPersonal.borrar(responsable.getDni());
        }
        setResponsable(this.responsable, tipoDeAtraccion, numeroAtraccion);
    }

    /**
     * Constructor base de Atracciones contratando un nuevo Responsable
     * @param tipoDeAtraccion tipoDeAtraccion que generar
     * @param nombre Nombre del responsable
     * @param DNI Dni del responsable
     */
    Atraccion(int tipoDeAtraccion, String nombre, int DNI) {
        numeroAtraccion = siguientenumero;
        siguientenumero++;
        ayudantes = new HashMap<>();
        responsable = new Responsables(nombre, DNI);
        GestorPersonal.borrar(DNI);
        setResponsable(responsable, tipoDeAtraccion, numeroAtraccion);
    }

    /**
     * Establece al responsable como trabajador de esa atraccion
     * @param responsable Responsable al que asignar a la atraccion
     * @param tipoDeAtraccion Tipo de atraccion a la que va a trabajar
     * @param numeroAtraccion Numero de atraccion que va a trabajar
     */
    private void setResponsable(Responsables responsable, int tipoDeAtraccion, int numeroAtraccion) {
        if (null != responsable) {
            responsable.setTipoAtraccion(tipoDeAtraccion);
            responsable.setNumeroDeAtraccion(numeroAtraccion);
        }
    }

    /**
     * Desactiva la atracción
     */
    public void desactivar() {
        this.activada = false;
    }
    /**
     * Inserta un Ayudante en la atraccion
     */
    public void insertar(Ayudantes ayudante) {
        if (-1 == ayudante.getTipoAtraccion() || -1 == ayudante.getNumeroDeAtraccion()) GestorPersonal.borrar(ayudante.getDni());
        else ayudante.dejarAtraccion();
        this.ayudantes.put(ayudante.getDni(), ayudante);
    }

    /**
     * Inserta dos ayudantes en la atraccion
     */
    void insertar(Ayudantes ayudante1, Ayudantes ayudante2) {
        insertar(ayudante1);
        insertar(ayudante2);
    }

    /**
     * Inserta tres ayudantes en la atraccion
     */
    void insertar(Ayudantes ayudante1, Ayudantes ayudante2, Ayudantes ayudante3) {
        insertar(ayudante1, ayudante2);
        insertar(ayudante3);
    }

    public Ayudantes getDNI(int DNI) {
        return ayudantes.get(DNI);
    }

    /**
     * Borra un trabajador de la atraccion
     * @param dni dni
     */
    public void delete(int dni) {
        ayudantes.remove(dni);
    }

    /**
     * Si los trabajadores estaban en la lista de trabajadores sin atraccione asignada
     * se borra a estos de esta lista y se les asigna la atraccion
     * @param tipoDeAtraccion Tipo de atraccion
     */
    void asignarAtraccion(int tipoDeAtraccion) {
        ayudantes.forEach((k, v) -> {
            if (GestorPersonal.contiene(v.getDni())) {
                GestorPersonal.borrar(v.getDni());
            }
            v.setNumeroDeAtraccion(this.numeroAtraccion);
            v.setTipoAtraccion(tipoDeAtraccion);
        });
    }
    public abstract Boolean activar();
}
