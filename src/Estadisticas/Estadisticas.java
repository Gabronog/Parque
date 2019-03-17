package Estadisticas;

import Personal.*;

abstract class Estadisticas {
    static int calcularTotalSueldo(){
        int TotalSueldo = 0;
        TotalSueldo += GestorPersonal.obtenerNumero("AYUDANTE") * Ayudantes.GetSueldo();
        TotalSueldo += GestorPersonal.obtenerNumero("RESPONSABLES") * Responsables.GetSueldo();
        TotalSueldo += GestorPersonal.obtenerNumero("ATENCION") * Atencion.GetSueldo();
        TotalSueldo += GestorPersonal.obtenerNumero("RELACIONES") * Relaciones.GetSueldo();
        return TotalSueldo;
    }
}
