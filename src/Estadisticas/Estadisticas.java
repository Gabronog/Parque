package estadisticas;

import personal.*;

interface Estadisticas {
    static int calcularTotalSueldo(){
        int totalSueldo = 0;
        totalSueldo += GestorPersonal.obtenerNumero("AYUDANTE") * Ayudantes.getSUELDO();
        totalSueldo += GestorPersonal.obtenerNumero("RESPONSABLES") * Responsables.getSUELDO();
        totalSueldo += GestorPersonal.obtenerNumero("ATENCION") * Atencion.getSUELDO();
        totalSueldo += GestorPersonal.obtenerNumero("RELACIONES") * Relaciones.getSUELDO();
        return totalSueldo;
    }
}
