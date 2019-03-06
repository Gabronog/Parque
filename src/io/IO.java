package io;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class IO {
    public static HashMap Cargar(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap temp = new HashMap((HashMap) ois.readObject());
            ois.close();
            fis.close();
            System.out.println("Datos cargados correctamente");
            return temp;
        } catch (
                IOException | NullPointerException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos");
        } catch (ClassNotFoundException c) {
            System.out.println("Clase no encontrada.");
            c.printStackTrace();
        }
        return new HashMap();
    }

    public static LinkedList CargarLista(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList temp = new LinkedList((LinkedList) ois.readObject());
            ois.close();
            fis.close();
            System.out.println("Datos cargados correctamente");
            return temp;
        } catch (IOException | ClassNotFoundException | NullPointerException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos");
        }
        return new LinkedList();
    }

    public static void Guardar(String nombre, Object map) {
        try {
            FileOutputStream fos = new FileOutputStream(nombre);
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
