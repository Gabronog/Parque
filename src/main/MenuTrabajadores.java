package main;

import Atracciones.GestorAtracciones;
import Estadisticas.Estadisticas;
import personal.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.Menu.imprimirCabecera;

public class MenuTrabajadores {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static void goTrabajadores() {
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Ver numero de trabajadores por tipo            |");
		System.out.println("        |         2) Ver total de trabajadores                      |");
		System.out.println("        |         3) Contratar un nuevo trabajador                  |");
		System.out.println("        |         4) Despedir un trabajador NO ASIGNADO A ATRACCION |");
		System.out.println("        |         5) Asignar un Ayudante a una atraccion            |");
		System.out.println("        |         6) Desasignar un Ayudante a una atraccion         |");
		System.out.println("        |         7) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");


		try {
			int i = Integer.parseInt(br.readLine());
			switch (i) {
				case 1:
					Menu.clearConsole();
					int tipoEmpleado = obtenerTipoEmpleado();
					switch (tipoEmpleado){
						case 1:
							System.out.println("        El numero de Ayudantes en Europark es: " + Estadisticas.calcularAyudantes());
							break;
						case 2:
							System.out.println("        El numero de Responsables en Europark es: " + Estadisticas.calcularResponsables());
							break;
						case 3:
							System.out.println("        El numero de Personal de Atencion al cliente contratado en Europark es: " + Estadisticas.calcularAtencion());
							break;
						case 4:
							System.out.println("        El numero de Relaciones Publicas de Europark es: " + Estadisticas.calcularRelaciones());
							break;
						case 5:
							break;
						default:
							System.err.println("        Unexpected value: " + tipoEmpleado);
					}
					Menu.anyKeyContinue();
					break;
				case 2:
					Menu.clearConsole();
					System.out.println("        El numero de trabajadores de EuroPark es: " + Estadisticas.calcularTotalEmpleados());
					Menu.anyKeyContinue();
					break;
				case 3:
					Menu.clearConsole();

					int tipoEmpleado2 = obtenerTipoEmpleado();
					switch (tipoEmpleado2){
						case 1:
							MenuAtracciones.crearAyudante();
							break;
						case 2:
							MenuAtracciones.crearResponsable();
							break;
						case 3:
							crearAtencion();
							break;
						case 4:
							crearRelaciones();
							break;
						case 5:
							break;
						default:
							System.err.println("        Unexpected value: " + tipoEmpleado2);
					}
					Menu.anyKeyContinue();
					break;
				case 4:
					System.out.println("        Por favor introduzca el dni del empleado que quiere despedir");
					int dni = MenuAtracciones.getDni();
					GestorPersonal.borrar(dni);
					System.out.println("        Borrado del sistema el empleado con DNI " + dni);
					break;
				case 5:
					Menu.clearConsole();
					String input = "";
					int numeroAtraccion = MenuAtracciones.preguntarNumeroAtraccion();
					while (!input.equals("S") && !input.equals("N")) {
						if (!input.equals(""))
							System.err.println("       Formato invalido introduzca S para crear un responsable o N para usar un responsable");
						System.out.println(input);
						System.out.println("        Desea contratar el ayudante S/N");
						System.out.print("        >>");
						input = br.readLine().toUpperCase();
					}
					Ayudantes ayudante;
					if(input.equals("S")) ayudante = MenuAtracciones.crearAyudante();
					else ayudante = (Ayudantes) GestorPersonal.obtener(MenuAtracciones.getDni());
					GestorAtracciones.obtenerDatos(numeroAtraccion).insertar(ayudante);
					break;
				case 6:
					Menu.clearConsole();
					int numeroAtraccion2 = MenuAtracciones.preguntarNumeroAtraccion();
					int dniDesasignar = MenuAtracciones.getDni();
					GestorAtracciones.obtenerDatos(numeroAtraccion2).getDNI(dniDesasignar).dejarAtraccion();
			}
			Menu.clearConsole();
			if(i!=7) goTrabajadores();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static int obtenerTipoEmpleado() {
		imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Ayudante                                       |");
		System.out.println("        |         2) Responsable                                    |");
		System.out.println("        |         3) Atencion al cliente                            |");
		System.out.println("        |         4) Relaciones publicas                            |");
		System.out.println("        |         5) Volver                                         |");
		System.out.println("        -------------------------------------------------------------");
		try {
			int i = -1;
			while(i < 1 || i > 5) {
				if(i!=-1) System.err.println("      Format error");
				i = Integer.parseInt(br.readLine());
			}
			return i;
		} catch (IOException | NumberFormatException e) {
			Menu.clearConsole();
			System.err.println("        Se produjo un error!");
		}
		return 0;
	}
	static Atencion crearAtencion() {
		System.out.println("        Introduzca el numero de DNI del trabajador de Atencion al cliente");
		int dniAtencion = MenuAtracciones.getDni();
		Menu.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniAtencion);
		String nombre = getName();
		System.out.println("        Creado nuevo personal de Atencion al cliente con DNI " + dniAtencion);
		return  new Atencion(nombre, dniAtencion);
	}
	static Relaciones crearRelaciones() {
		System.out.println("        Introduzca el numero de DNI del trabajador de Relaciones publicas");
		int dniAtencion = MenuAtracciones.getDni();
		Menu.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniAtencion);
		String nombre = getName();
		System.out.println("        Creado nuevo personal de Relaciones Publicas con DNI " + dniAtencion);
		return  new Relaciones(nombre, dniAtencion);
	}

	private static String getName() {
		String nombre = null;
		try {
			nombre = br.readLine();
		} catch (IOException e) {
			System.err.println("Formato invalido introduzca un nombre valido");
		}
		Menu.clearConsole();
		return nombre;
	}
}
