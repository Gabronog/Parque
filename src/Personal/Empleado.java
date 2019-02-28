package Personal;

public class Empleado {
    private String Nombre;
    private Departamento Departamento;
    private int Sueldo;
    private int numeroDNI;
    private char letraDNI;

    public Empleado(String Nombre, Departamento departamento, int sueldo, int DNI, char letradni) {
        super();
        this.Departamento = departamento;
        this.Sueldo = sueldo;
        this.Nombre = Nombre;
        this.numeroDNI = DNI;
        this.letraDNI = letradni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Personal.Departamento getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(Personal.Departamento departamento) {
        Departamento = departamento;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int sueldo) {
        Sueldo = sueldo;
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

    public void setLetraDNI(char letraDNI) {
        this.letraDNI = letraDNI;
    }
}
