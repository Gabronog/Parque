package main;

import Estadisticas.Estadisticas;
import personal.GestorPersonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class Menu{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		System.out.println("        |         3) Gestionar Entradas                             |");
		System.out.println("        |         4) Ver estadisticas de rendimiento                |");
		System.out.println("        |         5) Gestionar Clientes                             |");
		System.out.println("        |         6) Sobrescribir datos por los del enunciado       |");
		System.out.println("        |         7) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");
		try{
			int i = Integer.parseInt(br.readLine());
			switch (i){
				case 1: clearConsole();
						MenuAtracciones.goAtracciones();
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
						DatosEnunciado.cargarDatosEnunciado();
						System.out.println("        Datos cargados correctamente.");
						System.out.println("        Pulsa cualquier tecla para continuar...");
						try
						{
							System.in.read();
						}
						catch(Exception e)
						{
							System.err.println("Ha surgido un problema.");
						}
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

	private static void obtenerTipoEmpleado(){
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Ayudante                                       |");
		System.out.println("        |         2) Responsable                                    |");
		System.out.println("        |         3) Atencion al cliente                            |");
		System.out.println("        |         4) Relaciones publicas                            |");
		System.out.println("        |         5) Volver                                         |");
		System.out.println("        -------------------------------------------------------------");


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
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Ver numero de trabajadores por tipo            |");
		System.out.println("        |         2) Ver total de trabajadores                      |");
		System.out.println("        |         3) Contratar un nuevo trabajador                  |");
		System.out.println("        |         4) Despedir un trabajador NO ASIGNADO A ATRACCION |");
		System.out.println("        |         5) Asignar un trabajador a una atraccion          |");
		System.out.println("        |         6) Desasignar un trabajador a una atraccion       |");
		System.out.println("        |         7) Salir del programa                             |");
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
					System.out.println("El numero de trabajadores de EuroPark es: " + Estadisticas.calcularTotalEmpleados());
					MenuAtracciones.anyKeyContinue();
					break;
				case 3:
					clearConsole();
					goEntradas();
					break;
				case 4:
					int dni = MenuAtracciones.getDni();
					GestorPersonal.borrar(dni);
					System.out.println("Borrado el empleado con DNI " + dni);
					break;
				case 5:
					clearConsole();
					goClientes();
					break;
				case 6:
					clearConsole();
			}
			if(i!=7) goTrabajadores();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public static void imprimirCabecera() {
		System.out.println("        -------------------------------------------------------------");
		System.out.println("        |           Seleccione una opcion para continuar            |");
		System.out.println("        -------------------------------------------------------------");
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

