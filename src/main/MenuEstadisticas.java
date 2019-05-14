package main;

import Entradas.GestorEntradas;
import Estadisticas.GestorGastos;
import Estadisticas.MesAnio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static main.CommonDates.error;

final class MenuEstadisticas{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void goEstadisticas() {
		Menu.imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Recuperar Gastos                               |");
		System.out.println("        |         2) Recuperar Ingresos                             |");
		System.out.println("        |         3) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");
		try {
			int i = Integer.parseInt(br.readLine());
			MenuComun.clearConsole();
			Period period = Period.ANUAL;
			int anio = -1;
			int month = -1;
			if (i < 3) period = seleccionarPeriodo();
			switch (i) {
				case 1:
					switch (period) {
						case ANUAL:
							anio = CommonDates.getYear();
							System.out.println(GestorGastos.getGastosAnio(anio));
							break;
						case DIARIO:
							anio = MenuComun.getInt("       Por favor introduce un anio");
							while(month<1 || month>12){
								month = MenuComun.getInt("      Por favor introduce un mes");
							}
							System.out.println(GestorGastos.getGastos(new MesAnio(Month.of(month),anio))/CommonDates.getMaxDayOfMonth(Year.of(anio).isLeap(),Month.of(month)));
							break;
						case MENSUAL:
							anio = MenuComun.getInt("       Por favor introduce un anio");
							while(month<1 || month>12){
								month = MenuComun.getInt("      Por favor introduce un mes");
							}
							System.out.println(GestorGastos.getGastos(new MesAnio(Month.of(month),anio)));
							break;
					}
					MenuComun.anyKeyContinue();
					break;
				case 2:
					Double[] entradas;
					switch (period) {
						case ANUAL:
							anio = CommonDates.getYear();
							entradas = GestorEntradas.recuperarEntradasAnual(anio);
							System.out.println("        Para ese periodo hubo "+ entradas[0].intValue() + " entradas compradas sumando un valor de " + entradas[1] + " euros");
							break;
						case DIARIO:
							int day = -1;
							anio = MenuComun.getInt("       Por favor introduce un anio");
							while(month<1 || month>12){
								month = MenuComun.getInt("      Por favor introduce un mes");
							}
							int maxday = CommonDates.getMaxDayOfMonth(Year.of(anio).isLeap(), Month.of(month));
							while(day < 1 || day > maxday) day = MenuComun.getInt("        Por favor introduce un dia");
								entradas = GestorEntradas.recuperarEntradasDiaria(LocalDate.of(anio,Month.of(month),day));
								System.out.println("        Para ese periodo hubo "+ entradas[0].intValue() + " entradas compradas sumando un valor de " + entradas[1] + " euros");
							break;
						case MENSUAL:
							anio = MenuComun.getInt("       Por favor introduce un anio");
							while(month<1 || month>12){
								month = MenuComun.getInt("      Por favor introduce un mes");
							}
							entradas = GestorEntradas.recuperarEntradasMensual(new MesAnio(Month.of(month),anio));
							System.out.println("        Para ese periodo hubo "+ entradas[0].intValue() + " entradas compradas sumando un valor de " + entradas[1] + " euros");
							break;
					}
					break;
			}
			if (i != 3) goEstadisticas();
		} catch (NumberFormatException | NullPointerException | IOException o) {
			System.out.println(error);
		}
	}

	private static Period seleccionarPeriodo() {
		System.out.println("        Que periodo desea consultar:");
		System.out.println("        1)  DIARIO");
		System.out.println("        2)  MENUSAL");
		System.out.println("        3)  ANUAL");
		try {
			int i = Integer.parseInt(br.readLine());
			MenuComun.clearConsole();
			switch (i) {
				case 1:
					return Period.DIARIO;
				case 2:
					return Period.MENSUAL;
				case 3:
					return Period.ANUAL;
			}
		} catch (IOException | NumberFormatException e) {
			Launch.LOGGER.severe(LOG.getStackTrace(e));
			System.out.println(error);
		}
		return Period.ANUAL;
	}

	private enum Period {
		DIARIO,
		MENSUAL,
		ANUAL
	}
}

