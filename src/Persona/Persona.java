package Persona;

import java.io.Serializable;

import static Persona.TipoPersona.*;

public class Persona implements Serializable {
    private int Edad;
    private String Nombre;
    private int Altura;
    private int CarnetDeDescuento = -1;
    private TipoPersona Tipopersona;
    private boolean Discapacitado = false;


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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int altura) {
        Altura = altura;
    }

    public TipoPersona getTipopersona() {
        return Tipopersona;
    }

    public void setTipopersona(TipoPersona tipopersona) {
        Tipopersona = tipopersona;
    }

    public int getCarnetDeDescuento() {
        return CarnetDeDescuento;
    }

    public boolean isDiscapacitado() {
        return Discapacitado;
    }
}
