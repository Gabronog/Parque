package estadisticas;

import personal.*;

interface Estadisticas {
    static int calcularTotalSueldo(){
        int totalSueldo = 0;
        totalSueldo += GestorPersonal.obtenerNumero("AYUDANTE") * Ayudantes.GetSueldo();
        totalSueldo += GestorPersonal.obtenerNumero("RESPONSABLES") * Responsables.GetSueldo();
        totalSueldo += GestorPersonal.obtenerNumero("ATENCION") * Atencion.GetSueldo();
        totalSueldo += GestorPersonal.obtenerNumero("RELACIONES") * Relaciones.GetSueldo();
        return totalSueldo;
    }
}
