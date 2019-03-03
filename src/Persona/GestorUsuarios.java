package Persona;

import io.IO;

import java.util.HashMap;


public abstract class GestorUsuarios {
    private final static String archivo = "clientes";
    private static HashMap<Integer, Persona> Usuarios = new HashMap<Integer, Persona>();

    public static void MeterUsuario(int DNI, String Nombre, int Edad, int Altura) {
        Usuarios.put(DNI, new Persona(Nombre, Edad, Altura));
    }

    public static Persona ObtenerDatos(int DNI) {
        return Usuarios.get(DNI);
    }

    public static void Guardar() {
        IO.Guardar(archivo, Usuarios);
    }

    public static void Cargar() {
        Usuarios = (HashMap<Integer, Persona>) IO.Cargar(archivo);
    }
}

