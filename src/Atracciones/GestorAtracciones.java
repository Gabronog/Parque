package Atracciones;

import io.IO;

import java.util.LinkedList;

public abstract class GestorAtracciones {

    private static final String ARCHIVO = "DATA/Atracciones";
    private static LinkedList<Atraccion> Atracciones = new LinkedList<>();

    public static void EliminarAtraccion(int numeroAtraccion) {
        Atracciones.remove(numeroAtraccion);
    }


    public static Atraccion ObtenerDatos(int numeroAtraccion) {
        return Atracciones.get(numeroAtraccion);
    }

    public static void Guardar() {
        IO.Guardar(ARCHIVO, Atracciones);
    }

    public static void Cargar() {
        Atracciones = IO.CargarLista(ARCHIVO);
    }

    public static void add(Atraccion Atraccion) {
        Atracciones.add(Atraccion);
    }
}
