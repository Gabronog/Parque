package io;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

import static main.LOG.getStackTrace;

public abstract class IO {
    private static final Logger LOGGER = Logger.getLogger(IO.class.getName());
    private static final String ERROR = "Se produjo un error en";
    private static final String CARGADO = "Datos cargados correctamente en ";
    public static HashMap cargar(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream ois = new ObjectInputStream(fis);
            HashMap temp = new HashMap((HashMap) ois.readObject());
            ois.close();
            fis.close();
            LOGGER.info(String.format("%s %s!",CARGADO, nombre));
            return temp;
        } catch (
                IOException | ClassNotFoundException| NullPointerException ioe) {
            LOGGER.severe(getStackTrace(ioe));
            throw new IllegalStateException(ERROR + nombre);
        }
    }

    public static LinkedList cargarLista(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList temp = new LinkedList((LinkedList) ois.readObject());
            ois.close();
            fis.close();
            LOGGER.info(CARGADO + nombre + "!");
            return temp;
        } catch (IOException | ClassNotFoundException | NullPointerException ioe) {
            LOGGER.severe(getStackTrace(ioe));
            throw new IllegalStateException(ERROR + nombre);
        }
    }

    public static void guardar(String nombre, Object map) {
        try {
            try (FileOutputStream fos = new FileOutputStream(nombre)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(map);
                oos.close();
            }
            LOGGER.info("Datos guardados correctamente en " + nombre + "!");
        } catch (IOException ioe) {
            LOGGER.severe(getStackTrace(ioe));
            throw new IllegalStateException(ERROR + nombre);
        }
    }
}
