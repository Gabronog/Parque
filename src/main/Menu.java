package main;

import Estadisticas.Estadisticas;
import personal.GestorPersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Menu {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void imprimirBienvenida() throws InterruptedException {
		clearConsole();
		System.out.println("        =============================================================");
		System.out.println("        |                                                           |");
		System.out.println("        |       Bienvenido al programa de gestion de EuroPark       |");
		System.out.println("        |                                                           |");
		System.out.println("        =============================================================");
		Thread.sleep(2000);
		clearConsole();
		goMenu();
	}

	public static void goMenu() {
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
					clearConsole();
					MenuAtracciones.goAtracciones();
					break;
				case 2:
					clearConsole();
					MenuTrabajadores.goTrabajadores();
					break;
				case 3:
					clearConsole();
					goClientes();
					break;
				case 4:
					clearConsole();
					goEstadisticas();
					break;
				case 5:
					clearConsole();
					DatosEnunciado.cargarDatosEnunciado();
					System.out.println("        Datos cargados correctamente.");
					break;
			}
			anyKeyContinue();
			if (i != 6) goMenu();
		} catch (NumberFormatException | IOException nfe) {
			clearConsole();
			System.err.println("        Formato invalido!");
			goMenu();
		}
	}


	private static void goClientes() {
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Recuperar datos de un cliente                  |");
		System.out.println("        |         2) Comprar entradas                               |");
		System.out.println("        |         3) Crear un cliente                               |");
		System.out.println("        |         4) Modificar datos de un cliente                  |");
		System.out.println("        |         5) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");


	}

	private static void goEstadisticas() {
		//TODO
	}

	public static void imprimirCabecera() {
		System.out.println("        -------------------------------------------------------------");
		System.out.println("        |           Seleccione una opcion para continuar            |");
		System.out.println("        -------------------------------------------------------------");
	}

	public final static void clearConsole() {
		try {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			//TODO
		}
		System.out.println("\n");
	}

	static void anyKeyContinue() {
		System.out.println("        Pulsa cualquier tecla para continuar...");
		try {
			System.in.read();
		} catch (Exception ignored) {
		} finally {
			clearConsole();
		}
	}

}

