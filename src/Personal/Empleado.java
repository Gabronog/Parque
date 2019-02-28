package Personal;

public abstract class Empleado {
    private String Nombre;
    private int Sueldo;
    private int numeroDNI;
    private char letraDNI;

    Empleado(String Nombre, int sueldo, int DNI, char letradni) {
        super();
        this.Sueldo = sueldo;
        this.Nombre = Nombre;
        this.numeroDNI = DNI;
        this.letraDNI = letradni;
    }
}
