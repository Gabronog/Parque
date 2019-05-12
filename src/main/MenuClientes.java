package main;

import Entradas.GestorEntradas;
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
					System.out.println("        Recuperada informacion del cliente " + Cliente.getNombre() + " con dni " + Cliente.getDni());
					System.out.println("        Altura: " + Cliente.getAltura());
					System.out.println("        Edad: " + Cliente.getEdad());
					if (Cliente.isDiscapacitado()) {
						System.out.println("        Discapacitado");
					} else {
						System.out.println("        No discapacitado");
					}
					if (Cliente.getCarnetDeDescuento() != -1){
						System.out.println("        Carnet de descuento: " + Cliente.getCarnetDeDescuento());
					}
					break;
				case 2:
					Persona Cliente0 = getClient();
					boolean vip = MenuComun.getyesno("      Entrada VIP S/N?");
					LocalDate localDate = CommonDates.getLocalDate();
					if (localDate == null) return;
					Cliente0.comprarEntrada(vip,localDate);
					System.out.println("Comprada entrada por " + GestorEntradas.obtener(localDate,Cliente0.getDni()).getPrecio() + " euros para el dia " + localDate.format(DateTimeFormatter.ISO_DATE));
					break;
				case 3:
					MenuComun.clearConsole();
					System.out.println("        Introduzca el nombre del cliente por favor");
					String nombre = MenuComun.getName();
					int altura = getInt("        Por favor introduzca su altura en cm");
					int edad = getInt("     Por favor introduzca su edad");
					System.out.println("        Por favor introduzca el DNI");
					int dni = MenuComun.getDni();
					GestorUsuarios.insertarUsuario(dni,nombre,edad,altura);
					break;
				case 4:
					MenuComun.clearConsole();
					Persona cliente = getClient();
					boolean carnet = MenuComun.getyesno("       Introducir un carnet de descuento S/N");
					if(carnet) cliente.conCarnet(getInt("        Introduzca el numero de carnet por favor"));
					if(MenuComun.getyesno("         Posee alguna minusvalia S/N")) cliente.Discapacitado();
					System.out.println("        Actualizada la informacion correctamente");
					break;
			}
			if (i != 5){
				MenuComun.anyKeyContinue();
				goClientes();
			}
		} catch (NumberFormatException | IOException nfe) {
			MenuComun.clearConsole();
			System.err.println("        Formato invalido!");
			goClientes();
		}

	}

	private static int getInt(String s) {
		int altura = -1;
		while(altura<0){
			try{
				if(altura!=-1) System.out.println(CommonDates.error);
				System.out.println(s);
				altura = Integer.parseInt(br.readLine());
			} catch (NumberFormatException |IOException e) {
				altura = -2;
			}
			MenuComun.clearConsole();
		}
	return altura;
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
	private MenuClientes(){
		Launch.LOGGER.severe("ERROR ILLEGAL STATE: LOS MENUS SON HELPERS NO DEBERIAN SER INSTANCIADOS");
	}
}
