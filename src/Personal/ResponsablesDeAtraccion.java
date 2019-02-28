package Personal;

public class ResponsablesDeAtraccion extends Empleado {
    private int TipoAtraccion; //Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
    private int numeroDeAtraccion; //Numero de la atraccion que trabaja

    public ResponsablesDeAtraccion(String Nombre, int sueldo, int DNI, char letradni) {
        super(Nombre, sueldo, DNI, letradni);
    }

    public int getTipoAtraccion() {
        return TipoAtraccion;
    }

    public void setTipoAtraccion(int tipoAtraccion) {
        TipoAtraccion = tipoAtraccion;
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public void setNumeroDeAtraccion(int numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }
}
