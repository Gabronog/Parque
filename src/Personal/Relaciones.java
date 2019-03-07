package Personal;

import java.io.Serializable;

public class Relaciones extends Empleado implements Serializable {
    /**
     * Clase para trabajadores del departamento de Relaciones publicas
     * Extiende la clase Empleado
     * Pueden lanzar campañas de ofertas
     * Creado por Gabriel Noguerales 1/3/2019
     */

    private final static int SUELDO = (int) (950 * 0.2);
    private final static String nTipo = "RELACIONES";

    Relaciones(String Nombre, int DNI) {
        super(Nombre, SUELDO, DNI);
        GestorPersonal.insertarEmpleado(this);
        GestorPersonal.insertarNumero(nTipo,GestorPersonal.obtenerNumero(nTipo) +1);
    }

    public void Oferta(int numeroDeEntradas, int TipoEntrada, int Descuento) {
        //TODO Hacer una funcion que haga un descuento cuando compras un numero determinado de entradas
    }

    public void Oferta(int Descuento, int TipoEntrada) {
        //TODO Hacer una funcion que haga un descuento a cualquier entrada
    }

}
