package Persona;

import Entradas.Entrada;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

import static Persona.TipoPersona.*;

public class Persona implements Serializable {
    private int edad;
    private String nombre;
    private int altura;
    private int carnetDeDescuento = -1;
    private TipoPersona tipoPersona;
    private boolean discapacitado = false;
    private int dni;
    private LinkedList<Entrada> listaEntradas;

    protected Persona(String Nombre, int Edad, int Altura, int dni) { //Create persons by using the GestorUsuarios Method
        this.nombre = Nombre;
        this.listaEntradas = new LinkedList<>();
        this.altura = Altura;
        this.edad = Edad;
        this.dni = dni;
        if (12 >= this.edad) {
            this.tipoPersona = Ninio;
        } else if (65 >= this.edad) {
            this.tipoPersona = Adulto;
        } else {
            this.tipoPersona = Senior;
        }
    }

    public void comprarEntrada(boolean Vip, LocalDate date){
        listaEntradas.add(new Entrada(this.dni,date,Vip));
    }

    public void conCarnet(int numero) {
        this.carnetDeDescuento = numero;
    }

    public void Discapacitado() {
        this.discapacitado ^= true;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public int getCarnetDeDescuento() {
        return carnetDeDescuento;
    }

    public boolean isDiscapacitado() {
        return discapacitado;
    }
}
