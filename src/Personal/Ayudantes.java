package Personal;

import java.io.Serializable;

public class Ayudantes extends Empleado implements Serializable {
    /**
     * @param TipoAtraccion Tipo de atraccion que trabaja 1=A 2=B 3=C 4=D 5=E
     * @param numeroDeAtraccion Numero de la atraccion que trabaja
     */

    private Integer TipoAtraccion;
    private Integer numeroDeAtraccion;
    private static final int SUELDO_AYUDANTE = 950;

    public Integer getTipoAtraccion() {
        return TipoAtraccion;
    }

    public void setTipoAtraccion(Integer tipoAtraccion) {
        TipoAtraccion = tipoAtraccion;
    }

    public int getNumeroDeAtraccion() {
        return numeroDeAtraccion;
    }

    public void setNumeroDeAtraccion(Integer numeroDeAtraccion) {
        this.numeroDeAtraccion = numeroDeAtraccion;
    }

    public Ayudantes(String Nombre) {
        super(Nombre, SUELDO_AYUDANTE);
    }

    public static Responsables Ascender(Ayudantes ayudante) {
        if (null != ayudante) {
            return new Responsables(ayudante.getNombre());
        }
        return null;
    }
}
