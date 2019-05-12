package Estadisticas;

import java.time.Month;

public class MesAnio {
	private Month mes;
	private int anio;
	public MesAnio(Month month, int year){
		this.anio = year;
		this.mes = month;
	}

	public Month getMes() {
		return this.mes;
	}
	public int getAnio(){
		return this.anio;
	}
}
