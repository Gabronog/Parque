package io;

import java.io.*;
import java.util.HashMap;

public abstract class IO {
    public static Object Cargar(String nombre) {
        try {
            HashMap temp = null;
            FileInputStream fis = new FileInputStream(nombre + ".ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            temp.putAll((HashMap) ois.readObject());
            ois.close();
            fis.close();
            System.out.println("Datos cargados correctamente");
            return temp;
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos");
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada.");
            c.printStackTrace();
            return null;
        }
    }

    public static void Guardar(String nombre, Object map) {
        try {
            FileOutputStream fos = new FileOutputStream(nombre + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map);
            oos.close();
            fos.close();
            System.out.println("Datos guardados correctamente!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
