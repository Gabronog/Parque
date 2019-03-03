package Atracciones;

import Personal.Ayudantes;
import Personal.Responsables;
import io.IO;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class GestorAtracciones {

    private static final String ARCHIVO = "Atracciones";
    private static LinkedList<Atraccion> Atracciones = new LinkedList<>();

    public static void NuevaAtraccionA(HashMap<Integer, Ayudantes> a, Responsables Responsable) {
        Atracciones.add(new A(Responsable, a));
    }

    public static void NuevaAtraccionB(HashMap<Integer, Ayudantes> b, Responsables Responsable) {
        Atracciones.add(new B(Responsable, b));
    }

    public static void NuevaAtraccionC(HashMap<Integer, Ayudantes> A, Responsables Responsable) {
        //TODO Atracciones.add(new C(Responsable, A));
    }

    public static void NuevaAtraccionD(HashMap<Integer, Ayudantes> A, Responsables Responsable) {
        //TODO Atracciones.add(new D(Responsable, A));
    }

    public static void NuevaAtraccionE(HashMap<Integer, Ayudantes> A, Responsables Responsable) {
        //TODO Atracciones.add(new E(Responsable, A));
    }

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
        Atracciones = (LinkedList) IO.Cargar(ARCHIVO);
    }
}
