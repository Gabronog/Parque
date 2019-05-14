package Entradas;

import Estadisticas.MesAnio;
import io.IO;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class GestorEntradas extends IO{
	private static final String ARCHIVO = "DATA/entradas";
	private static HashMap<Integer,EnumMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>> entradas = new HashMap<>();
	public static void save() {
		guardar(ARCHIVO,entradas);
	}

	public static void load() {
		entradas = (HashMap<Integer,EnumMap<Month,HashMap<Integer, HashMap<Integer,Entrada>>>>) cargar(ARCHIVO);
	}
	public static void insertarNuevaEntrada(Entrada entrada, LocalDate date){
		if(!entradas.containsKey(date.getYear())) entradas.put(date.getYear(),new EnumMap<>(Month.class));
		if(!entradas.get(date.getYear()).containsKey(date.getMonth())) entradas.get(date.getYear()).put(date.getMonth(),new HashMap<>());
		if(!entradas.get(date.getYear()).get(date.getMonth()).containsKey(date.getDayOfMonth())) entradas.get(date.getYear()).get(date.getMonth()).put(date.getDayOfMonth(),new HashMap<>());
		entradas.get(date.getYear()).get(date.getMonth()).get(date.getDayOfMonth()).put(entrada.persona.getDni(),entrada);
	}
	public static Double[] recuperarEntradasDiaria(LocalDate date){
		try{
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			HashMap<Integer,Entrada> entradaspordia = entradas.get(date.getYear()).get(date.getMonth()).get(date.getDayOfMonth());
			for(Entrada e : entradaspordia.values()) {
				entrada[0]++;
				entrada[1] += e.getPrecio();
			}
			return entrada;
		}catch (Exception ignored){
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			return entrada;
		}
	}

	public static Double[] recuperarEntradasMensual(MesAnio mesAnio){
		try {
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			HashMap<Integer,HashMap<Integer,Entrada>> entradaspormes = entradas.get(mesAnio.getAnio()).get(mesAnio.getMes());
			for(Integer e : entradaspormes.keySet()) {
				Double[] entradas = recuperarEntradasDiaria(LocalDate.of(mesAnio.getAnio(),mesAnio.getMes(),e));
				entrada[0] += entradas[0];
				entrada[1] += entradas[1];
			}
			return entrada;
		} catch (Exception e) {
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			return entrada;
		}
	}

	public static Double[] recuperarEntradasAnual(int year){
		try{
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			EnumMap<Month,HashMap<Integer,HashMap<Integer,Entrada>>> entradasporanio = entradas.get(year);
			for(Month month : entradasporanio.keySet()){
				Double[] entradas = recuperarEntradasMensual(new MesAnio(month, year));
				entrada[0] += entradas[0];
				entrada[1] += entradas[1];
			}
			return entrada;
		} catch (Exception e) {
			Double[] entrada = new Double[2];
			entrada[0] = 0.0;
			entrada[1] = 0.0;
			return entrada;
		}
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
