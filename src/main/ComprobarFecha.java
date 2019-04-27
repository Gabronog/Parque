package main;

import Estadisticas.GestorGastos;
import Estadisticas.GestorGastos.MesAnio;

import java.time.LocalDate;
import java.util.logging.Logger;

interface ComprobarFecha {
    Logger LOGGER = Logger.getLogger(ComprobarFecha.class.getName());
    static void comprobar(){
        LocalDate date = LocalDate.now();
        MesAnio mesAnio = new MesAnio(date.getMonth(),date.getYear());
        if(date.getDayOfMonth() == date.lengthOfMonth()){
            GestorGastos.nuevoBalance(mesAnio);
            LOGGER.info("-Hoy es final de mes, guardando los gastos de este mes-");
        }
        //No es final de mes
        System.out.println("NO FINAL DE MES");
    }



}
