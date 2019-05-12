package main;

import Atracciones.*;
import personal.Ayudantes;
import personal.GestorPersonal;
import personal.Responsables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

final class MenuAtracciones {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static void goAtracciones() {
		Menu.imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Ver numero de atracciones en el parque         |");
		System.out.println("        |         2) Crear una nueva atraccion                      |");
		System.out.println("        |         3) Desactivar una atraccion                       |");
		System.out.println("        |         4) Activar una atraccion                          |");
		System.out.println("        |         5) Eliminar una atraccion                         |");
		System.out.println("        |         6) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int i = Integer.parseInt(br.readLine());
			switch (i) {
				case 1:
					Menu.clearConsole();
					System.out.println("        " + GestorAtracciones.getSize());
					Menu.anyKeyContinue();
					break;
				case 2:
					crearAtraccion();
					break;
				case 3:
					int numeroAtraccion = preguntarNumeroAtraccion();
					GestorAtracciones.obtenerDatos(numeroAtraccion).desactivar();
					System.out.println("        Se ha desactivado la atraccion " + numeroAtraccion);
					Menu.anyKeyContinue();
					break;
				case 4:
					int numeroAtraccionActivar = preguntarNumeroAtraccion();
					boolean b = GestorAtracciones.obtenerDatos(numeroAtraccionActivar).activar();
					if(b) System.out.println("      Se activo la atraccion " + numeroAtraccionActivar);
					Menu.anyKeyContinue();
					break;
				case 5:
					int numeroAtraccionBorrar = preguntarNumeroAtraccion();
					GestorAtracciones.eliminarAtraccion(numeroAtraccionBorrar);
					System.out.println("Se elimino la atraccion con numero " + numeroAtraccionBorrar);
					Menu.anyKeyContinue();
					break;
			}
			if (i != 6) goAtracciones();
		} catch (NumberFormatException | IOException | NullPointerException npe) {
			Menu.clearConsole();
			System.err.println("        Formato invalido!");
			goAtracciones();
		}
	}

	public static int preguntarNumeroAtraccion() {
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
				System.err.println("    Formato invalido introduzca un numero de Atraccion valido");
			}
		}
		return numeroAtraccion;
	}

	private static void crearAtraccion() {
		Menu.imprimirCabecera();
		System.out.println("        |                                                           |");
		System.out.println("        |         1) Tipo A                                         |");
		System.out.println("        |         2) Tipo B                                         |");
		System.out.println("        |         3) Tipo C                                         |");
		System.out.println("        |         4) Tipo D                                         |");
		System.out.println("        |         5) Tipo E                                         |");
		System.out.println("        |         6) Salir del programa                             |");
		System.out.println("        -------------------------------------------------------------");
		try {
			String input = "";
			int i = Integer.parseInt(br.readLine());
			Menu.clearConsole();
			if(i<0 || i>5){
				return;
			}
				while (!input.equals("S") && !input.equals("N")) {
					if (!input.equals(""))
						System.err.println("       Formato invalido introduzca S para crear un responsable o N para usar un responsable");
					System.out.println(input);
					System.out.println("        Contratar responsable S/N");
					System.out.print("        >>");
					input = br.readLine().toUpperCase();
				}
				Menu.clearConsole();
				int dni;
				if (input.equals("S")) {
					dni = crearResponsable().getDni();
				}
				else{
					dni=-1;
					while(GestorPersonal.obtener(dni) == null){
						if(dni != -1) System.out.println("       Formato invalido");
						Menu.clearConsole();
						System.out.println("        Por favor inserte el numero del DNI");
						dni = Integer.parseInt(br.readLine());
					}
					try{
						((Responsables) GestorPersonal.obtener(dni)).getTipoAtraccion();
					}
					catch (ClassCastException cce){
						System.out.println("        El empleado seleccionado no es un Responsable de atraccion");
						Menu.anyKeyContinue();
						return;
					}
				}
				input = "";
				while (!input.equals("S") && !input.equals("N")) {
					if (!input.equals("")) System.err.println("       Formato invalido introduzca S para contratar nuevos ayudantes o N para usar ya contratados");
					System.out.println(input);
					System.out.println("        Contratar nuevos ayudantes S/N");
					System.out.print("        >>");
					input = br.readLine().toUpperCase();
				}
				boolean crearAyudantes;
			crearAyudantes = input.equals("S");
			String base = "        Creada la atraccion con numero ";
			switch (i) {
				case 1:
					ArrayList<Ayudantes> ayudantes;
					if(crearAyudantes) ayudantes = ayudantes(A.NUMERO_AYUDANTE);
					else ayudantes = pedirAyudantes(A.NUMERO_AYUDANTE);
					int n1 = new A((Responsables)GestorPersonal.obtener(dni),ayudantes).numeroAtraccion;
					Menu.clearConsole();
					System.out.println(base + n1);
					break;
				case 2:
					ArrayList<Ayudantes> ayudantes2;
					if(crearAyudantes) ayudantes2 = ayudantes(B.NUMERO_AYUDANTE);
					else ayudantes2 = pedirAyudantes(B.NUMERO_AYUDANTE);
					int n2 = new B((Responsables)GestorPersonal.obtener(dni),ayudantes2).numeroAtraccion;
					Menu.clearConsole();
					System.out.println(base + n2);
					break;
				case 3:
					ArrayList<Ayudantes> ayudantes3;
					if(crearAyudantes) ayudantes3 = ayudantes(C.NUMERO_AYUDANTE);
					else ayudantes3 = pedirAyudantes(C.NUMERO_AYUDANTE);
					int n3 = new C((Responsables)GestorPersonal.obtener(dni),ayudantes3).numeroAtraccion;
					Menu.clearConsole();
					System.out.println(base + n3);
					break;
				case 4:
					ArrayList<Ayudantes> ayudantes4;
					if(crearAyudantes) ayudantes4 = ayudantes(D.NUMERO_AYUDANTE);
					else ayudantes4 = pedirAyudantes(D.NUMERO_AYUDANTE);
					int n4 = new D((Responsables)GestorPersonal.obtener(dni),ayudantes4).numeroAtraccion;
					Menu.clearConsole();
					System.out.println(base + n4);
					break;
				case 5:
					ArrayList<Ayudantes> ayudantes5;
					if(crearAyudantes) ayudantes5 = ayudantes(E.NUMERO_AYUDANTE);
					else ayudantes5 = pedirAyudantes(E.NUMERO_AYUDANTE);
					int n = new E((Responsables)GestorPersonal.obtener(dni),ayudantes5).numeroAtraccion;
					Menu.clearConsole();
					System.out.println(base + n);
					break;
			}
			Menu.anyKeyContinue();
			goAtracciones();
		}catch (NumberFormatException | IOException nfe) {
			Menu.clearConsole();
			System.err.println("        Formato invalido!");
			crearAtraccion();
		}
	}

	private static ArrayList<Ayudantes> pedirAyudantes(int numeroAyudante) {
		int i = 1;
		int dni;
		ArrayList<Ayudantes> ayudantes = new ArrayList<>();
		while (i <= numeroAyudante) {
			dni=-1;
			while(GestorPersonal.obtener(dni) == null){
				Menu.clearConsole();
				if(dni != -1) System.out.println("       Formato invalido");
				System.out.println("        Por favor inserte el numero del DNI del trabajador " + i);
				dni = getDni();
			}
			try{
				ayudantes.add((Ayudantes) GestorPersonal.obtener(dni));
			}catch (ClassCastException e){
				System.out.println("El empleado no es un Ayudante");
				continue;
			}
			i++;
		}
		return ayudantes;
	}

	private static ArrayList<Ayudantes> ayudantes(int numeroAyudante) {
		ArrayList<Ayudantes> ayudantes = new ArrayList<>();
		int i = 1;
		while (i <= numeroAyudante) {
			try {
				System.out.println("        Introduzca el numero de DNI del " + i + "er ayudante");
				int dni = crearAyudante().getDni();
				i++;
				Menu.clearConsole();
				System.out.println("        Creado nuevo responsable con DNI " + dni);
			} catch (Exception e) {
				System.err.println("Formato invalido introduzca un numero de DNI valido");
			}
		}
		return ayudantes;
	}

	public static Ayudantes crearAyudante() throws IOException {
		int dni = getDni();
		Menu.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dni);
		String nombre;
		nombre = br.readLine();
		return new Ayudantes(nombre, dni);
	}

	static int getDni() {
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

	static Responsables crearResponsable() {
		System.out.println("        Introduzca el numero de DNI del responsable de la atraccion");
		int dniResponsable = getDni();
		Menu.clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniResponsable);
		String nombre = null;
		try {
			nombre = br.readLine();
		} catch (IOException e) {
			System.err.println("Formato invalido introduzca un numero de DNI valido");
		}
		Menu.clearConsole();
		System.out.println("        Creado nuevo responsable con DNI " + dniResponsable);
		return  new Responsables(nombre, dniResponsable);
	}
}
