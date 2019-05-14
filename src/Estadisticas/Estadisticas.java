package Estadisticas;

import main.CommonDates;
import personal.*;

public final class Estadisticas {
    static int calcularTotalSueldo(){
        int totalSueldo = 0;
        totalSueldo += calcularAyudantes() * Ayudantes.getSUELDO();
        totalSueldo += calcularResponsables() * Responsables.getSUELDO();
        totalSueldo += calcularAtencion() * Atencion.getSUELDO();
        totalSueldo += calcularRelaciones() * Relaciones.getSUELDO();
        return totalSueldo;
    }
    public static int calcularTotalEmpleados(){
        return calcularAyudantes() + calcularResponsables() + calcularAtencion() + calcularRelaciones();
    }
    public static int calcularAyudantes(){
        return GestorPersonal.obtenerNumero("AYUDANTE");
    }
    public static int calcularResponsables(){
        return GestorPersonal.obtenerNumero("RESPONSABLES");
    }

    public static int calcularAtencion(){
        return GestorPersonal.obtenerNumero("ATENCION");
    }

    public static int calcularRelaciones(){
        return GestorPersonal.obtenerNumero("RELACIONES");
    }

}
