package Entradas;

import Estadisticas.MesAnio;
import io.IO;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedList;

public final class GestorEntradas {
	private static final String ARCHIVO = "DATA/numeroEntradas";
	private static final String ARCHIVO2 = "DATA/entradas";
	private static HashMap<MesAnio, Integer> numeroEntradas = new HashMap<>();
	private static HashMap<Integer,HashMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>> entradas = new HashMap<>();
	public static void guardar() {
		IO.guardar(ARCHIVO, numeroEntradas);
		IO.guardar(ARCHIVO2,entradas);
	}

	public static void cargar() {
		numeroEntradas = (HashMap<MesAnio, Integer>) IO.cargar(ARCHIVO);
		entradas = (HashMap<Integer,HashMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>>) IO.cargar(ARCHIVO2);
	}
	public static void insertarNuevaEntrada(Entrada entrada, LocalDate date){
		if(!entradas.containsKey(date.getYear())) entradas.put(date.getYear(),new HashMap<>());
		if(!entradas.get(date.getYear()).containsKey(date.getMonth())) entradas.get(date.getYear()).put(date.getMonth(),new HashMap<>());
		if(!entradas.get(date.getYear()).get(date.getMonth()).containsKey(date.getDayOfMonth())) entradas.get(date.getYear()).get(date.getMonth()).put(date.getDayOfMonth(),new HashMap<>());
		entradas.get(date.getYear()).get(date.getMonth()).get(date.getDayOfMonth()).put(entrada.persona.getDni(),entrada);
	}
	public static int getNumeroEntradasAnio(int anio){
		int entradasAnio = 0;
		for(int i=1;i<=12;i++){
			entradasAnio += numeroEntradas.getOrDefault(new MesAnio(Month.of(i),anio),0);
		}
		return entradasAnio;
	}

	public static void aumentarNumeroDeEntradas(MesAnio mesAnio){
		numeroEntradas.put(mesAnio, numeroEntradas.getOrDefault(mesAnio,0)+1);
	}

	public static Integer getNumeroEntradas(MesAnio mesAnio){
		return numeroEntradas.getOrDefault(mesAnio,0);
	}
	public static void borrar(){
		numeroEntradas.clear();
		entradas.clear();
	}
	private GestorEntradas() {
		throw new IllegalStateException("No se pueden hacer instancias de los gestores");
	}
}
