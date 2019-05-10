package io;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;
import main.LOG;

public interface IO {

    Logger LOGGER = Logger.getLogger(IO.class.getName());
    String ERROR = "Se produjo un error en";
    String CARGADO = "Datos cargados correctamente en ";

    static HashMap cargar(String nombre) {
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
            LOGGER.severe(LOG.getStackTrace(ioe));
            LOGGER.info("Generando nuevo fichero " + nombre);
            return new HashMap();
        }
    }

    static LinkedList cargarLista(String nombre) {
        try {
            FileInputStream fis = new FileInputStream(nombre);
            ObjectInputStream ois = new ObjectInputStream(fis);
            LinkedList temp = new LinkedList((LinkedList) ois.readObject());
            ois.close();
            fis.close();
            LOGGER.info(CARGADO + nombre + "!");
            return temp;
        } catch (IOException | ClassNotFoundException | NullPointerException ioe) {
            LOGGER.severe(LOG.getStackTrace(ioe));
            LOGGER.info("Generando nuevo fichero " + nombre);
            return new LinkedList();
        }
    }

    static void guardar(String nombre, Object map) {
        try {
            try (FileOutputStream fos = new FileOutputStream(nombre)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(map);
                oos.close();
            }
            LOGGER.info("Datos guardados correctamente en " + nombre + "!");
        } catch (IOException ioe) {
            LOGGER.severe(LOG.getStackTrace(ioe));
            throw new IllegalStateException(ERROR + nombre);
        }
    }
}
