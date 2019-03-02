package Persona;

import static Persona.TipoPersona.*;

public class Persona {
    private int Edad;
    private String Nombre;
    private int Altura;
    private int CarnetDeDescuento;
    TipoPersona Tipopersona;
    private boolean Discapacitado;


    public Persona(String Nombre, int Edad, int Altura) {
        this.Nombre = Nombre;
        this.Altura = Altura;
        this.Edad = Edad;
        if (12 >= this.Edad) {
            this.Tipopersona = Ninio;
        } else if (65 >= this.Edad) {
            this.Tipopersona = Adulto;
        } else {
            this.Tipopersona = Senior;
        }
    }

    public void conCarnet(int numero) {
        this.CarnetDeDescuento = numero;
    }

    public void Discapacitado() {
        this.Discapacitado ^= true;
    }
}
