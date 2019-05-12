package Entradas;

import Estadisticas.MesAnio;
import io.IO;

import java.util.HashMap;

public final class GestorEntradas {
	private static final String ARCHIVO = "DATA/entradas";
	private static HashMap<MesAnio, Integer> entradas = new HashMap<>();

	public static void guardar() {
		IO.guardar(ARCHIVO, entradas);
	}

	public static void cargar() {
		entradas = (HashMap<MesAnio, Integer>) IO.cargar(ARCHIVO);
	}

	public static void aumentarEntrada(MesAnio mesAnio){
		entradas.put(mesAnio,entradas.getOrDefault(mesAnio,0)+1);
	}

	public static Integer getNumeroEntradas(MesAnio mesAnio){
		return entradas.getOrDefault(mesAnio,0);
	}
	public static void borrar(){
		entradas.clear();
	}
	private GestorEntradas() {
		throw new IllegalStateException("No se pueden hacer instancias de los gestores");
	}
}
