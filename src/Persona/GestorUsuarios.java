package Persona;

import java.io.*;
import java.util.HashMap;


public abstract class GestorUsuarios {
    private static HashMap<Integer, Persona> Usuarios = new HashMap<Integer, Persona>();

    public static void MeterUsuario(int DNI, String Nombre, int Edad, int Altura) {
        Usuarios.put(DNI, new Persona(Nombre, Edad, Altura));
    }

    public static Persona ObtenerDatos(int DNI) {
        return Usuarios.get(DNI);
    }

    public static void Guardar() {
        try {
            FileOutputStream fos = new FileOutputStream("hashmap.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Usuarios);
            oos.close();
            fos.close();
            System.out.println("Datos guardados correctamente!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void Cargar() {
        try {
            FileInputStream fis = new FileInputStream("hashmap.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Usuarios.putAll((HashMap) ois.readObject());
            ois.close();
            fis.close();
            System.out.println("Datos cargados correctamente");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos");
        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada.");
            c.printStackTrace();
        }
    }
}

