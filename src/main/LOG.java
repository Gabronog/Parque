package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

public interface LOG {


    static void inicializarLOG(Logger logger) throws IOException {
        // Con el manejador de archivo, indicamos el archivo donde se mandaran los logs
        LogManager.getLogManager().reset();
        Handler fileHandler = new FileHandler("./LOG/Atracciones.log", false);
        // El formateador indica como presentar los datos, en este caso usaremos el formaro sencillo
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        // Se especifica que formateador usara el manejador (handler) de archivo
        fileHandler.setFormatter(simpleFormatter);

        // Asignamos los handles previamente declarados al log RAIZ esto es muy importante ya que
        // permitira que los logs de todas y cada una de las clases del programa que esten en ese paquete
        // o sus subpaquetes se almacenen en el archivo y aparescan en consola
        logger.addHandler(fileHandler);
        // Indicamos a partir de que nivel deseamos mostrar los logs, podemos especificar un nivel en especifico
        // para ignorar informacion que no necesitemos
        fileHandler.setLevel(Level.ALL);
    }

    /**
     * Esta funcion nos permite convertir el stackTrace en un String, necesario
     * para poder imprimirlos al log debido a cambios en como Java los maneja
     * internamente
     *
     * @param e Excepcion de la que queremos el StackTrace
     * @return StackTrace de la excepcion en forma de String
     */
    static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
