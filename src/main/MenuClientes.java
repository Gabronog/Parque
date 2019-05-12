package main;

import Persona.Persona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import Persona.GestorUsuarios;

final class MenuClientes {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void goClientes() {
		Menu.imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Recuperar datos de un cliente                  |");
		System.out.println("        |         2) Comprar entradas                               |");
		System.out.println("        |         3) Crear un cliente                               |");
		System.out.println("        |         4) Modificar los descuentos de un cliente         |");
		System.out.println("        |         5) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");
		try {
			int i = Integer.parseInt(br.readLine());
			MenuComun.clearConsole();
			switch (i) {
				case 1:
					Persona Cliente = getClient();
					MenuComun.clearConsole();
					System.out.println("        Recuperada informacion del cliente " + Cliente.getNombre() + "con dni " + Cliente.getDni());
					System.out.println("        Altura: " + Cliente.getAltura());
					System.out.println("        Edad: " + Cliente.getEdad());
					if (Cliente.isDiscapacitado()) {
						System.out.println("        Discapacitado");
					} else {
						System.out.println("      No discapacitado");
					}
					if (Cliente.getCarnetDeDescuento() != 0){
						System.out.println("Carnet de descuento: " + Cliente.getCarnetDeDescuento());
					}
					break;
				case 2:
					Persona Cliente0 = getClient();
					boolean vip = MenuComun.getyesno("      Entrada VIP S/N?");
					LocalDate localDate = CommonDates.getLocalDate();
					if (localDate == null) return;
					Cliente0.comprarEntrada(vip,localDate);
					System.out.println("Comprada entrada para el dia " + localDate.format(DateTimeFormatter.ISO_DATE));
					MenuComun.anyKeyContinue();
					break;
				case 3:
					MenuComun.clearConsole();
					String nombre = MenuComun.getName();
					System.out.println("        Por favor introduzca su altura en cm");

					break;
				case 4:
					MenuComun.clearConsole();
					break;
			}
			MenuComun.anyKeyContinue();
			if (i != 5) goClientes();
		} catch (NumberFormatException | IOException nfe) {
			MenuComun.clearConsole();
			System.err.println("        Formato invalido!");
			goClientes();
		}

	}
	static Persona getClient() {
		int dniaRecuperar = -1;
		while (GestorUsuarios.obtenerDatos(dniaRecuperar) == null) {
			MenuComun.clearConsole();
			if(dniaRecuperar!=-1) System.out.println("      No se encuentra un cliente con ese dni");
			System.out.println("        Por favor introduzca el dni del usuario a recuperar");
			dniaRecuperar = MenuComun.getDni();
		}
		return GestorUsuarios.obtenerDatos(dniaRecuperar);
	}
}
