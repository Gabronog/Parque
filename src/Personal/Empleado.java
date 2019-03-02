package Personal;

public abstract class Empleado {
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public int getNumeroDNI() {
        return numeroDNI;
    }

    public void setNumeroDNI(int numeroDNI) {
        this.numeroDNI = numeroDNI;
    }

    public char getLetraDNI() {
        return letraDNI;
    }

    public void setLetraDNI(Character letraDNI) {
        this.letraDNI = letraDNI;
    }

    private String Nombre;
    int Sueldo;
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
