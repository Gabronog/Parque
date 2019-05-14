package Estadisticas;

import io.IO;
import main.CommonDates;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;

import static Estadisticas.Estadisticas.calcularTotalSueldo;


public final class GestorGastos extends IO {
	private static final String ARCHIVO = "DATA/gastos";
	private static HashMap<MesAnio, Integer> gastos = new HashMap<>();

	public static void nuevoBalance(MesAnio a) {
		gastos.put(a, calcularTotalSueldo() * CommonDates.getMaxDayOfMonth(Year.of(a.getAnio()).isLeap(),a.getMes()));
	}

	public static void save() {
		guardar(ARCHIVO, gastos);
	}

	public static void load() {
		gastos = (HashMap<MesAnio, Integer>) cargar(ARCHIVO);
	}

	public static void borrar() {
		gastos.clear();
	}
	public static int getGastos(MesAnio mesAnio){
		return gastos.getOrDefault(mesAnio,0);
	}
	public static int getGastosAnio(int anio){
		int gastosAnio = 0;
		for(int i=1;i<=12;i++){
			gastosAnio += gastos.getOrDefault(new MesAnio(Month.of(i),anio),0);
		}
		return gastosAnio;
	}

	private GestorGastos() {
		throw new IllegalStateException("No se pueden hacer instancias de los gestores");
	}
}
