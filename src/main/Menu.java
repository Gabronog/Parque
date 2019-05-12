package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


final class Menu {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void imprimirBienvenida() throws InterruptedException {
		MenuComun.clearConsole();
		System.out.println("        =============================================================");
		System.out.println("        |                                                           |");
		System.out.println("        |       Bienvenido al programa de gestion de EuroPark       |");
		System.out.println("        |                                                           |");
		System.out.println("        =============================================================");
		Thread.sleep(2000);
		MenuComun.clearConsole();
		goMenu();
	}

	static void goMenu() {
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Gestionar Atracciones                          |");
		System.out.println("        |         2) Gestionar Trabajadores                         |");
		System.out.println("        |         3) Gestionar Clientes                             |");
		System.out.println("        |         4) Ver estadisticas de rendimiento                |");
		System.out.println("        |         5) Sobrescribir datos por los del enunciado       |");
		System.out.println("        |         6) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");
		try {
			int i = Integer.parseInt(br.readLine());
			switch (i) {
				case 1:
					MenuComun.clearConsole();
					MenuAtracciones.goAtracciones();
					break;
				case 2:
					MenuComun.clearConsole();
					MenuTrabajadores.goTrabajadores();
					break;
				case 3:
					MenuComun.clearConsole();
					MenuClientes.goClientes();
					break;
				case 4:
					MenuComun.clearConsole();
					goEstadisticas();
					break;
				case 5:
					MenuComun.clearConsole();
					DatosEnunciado.cargarDatosEnunciado();
					System.out.println("        Datos cargados correctamente.");
					break;
			}
			MenuComun.anyKeyContinue();
			if (i != 6) goMenu();
		} catch (NumberFormatException | IOException nfe) {
			MenuComun.clearConsole();
			System.err.println("        Formato invalido!");
			goMenu();
		}
	}


	private static void goEstadisticas() {
		//TODO
	}

	public static void imprimirCabecera() {
		System.out.println("        -------------------------------------------------------------");
		System.out.println("        |           Seleccione una opcion para continuar            |");
		System.out.println("        -------------------------------------------------------------");
	}


}

