package main;

import Atracciones.Atraccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.DatosEnunciado.cargarDatosEnunciado;

public final class Menu {
	public static void imprimirBienvenida() throws InterruptedException {
		clearConsole();
		System.out.println("        ============================================================");
		System.out.println("        |       Bienvenido al programa de gestion de EuroPark      |");
		System.out.println("        ============================================================");
		Thread.sleep(2000);
		clearConsole();
		goMenu();
	}

	public static void goMenu() {
		System.out.println("        ------------------------------------------------------------");
		System.out.println("        |           Seleccione una opcion para continuar           |");
		System.out.println("        ------------------------------------------------------------");
		System.out.println("        |                                                          |");
		System.out.println("        |         1) Gestionar Atracciones                         |");
		System.out.println("        |         2) Gestionar Trabajadores                        |");
		System.out.println("        |         3) Gestionar Entradas                            |");
		System.out.println("        |         4) Ver estadisticas de rendimiento               |");
		System.out.println("        |         5) Gestionar Clientes                            |");
		System.out.println("        |         6) Sobrescribir datos por los del enunciado      |");
		System.out.println("        |         7) Salir del programa                            |");
		System.out.println("        ------------------------------------------------------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int i = Integer.parseInt(br.readLine());
			switch (i){
				case 1: clearConsole();
						goAtracciones();
						break;
				case 2: clearConsole();
						goTrabajadores();
						break;
				case 3: clearConsole();
						goEntradas();
						break;
				case 4: clearConsole();
						goEstadisticas();
						break;
				case 5: clearConsole();
						goClientes();
						break;
				case 6: clearConsole();
						cargarDatosEnunciado();
						System.out.println("        Datos cargados correctamente.");
						System.out.println("        Pulsa cualquier tecla para continuar...");
						try
						{
							System.in.read();
						}
						catch(Exception e)
						{}
						finally {
							clearConsole();
						}
			}
			if(i!=7) goMenu();
		}
		catch(NumberFormatException | IOException nfe){
			clearConsole();
			System.err.println("        Formato invalido!");
			goMenu();
		}
	}

	private static void goClientes() {
		//TODO
	}

	private static void goEstadisticas() {
		//TODO
	}

	private static void goEntradas() {
		//TODO
	}

	private static void goTrabajadores() {
		//TODO
	}

	private static void goAtracciones() {
		System.out.println("        ------------------------------------------------------------");
		System.out.println("        |           Seleccione una opcion para continuar           |");
		System.out.println("        ------------------------------------------------------------");
		System.out.println("        |                                                          |");
		System.out.println("        |         1) Ver numero de atracciones en funcionamiento   |");
		System.out.println("        |         2) Crear una nueva atraccion                     |");
		System.out.println("        |         3) Gestionar Entradas                            |");
		System.out.println("        |         4) Ver estadisticas de rendimiento               |");
		System.out.println("        |         5) Gestionar Clientes                            |");
		System.out.println("        |         6) Salir del programa                            |");
		System.out.println("        ------------------------------------------------------------");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			int i = Integer.parseInt(br.readLine());
			switch (i){
				case 1: clearConsole();
					System.out.println("        " + Atraccion.getNumeroAtracciones());
					System.out.println("        Pulsa cualquier tecla para continuar...");
					try
					{
						System.in.read();
					}
					catch(Exception e)
					{}
					finally {
						clearConsole();
					}
					goAtracciones();
					break;
				case 2: clearConsole();
						break;
			}
			if(i!=6) goAtracciones();
			else goMenu();
		}
		catch(NumberFormatException | IOException nfe){
			clearConsole();
			System.err.println("        Formato invalido!");
			goAtracciones();
		}
	}
	public final static void clearConsole()
	{
		try
		{
			System.out.print("\033[H\033[2J");
			System.out.flush();
			final String os = System.getProperty("os.name");

			if (os.contains("Windows"))
			{
				Runtime.getRuntime().exec("cls");
			}
			else
			{
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e)
		{
			//TODO
		}
		System.out.println("\n");

	}


}

