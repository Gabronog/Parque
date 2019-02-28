package Atracciones;

import Personal.ResponsablesDeAtraccion;

public class B extends Atraccion{

    public B(int TipoDeAtraccion, ResponsablesDeAtraccion responsable) {
        super(TipoDeAtraccion, responsable);
    }

    public B(int TipoDeAtraccion, String nombre, int sueldo, int DNI, char letra) {
        super(TipoDeAtraccion, nombre, sueldo, DNI, letra);
    }
}
