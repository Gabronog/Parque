package Atracciones;

import java.io.*;
import java.util.LinkedList;

public abstract class GestorAtracciones {

    private static LinkedList<Object> Atracciones = new LinkedList<>();

    public static void NuevaAtraccion(Atraccion Atraccion) {
        Atracciones.add(Atraccion);
    }

    public static Object ObtenerDatos(int numeroAtraccion) {
        return Atracciones.get(numeroAtraccion);
    }

    public static void Guardar() {
        try {
            FileOutputStream fos = new FileOutputStream("list.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Atracciones);
            oos.close();
            fos.close();
            System.out.println("Datos guardados correctamente!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void Cargar() {
        try {
            FileInputStream fis = new FileInputStream("list.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Atracciones.addAll((LinkedList) ois.readObject());
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
