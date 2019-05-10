package main;

import Atracciones.*;
import personal.Ayudantes;
import personal.GestorPersonal;
import personal.Responsables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static main.Menu.*;

final class MenuAtracciones {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void goAtracciones() {
		imprimirCabecera();
		System.out.println("        |                                                          |");
		System.out.println("        |         1) Ver numero de atracciones en el parque        |");
		System.out.println("        |         2) Crear una nueva atraccion                     |");
		System.out.println("        |         3) Desactivar una atraccion                      |");
		System.out.println("        |         4) Activar una atraccion                         |");
		System.out.println("        |         5) Eliminar una atraccion                        |");
		System.out.println("        |         6) Salir del programa                            |");
		System.out.println("        ------------------------------------------------------------");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int i = Integer.parseInt(br.readLine());
			switch (i) {
				case 1:
					clearConsole();
					System.out.println("        " + GestorAtracciones.getSize());
					anyKeyContinue();
					break;
				case 2:
					crearAtraccion();
					break;
				case 3:
					int numeroAtraccion = preguntarNumeroAtraccion();
					GestorAtracciones.obtenerDatos(numeroAtraccion).desactivar();
					System.out.println("        Se ha desactivado la atraccion " + numeroAtraccion);
					anyKeyContinue();
					break;
				case 4:
					int numeroAtraccionActivar = preguntarNumeroAtraccion();
					boolean b = GestorAtracciones.obtenerDatos(numeroAtraccionActivar).activar();
					if(b) System.out.println("      Se activo la atraccion " + numeroAtraccionActivar);
					anyKeyContinue();
					break;
				case 5:
					int numeroAtraccionBorrar = preguntarNumeroAtraccion();
					GestorAtracciones.eliminarAtraccion(numeroAtraccionBorrar);
					System.out.println("Se elimino la atraccion con numero " + numeroAtraccionBorrar);
					anyKeyContinue();
					break;
			}
			if (i != 6) goAtracciones();
		} catch (NumberFormatException | IOException | NullPointerException npe) {
			clearConsole();
			System.err.println("        Formato invalido!");
			goAtracciones();
		}
	}

	private static int preguntarNumeroAtraccion() {
		int numeroAtraccion = -1;
		boolean validInput = false;
		while (!validInput) {
			System.out.println("        Por favor introduzca el numero de atraccion");
			try {
				numeroAtraccion = Integer.parseInt(br.readLine());
				if (numeroAtraccion >= 0 && GestorAtracciones.obtenerDatos(numeroAtraccion) != null) {
					validInput = true;
				} else System.err.println("      Formato invalido introduzca un numero de Atraccion valido");
			} catch (NumberFormatException | IOException nfe) {
				System.err.println("Formato invalido introduzca un numero de Atraccion valido");
			}
		}
		return numeroAtraccion;
	}

	private static void anyKeyContinue() {
		System.out.println("        Pulsa cualquier tecla para continuar...");
		try {
			System.in.read();
		} catch (Exception e) {
		} finally {
			clearConsole();
		}
	}

	static void crearAtraccion() {
		imprimirCabecera();
		System.out.println("        |                                                          |");
		System.out.println("        |         1) Tipo A                                        |");
		System.out.println("        |         2) Tipo B                                        |");
		System.out.println("        |         3) Tipo C                                        |");
		System.out.println("        |         4) Tipo D                                        |");
		System.out.println("        |         5) Tipo E                                        |");
		System.out.println("        |         6) Salir del programa                            |");
		System.out.println("        ------------------------------------------------------------");
		try {
			String input = "";
			int i = Integer.parseInt(br.readLine());
			clearConsole();
			if(i<0 || i>5){
				return;
			}
				while (!input.equals("S") && !input.equals("N")) {
					if (!input.equals(""))
						System.err.println("       Formato invalido introduzca S para crear un responsable o N para usar un responsable");
					System.out.println(input);
					System.out.println("        Crear responsable S/N");
					System.out.print("        >>");
					input = br.readLine().toUpperCase();
				}
				clearConsole();
				int dni;
				if (input.equals("S")) {
					dni = crearResponsable();
				}
				else{
					dni=-1;
					while(GestorPersonal.obtener(dni) != null){
						if(dni != -1) System.out.println("       Formato invalido");
						clearConsole();
						System.out.println("        Por favor inserte el numero del DNI");
						dni = Integer.parseInt(br.readLine());
					}
				}

			switch (i) {
				case 1:
					ArrayList<Ayudantes> ayudantes = ayudantes(A.NUMERO_AYUDANTE);
					int n1 = new A((Responsables)GestorPersonal.obtener(dni),ayudantes).numeroAtraccion;
					clearConsole();
					System.out.println("        Creada la atraccion con numero " + n1);
					break;
				case 2:
					ArrayList<Ayudantes> ayudantes2 = ayudantes(B.NUMERO_AYUDANTE);
					int n2 = new B((Responsables)GestorPersonal.obtener(dni),ayudantes2).numeroAtraccion;
					clearConsole();
					System.out.println("        Creada la atraccion con numero " + n2);
					break;
				case 3:
					ArrayList<Ayudantes> ayudantes3 = ayudantes(C.NUMERO_AYUDANTE);
					int n3 = new C((Responsables)GestorPersonal.obtener(dni),ayudantes3).numeroAtraccion;
					clearConsole();
					System.out.println("        Creada la atraccion con numero " + n3);
					break;
				case 4:
					ArrayList<Ayudantes> ayudantes4 = ayudantes(D.NUMERO_AYUDANTE);
					int n4 = new D((Responsables)GestorPersonal.obtener(dni),ayudantes4).numeroAtraccion;
					clearConsole();
					System.out.println("        Creada la atraccion con numero " + n4);
					break;
				case 5:
					ArrayList<Ayudantes> ayudantes5 = ayudantes(E.NUMERO_AYUDANTE);
					int n = new E((Responsables)GestorPersonal.obtener(dni),ayudantes5).numeroAtraccion;
					clearConsole();
					System.out.println("        Creada la atraccion con numero " + n);
					break;
			}
			anyKeyContinue();
			goAtracciones();
		} catch (NumberFormatException | IOException nfe) {
			clearConsole();
			System.err.println("        Formato invalido!");
			crearAtraccion();
		}
	}

	private static ArrayList<Ayudantes> ayudantes(int numeroAyudante) {
		ArrayList<Ayudantes> ayudantes = new ArrayList<>();
		int i = 1;
		while (i <= numeroAyudante) {
			try {
				System.out.println("        Introduzca el numero de DNI del " + i + "er ayudante");
				int dni = getDni();
				clearConsole();
				System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dni);
				String nombre;
				nombre = br.readLine();
				ayudantes.add(new Ayudantes(nombre, dni));
				i++;
				clearConsole();
				System.out.println("        Creado nuevo responsable con DNI " + dni);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ayudantes;
	}

	private static int getDni() {
		int dni = -1;
		boolean validInput = false;
		while (!validInput) {
			try {
				dni = Integer.parseInt(br.readLine());
				if (dni >= 0 && dni <= 99999999) {
					validInput = true;
				} else System.err.println("      Formato invalido introduzca un numero de DNI valido");
			} catch (NumberFormatException | IOException nfe) {
				System.err.println("Formato invalido introduzca un numero de DNI valido");
			}
		}
		return dni;
	}

	private static int crearResponsable() {
		System.out.println("        Introduzca el numero de DNI del responsable de la atraccion");
		int dniResponsable = getDni();
		clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniResponsable);
		String nombre = null;
		try {
			nombre = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		new Responsables(nombre, dniResponsable);
		clearConsole();
		System.out.println("        Creado nuevo responsable con DNI " + dniResponsable);
		return dniResponsable;
	}
}
