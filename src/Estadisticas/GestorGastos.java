package Estadisticas;

import io.IO;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;

import static Estadisticas.Estadisticas.calcularTotalSueldo;

public abstract class GestorGastos {
    private final static String archivo = "DATA/Gastos";
    private static HashMap<MesAnio,Integer> Gastos = new HashMap<>();

    public static void nuevoBalance(MesAnio a){
        Gastos.put(a,calcularTotalSueldo());
    }

    public static void Guardar() {
        IO.Guardar(archivo, Gastos);
    }

    public static void Cargar() {
        Gastos = (HashMap<MesAnio,Integer>) IO.Cargar(archivo);
    }

    public static class MesAnio{
        private Month mes;
        private int Anio;
        public MesAnio(Month month, int year){
            this.Anio = year;
            this.mes = month;
        }

        public int getAnio() {
            return Anio;
        }
        public Month getMes(){
            return mes;
        }
    }
}
