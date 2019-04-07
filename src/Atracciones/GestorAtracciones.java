package Atracciones;

import io.IO;

import java.util.LinkedList;
import java.util.logging.Logger;

public abstract class GestorAtracciones extends IO {

    private static final String ARCHIVO = "DATA/atracciones";
    private static LinkedList<Atraccion> atracciones = new LinkedList<>();
    private static final Logger LOGGER = Logger.getLogger(GestorAtracciones.class.getName());
    private GestorAtracciones(){
        throw new IllegalStateException("No se pueden hacer instancias de los gestores");
    }

    public static void eliminarAtraccion(int numeroAtraccion) {
        atracciones.remove(numeroAtraccion);
    }

    /**
     * Devuelve los datos de una atraccion dado el numero de esta
     * @param numeroAtraccion Numero de atraccion que consultar
     * @return La atraccion que buscabas
     */
    public static Atraccion obtenerDatos(int numeroAtraccion) {
        try{return atracciones.get(numeroAtraccion);}
        catch (IndexOutOfBoundsException ignored){
            LOGGER.warning("Llegamos al final de la lista prematuramente.");
            return null;
        }
    }

    public static void borrar(){
        atracciones.clear();
    }

    public static void guardar() {
        guardar(ARCHIVO, atracciones);
    }

    public static void cargar() {
        atracciones = cargarLista(ARCHIVO);
    }

    public static void add(Atraccion atraccion) {
        atracciones.add(atraccion);
    }
}
