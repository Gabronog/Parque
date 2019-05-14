package Atracciones;

import personal.Ayudantes;
import personal.Responsables;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Atraccion Tipo A
 * Extiende Atraccion
 * Creado por Gabriel Noguerales
 */
public class A extends Atraccion implements Serializable {

	private static final int TIPO_DE_ATRACCION = 1;
	private static final boolean VIP = true;
	public static final int NUMERO_AYUDANTE = 6;

	/**
	 * Constructor de atracciones A usando un responsable ya contratado
	 *
	 * @param responsable Responsables
	 * @param A1-A6       Ayudantes
	 */
	public A(Responsables responsable, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
		super(TIPO_DE_ATRACCION, responsable);
		//Comprobamos que todos los ayudantes tienen datos
		if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
			insertar(A1, A2, A3);
			insertar(A4, A5, A6);            //Asignamos la atraccion a cada Ayudante
			asignarAtraccion(TIPO_DE_ATRACCION);
			//Activamos la atraccion
			this.activada = true;
		}
		//Guardamos la atraccion en nuestra lista
		GestorAtracciones.add(this);

	}


	public A(Responsables responsable, ArrayList<Ayudantes> ayudantes) {
		super(TIPO_DE_ATRACCION, responsable);
		//Comprobamos que todos los ayudantes tienen datos
		if (ayudantes.size() == 6) {
			Ayudantes A1 = ayudantes.get(0);
			Ayudantes A2 = ayudantes.get(1);
			Ayudantes A3 = ayudantes.get(2);
			Ayudantes A4 = ayudantes.get(3);
			Ayudantes A5 = ayudantes.get(4);
			Ayudantes A6 = ayudantes.get(5);

			if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
				insertar(A1, A2, A3);
				insertar(A4, A5, A6);            //Asignamos la atraccion a cada Ayudante
				asignarAtraccion(TIPO_DE_ATRACCION);
				//Activamos la atraccion
				this.activada = true;
				//Guardamos la atraccion en nuestra lista
				LOGGER.info("Creada la atraccion tipo A correctamente");
			}
		} else {
			LOGGER.severe("ARRAY LENGTH ERROR");
			System.out.println("Se produjo un error al asignar los ayudantes a la atraccion");
		}
		GestorAtracciones.add(this);
	}


	/**
	 * Constructor de atracciones A contratando un nuevo responsable
	 *
	 * @param nombreResp Nombre del responsable
	 * @param dniResp    DNI del responsable
	 * @param A1-A6      Ayudantes
	 */
	public A(String nombreResp, int dniResp, Ayudantes A1, Ayudantes A2, Ayudantes A3, Ayudantes A4, Ayudantes A5, Ayudantes A6) {
		super(TIPO_DE_ATRACCION, nombreResp, dniResp);
		if (A1 != null && A2 != null && A3 != null && A4 != null && A5 != null && A6 != null) {
			insertar(A1, A2, A3);
			insertar(A4, A5, A6);
			asignarAtraccion(TIPO_DE_ATRACCION);
			this.activada = true;
		}
		//Guardamos la atraccion en nuestra lista
		GestorAtracciones.add(this);
	}

	/**
	 * Activa la atracción
	 */
	public Boolean activar() {
		if (ayudantes.size() == NUMERO_AYUDANTE && responsable != null) {
			this.activada = true;
		} else {
			LOGGER.warning("No hay suficientes trabajadores asignados a la atracción");
			System.err.println("No hay suficientes trabajadores asignados a la atracción");
		}
		System.out.println();
		return this.activada;
	}

}
