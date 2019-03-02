package Personal;

public class Relaciones extends Empleado {
    /**
     * Clase para trabajadores del departamento de Relaciones publicas
     * Extiende la clase Empleado
     * Pueden lanzar campañas de ofertas
     * Creado por Gabriel Noguerales 1/3/2019
     */

    Relaciones(String Nombre, int sueldo, int DNI, char letradni) {
        super(Nombre, sueldo, DNI, letradni);
    }

    public void Oferta(int numeroDeEntradas, int TipoEntrada, int Descuento) {
        //TODO Hacer una funcion que haga un descuento cuando compras un numero determinado de entradas
    }

    public void Oferta(int Descuento, int TipoEntrada) {
        //TODO Hacer una funcion que haga un descuento a cualquier entrada
    }

}
