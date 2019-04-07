package main;

import Atracciones.*;
import personal.*;

import java.util.logging.Logger;

/**
 * Carga los datos del enunciado
 */
interface DatosEnunciado {
    Logger LOGGER = Logger.getLogger(DatosEnunciado.class.getName());

    static void cargarDatosEnunciado(){
        Launch.borrarDatos();
        for(int i=0;i<130;i++){
            GestorPersonal.insertarEmpleado(new Ayudantes("A"+i,i));
        }
        for(int i=130;i<156;i++){
            GestorPersonal.insertarEmpleado(new Responsables("R"+i,i));
        }
        int ultimoAyudante = 0;
        int ultimoResponsable = 130;
        for(int i = 0; i<4; i++){
            Responsables r1 = crearResponsable(ultimoResponsable);
            ultimoResponsable++;
            Ayudantes[] ayudantes = crearTrabajadores(ultimoAyudante, 6);
            ultimoAyudante+=6;
            new A(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4],ayudantes[5]);
        }
        for(int i=0;i<6;i++){
            Responsables r1 = crearResponsable(ultimoResponsable);
            ultimoResponsable++;
            Ayudantes[] ayudantes = crearTrabajadores(ultimoAyudante, 5);
            ultimoAyudante+=5;
            new B(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        for(int i=0;i<4;i++){
            Responsables r1 = crearResponsable(ultimoResponsable);
            ultimoResponsable++;
            Ayudantes[] ayudantes = crearTrabajadores(ultimoAyudante, 3);
            ultimoAyudante+=3;
            new C(r1,ayudantes[0],ayudantes[1],ayudantes[2]);
        }
        for(int i=0;i<3;i++){
            Responsables r1 = crearResponsable(ultimoResponsable);
            ultimoResponsable++;
            Ayudantes[] ayudantes = crearTrabajadores(ultimoAyudante, 5);
            ultimoAyudante+=5;
            new D(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        for(int i=0;i<7;i++){
            Responsables r1 = crearResponsable(ultimoResponsable);
            ultimoResponsable++;
            Ayudantes[] ayudantes = crearTrabajadores(ultimoAyudante, 7);
            ultimoAyudante+=7;
            new E(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4],ayudantes[5],ayudantes[6]);
        }
        int nTrabajadores = GestorPersonal.obtenerNumero("AYUDANTE") + GestorPersonal.obtenerNumero("RESPONSABLES");
        int nRelacionesPublicas = (nTrabajadores/10)+1;
        int nAtencion = (nTrabajadores*30/100)+1;
        nTrabajadores++;
        for(int i=1;i<=nRelacionesPublicas;i++){
            new Relaciones("Rel"+i,nTrabajadores);
            nTrabajadores++;
        }
        for(int i=1;i<=nAtencion;i++){
            new Atencion("Aten"+i,nTrabajadores);
            nTrabajadores++;
        }
        LOGGER.info("Cargada la configuracion inicial");

    }
    static Responsables crearResponsable(int ultimoResponsable){
        return (Responsables) GestorPersonal.obtener(ultimoResponsable);
    }
    static Ayudantes[] crearTrabajadores(int ultimoAyudante,int capacidad) {
        Ayudantes[] ayudantes = new Ayudantes[capacidad];
        for (int k = 1; k < capacidad+1; k++) {
            ayudantes[k - 1] = (Ayudantes) GestorPersonal.obtener(ultimoAyudante);
            ultimoAyudante++;
        }
        return ayudantes;
    }
}