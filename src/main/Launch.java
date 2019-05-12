package main;

import Atracciones.*;
import Entradas.GestorEntradas;
import Estadisticas.GestorGastos;
import Persona.GestorUsuarios;
import personal.*;

import java.util.logging.*;

import static main.LOG.getStackTrace;
import static main.LOG.inicializarLOG;

public class Launch{
    private static final Logger LOGGER = Logger.getLogger("");

    public static void main(String[] args) {
        try {
            inicializarLOG(LOGGER);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE,getStackTrace(e));
        }
        LOGGER.log(Level.INFO,"Cargando datos...");
        cargarDatos(); //Carga los datos serializados previamente de atracciones y clientes
        LOGGER.log(Level.INFO,"Se cargaron todos los datos");
        // cargarDatosEnunciado();
        launch();
        guardarDatos(); //Guarda los datos de las atracciones y de los clientes
        ComprobarFecha.comprobar();
    }

    private static void launch() {
        try {
            Menu.imprimirBienvenida();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void cargarDatos() {
        LOGGER.info("Cargando clientes de la empresa...");
        GestorUsuarios.cargar();
        LOGGER.info("Cargando las atracciones...");
        GestorAtracciones.cargar();
        LOGGER.info("Cargando la informacion acerca del personal...");
        GestorPersonal.cargar();
        LOGGER.info("Cargando la informacion de los balances de gastos...");
        GestorGastos.cargar();
        LOGGER.info("Cargando la informacion de las entradas...");
        GestorEntradas.cargar();
    }

    private static void guardarDatos() {
        GestorAtracciones.guardar();
        GestorUsuarios.guardar();
        GestorPersonal.guardar();
        GestorGastos.guardar();
        GestorEntradas.guardar();
        LOGGER.info("Guardados todos los datos correctamente");
    }

    static void borrarDatos(){
        GestorAtracciones.borrar();
        GestorUsuarios.borrar();
        GestorPersonal.borrar();
        GestorEntradas.borrar();
        GestorGastos.borrar();
        LOGGER.info("Borrados todos los datos");
        guardarDatos();
    }
}

