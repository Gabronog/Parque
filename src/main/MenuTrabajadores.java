package main;

import Atracciones.GestorAtracciones;
import Estadisticas.Estadisticas;
import personal.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static main.Menu.imprimirCabecera;

class MenuTrabajadores {
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
					MenuComun.clearConsole();
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
					MenuComun.anyKeyContinue();
					break;
				case 2:
					MenuComun.clearConsole();
					System.out.println("        El numero de trabajadores de EuroPark es: " + Estadisticas.calcularTotalEmpleados());
					MenuComun.anyKeyContinue();
					break;
				case 3:
					MenuComun.clearConsole();

					int tipoEmpleado2 = obtenerTipoEmpleado();
					switch (tipoEmpleado2){
						case 1:
							MenuComun.crearAyudante();
							break;
						case 2:
							MenuComun.crearResponsable();
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
					MenuComun.anyKeyContinue();
					break;
				case 4:
					System.out.println("        Por favor introduzca el dni del empleado que quiere despedir");
					int dni = MenuComun.getDni();
					GestorPersonal.borrar(dni);
					System.out.println("        Borrado del sistema el empleado con DNI " + dni);
					break;
				case 5:
					MenuComun.clearConsole();
					int numeroAtraccion = MenuAtracciones.preguntarNumeroAtraccion();
					boolean crearAyudante = MenuComun.getyesno("        Desea contratar el ayudante S/N");
					Ayudantes ayudante;
					if(crearAyudante) ayudante = MenuComun.crearAyudante();
					else ayudante = (Ayudantes) GestorPersonal.obtener(MenuComun.getDni());
					GestorAtracciones.obtenerDatos(numeroAtraccion).insertar(ayudante);
					break;
				case 6:
					MenuComun.clearConsole();
					int numeroAtraccion2 = MenuAtracciones.preguntarNumeroAtraccion();
					int dniDesasignar = MenuComun.getDni();
					GestorAtracciones.obtenerDatos(numeroAtraccion2).getDNI(dniDesasignar).dejarAtraccion();
			}
			MenuComun.clearConsole();
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
			MenuComun.clearConsole();
			System.err.println("        Se produjo un error!");
		}
		return 0;
	}
	private static Atencion crearAtencion() {
		System.out.println("        Introduzca el numero de DNI del trabajador de Atencion al cliente");
		int dniAtencion = MenuComun.getDni();
		MenuComun.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniAtencion);
		String nombre = MenuComun.getName();
		System.out.println("        Creado nuevo personal de Atencion al cliente con DNI " + dniAtencion);
		return  new Atencion(nombre, dniAtencion);
	}
	private static Relaciones crearRelaciones() {
		System.out.println("        Introduzca el numero de DNI del trabajador de Relaciones publicas");
		int dniAtencion = MenuComun.getDni();
		MenuComun.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniAtencion);
		String nombre = MenuComun.getName();
		System.out.println("        Creado nuevo personal de Relaciones Publicas con DNI " + dniAtencion);
		return  new Relaciones(nombre, dniAtencion);
	}

}
