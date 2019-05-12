package Estadisticas;

import io.IO;

import java.time.Month;
import java.util.HashMap;

import static Estadisticas.Estadisticas.calcularTotalSueldo;


public final class GestorGastos implements IO {
	private static final String ARCHIVO = "DATA/gastos";
	private static HashMap<MesAnio, Integer> gastos = new HashMap<>();

	public static void nuevoBalance(MesAnio a) {
		gastos.put(a, calcularTotalSueldo());
	}

	public static void guardar() {
		IO.guardar(ARCHIVO, gastos);
	}

	public static void cargar() {
		gastos = (HashMap<MesAnio, Integer>) IO.cargar(ARCHIVO);
	}

	public static void borrar() {
		gastos.clear();
	}

	private GestorGastos() {
		throw new IllegalStateException("No se pueden hacer instancias de los gestores");
	}
}
