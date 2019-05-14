package io;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Logger;

import main.LOG;

public abstract class IO {

	private static Logger LOGGER = Logger.getLogger(IO.class.getName());
	private static String ERROR = "Se produjo un error en";
	private static String CARGADO = "Datos cargados correctamente en ";

	protected static HashMap cargar(String nombre) {
		try {
			FileInputStream fis = new FileInputStream(nombre);
			ObjectInputStream ois = new ObjectInputStream(fis);
			HashMap temp = new HashMap((HashMap) ois.readObject());
			ois.close();
			fis.close();
			LOGGER.info(CARGADO + " " + nombre + "!");
			return temp;
		} catch (
				IOException | ClassNotFoundException | NullPointerException ioe) {
			LOGGER.severe(LOG.getStackTrace(ioe));
			LOGGER.info("Generando nuevo fichero " + nombre);
			return new HashMap();
		}
	}
	protected IO(){}
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
			LOGGER.severe(LOG.getStackTrace(ioe));
			LOGGER.info("Generando nuevo fichero " + nombre);
			return new LinkedList();
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
			LOGGER.severe(LOG.getStackTrace(ioe));
			throw new IllegalStateException(ERROR + nombre);
		}
	}
}
