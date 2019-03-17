package main;

import Estadisticas.GestorGastos;
import Estadisticas.GestorGastos.MesAnio;

import java.time.LocalDate;

abstract class ComprobarFecha {

    static void comprobar(){
        LocalDate date = LocalDate.now();
        MesAnio mesAnio = new MesAnio(date.getMonth(),date.getYear());
        if(date.getDayOfMonth() == date.lengthOfMonth()){
            GestorGastos.nuevoBalance(mesAnio);
            System.out.println("FINAL DE MES");
        }
        //No es final de mes
        System.out.println("NO FINAL DE MES");
    }



}
