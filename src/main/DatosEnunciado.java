package main;

import Atracciones.*;
import Personal.*;

abstract class DatosEnunciado {
    static void cargarDatosEnunciado(){
        Launch.BorrarDatos();
        int UltimoAyudante = 0,UltimoResponsable = 0;
        for(int i=1;i<131;i++){
            GestorPersonal.insertarEmpleado(new Ayudantes("A"+i,i));
        }
        for(int i=131;i<157;i++){
            GestorPersonal.insertarEmpleado(new Responsables("R"+i,i));
        }
        for(int i=0;i<4;i++){
            Ayudantes[] ayudantes = new Ayudantes[6];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(131+i);
            UltimoResponsable = 131+i;
            for(int k=1;k<7;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(k+(i*6));
                UltimoAyudante = k+(i*6);
            }
            new A(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4],ayudantes[5]);
        }
        UltimoResponsable++;
        UltimoAyudante++;
        for(int i=0;i<5;i++){
            Ayudantes[] ayudantes = new Ayudantes[5];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<6;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new B(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        UltimoResponsable++;
        UltimoAyudante++;
        for(int i=0;i<4;i++){
            Ayudantes[] ayudantes = new Ayudantes[3];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<4;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new C(r1,ayudantes[0],ayudantes[1],ayudantes[2]);
        }
        for(int i=0;i<3;i++){
            Ayudantes[] ayudantes = new Ayudantes[5];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<6;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
            new D(r1,ayudantes[0],ayudantes[1],ayudantes[2],ayudantes[3],ayudantes[4]);
        }
        for(int i=0;i<7;i++){
            Ayudantes[] ayudantes = new Ayudantes[7];
            Responsables r1 = (Responsables) GestorPersonal.Obtener(UltimoResponsable);
            UltimoResponsable++;
            for(int k=1;k<8;k++){
                ayudantes[k-1] = (Ayudantes) GestorPersonal.Obtener(UltimoAyudante);
                UltimoAyudante++;
            }
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
        System.out.println("Cargada la configuracion inicial");

    }
}
