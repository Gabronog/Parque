package Personal;

public abstract class Empleado {
    public String Nombre;
    public int Sueldo;
    public int numeroDNI;
    public char letraDNI;

    public Empleado(String Nombre, int sueldo, int DNI, char letradni) {
        super();
        this.Sueldo = sueldo;
        this.Nombre = Nombre;
        this.numeroDNI = DNI;
        this.letraDNI = letradni;
    }
}
