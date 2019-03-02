package Entradas;

import Persona.GestorUsuarios;
import Persona.Persona;

import java.util.Date;

public class Entrada {
    private Date date;
    private static final int PRECIOGENERAL = 60;
    private static final int PRECIOVIP = 50;
    private static final double MAXDESCUENTO = 0.90;
    private static final double DESCUENTODISCAPACITADO = 0.20;
    private static final double DESCUENTOCARNET = 0.10;


    public Entrada(int DNI) {
        Persona persona = GestorUsuarios.ObtenerDatos(DNI);

    }
}
