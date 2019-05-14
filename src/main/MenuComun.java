package main;

import personal.Ayudantes;
import personal.Responsables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

final class MenuComun {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

	static int getInt(String s) {
		int number = -1;
		while (number < 0) {
			try {
				if (number != -1) System.out.println(CommonDates.error);
				System.out.println(s);
				number = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				number = -2;
			}
			MenuComun.clearConsole();
		}
		return number;
	}

	static Responsables crearResponsable() {
		System.out.println("        Introduzca el numero de DNI del responsable de la atraccion");
		int dniResponsable = getDni();
		clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dniResponsable);
		String nombre = null;
		try {
			nombre = br.readLine();
		} catch (IOException e) {
			System.err.println("Formato invalido introduzca un numero de DNI valido");
		}
		clearConsole();
		System.out.println("        Creado nuevo responsable con DNI " + dniResponsable);
		return new Responsables(nombre, dniResponsable);
	}

	public static Ayudantes crearAyudante() throws IOException {
		int dni = getDni();
		clearConsole();
		System.out.println("        Por favor introduzca el nombre del trabajador con DNI " + dni);
		String nombre;
		nombre = br.readLine();
		return new Ayudantes(nombre, dni);
	}

	public static boolean getyesno(String base) throws IOException {
		String input;
		input = "";
		while (!input.equals("S") && !input.equals("N")) {
			if (!input.equals(""))
				System.err.println("       Formato invalido introduzca S para confirmar o N para rechazar");
			System.out.println(base);
			System.out.print("        >>");
			input = br.readLine().toUpperCase();
		}
		return input.equals("S");
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

	static String getName() {
		String nombre = null;
		try {
			nombre = br.readLine();
		} catch (IOException ignored) {
		}
		clearConsole();
		return nombre;
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


}
