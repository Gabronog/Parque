package Persona;

import io.IO;

import java.util.HashMap;


public abstract class GestorUsuarios {
    private final static String archivo = "DATA/Clientes";
    private static HashMap<Integer, Persona> Usuarios = new HashMap<Integer, Persona>();

    public static void MeterUsuario(int DNI, String Nombre, int Edad, int Altura) {
        Usuarios.put(DNI, new Persona(Nombre, Edad, Altura));
    }

    public static Persona ObtenerDatos(int DNI) {
        try {
            return Usuarios.get(DNI);
        } catch (NullPointerException a) {
            System.out.println("No encontrado");
            a.printStackTrace();
            return null;
        }
    }
    public static void Borrar(){
        Usuarios.clear();
    }

    public static void Guardar() {
        IO.Guardar(archivo, Usuarios);
    }

    public static void Cargar() {

        Usuarios = (HashMap<Integer, Persona>) IO.Cargar(archivo);
    }
}

