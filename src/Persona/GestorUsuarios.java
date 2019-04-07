package Persona;

import io.IO;

import java.util.HashMap;
import java.util.logging.Logger;


public abstract class GestorUsuarios extends IO{
    private static final String ARCHIVO = "DATA/Clientes";
    private static HashMap<Integer, Persona> usuarios = new HashMap<>();
    private static final Logger LOGGER = Logger.getLogger(GestorUsuarios.class.getName());
    public static void insertarUsuario(int dni, String nombre, int edad, int altura) {
        usuarios.put(dni, new Persona(nombre, edad, altura));
    }

    public static Persona obtenerDatos(int dni) {
        try {
            return usuarios.get(dni);
        } catch (NullPointerException a) {
            System.out.println("No encontrado");
            a.printStackTrace();
            return null;
        }
    }
    public static void borrar(){
        usuarios.clear();
    }

    public static void guardar() {
        guardar(ARCHIVO, usuarios);
    }

    public static void cargar() {
        usuarios = (HashMap<Integer, Persona>) cargar(ARCHIVO);
    }
}

