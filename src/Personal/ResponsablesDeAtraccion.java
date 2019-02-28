package Personal;

public class ResponsablesDeAtraccion extends Empleado {
    private String TipoAtraccion; //Tipo de atraccion que trabaja
    private int numeroDeAtraccion; //Numero de la atraccion que trabaja

    public ResponsablesDeAtraccion(String Nombre, int sueldo, int DNI, char letradni) {
        super(Nombre, sueldo, DNI, letradni);
    }

    public String getTipoAtraccion() {
        return TipoAtraccion;
    }

    public void setTipoAtraccion(String tipoAtraccion) {
        TipoAtraccion = tipoAtraccion;
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public void setNumeroDeAtraccion(int numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }
}
