package Personal;

public class Responsables extends Ayudantes {
    public Responsables(String Nombre, int DNI, char letradni) {
        super(Nombre, DNI, letradni);
        this.Sueldo = (int) (950 * 1.15);
    }
}

