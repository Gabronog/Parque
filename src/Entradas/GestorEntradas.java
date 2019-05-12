package Entradas;

import Estadisticas.MesAnio;
import io.IO;

import java.time.LocalDate;
import java.time.Month;
import java.util.EnumMap;
import java.util.HashMap;

public final class GestorEntradas {
	private static final String ARCHIVO = "DATA/entradas";
	private static HashMap<Integer,EnumMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>> entradas = new HashMap<>();
	public static void guardar() {
		IO.guardar(ARCHIVO,entradas);
	}

	public static void cargar() {
		entradas = (HashMap<Integer,EnumMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>>) IO.cargar(ARCHIVO);
	}
	public static void insertarNuevaEntrada(Entrada entrada, LocalDate date){
		if(!entradas.containsKey(date.getYear())) entradas.put(date.getYear(),new EnumMap<>(Month.class));
		if(!entradas.get(date.getYear()).containsKey(date.getMonth())) entradas.get(date.getYear()).put(date.getMonth(),new HashMap<>());
		if(!entradas.get(date.getYear()).get(date.getMonth()).containsKey(date.getDayOfMonth())) entradas.get(date.getYear()).get(date.getMonth()).put(date.getDayOfMonth(),new HashMap<>());
		entradas.get(date.getYear()).get(date.getMonth()).get(date.getDayOfMonth()).put(entrada.persona.getDni(),entrada);
	}

	public static void borrar(){
		entradas.clear();
	}
	private GestorEntradas() {
		throw new IllegalStateException("No se pueden hacer instancias de los gestores");
	}

	public static Entrada obtener(LocalDate date,int DNI) {
		try{
			return entradas.get(date.getYear()).get(date.getMonth()).get(date.getDayOfMonth()).get(DNI);
		}
		catch (NullPointerException nul){
			System.out.println("        No se encuentran entradas para ese dia y ese persona");
			return null;
		}
	}
}
