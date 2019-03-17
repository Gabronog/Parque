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
            System.out.println("Datos cargados correctamente en " + nombre +"!");
            return temp;
        } catch (
                IOException | NullPointerException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos en " + nombre);
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
            System.out.println("Datos cargados correctamente en " + nombre +"!");
            return temp;
        } catch (IOException | ClassNotFoundException | NullPointerException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos en " + nombre);
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
            System.out.println("Datos guardados correctamente en " + nombre + "!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Se produjo un error al cargar los datos en " + nombre);
        }
    }
}
