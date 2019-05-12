package Entradas;

import Estadisticas.MesAnio;
import Persona.GestorUsuarios;
import Persona.Persona;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;


/**
 * |entradas|
 */
public class Entrada {
    private static Logger LOGGER = Logger.getLogger(Entrada.class.getName());

    private static final double DESCUENTONINIO = 0.50;
    private LocalDate date;
    private static final int PRECIOGENERAL = 60;
    private static final int PRECIOVIP = 50;
    private static final double MAXDESCUENTO = 0.90;
    private static final double DESCUENTODISCAPACITADO = 0.20;
    private static final double DESCUENTOCARNET = 0.10;
    private static final int DESCUENTOADULTO = 0;
    private static final double DESCUENTOSENIOR = 0.35;
    private static final double INCREMENTOTEMPALTA = -0.15;
    private static final double DESCUENTOTEMPBAJA = 0.15;
    private static final int DESCEUNTOTEMPMEDIA = 0;
    private final double precio;
    Persona persona;


    public Entrada(int DNI, LocalDate date, boolean VIP) {
        this.precio = Entrada.calcularPrecio(DNI, date, VIP);
        MesAnio mesAnio = new MesAnio(date.getMonth(),date.getYear());
        GestorEntradas.aumentarNumeroDeEntradas(mesAnio);
        GestorEntradas.insertarNuevaEntrada(this,date);
    }

    private static double calcularPrecio(int dni, LocalDate date, boolean vip) {
        double precio;
        double descuento;
        precio = descuento = 0;
        Persona persona = GestorUsuarios.obtenerDatos(dni);
        if (persona != null) {
            switch (persona.getTipoPersona()) {
                case Ninio:
                    descuento += DESCUENTONINIO;
                    break;
                case Adulto:
                    descuento += DESCUENTOADULTO;
                    break;
                case Senior:
                    descuento += DESCUENTOSENIOR;
                    break;
                default:
                    LOGGER.severe("ERROR INDEX OUT OF RANGE TIPOPERSONA");
            }
        } else {
            LOGGER.severe("ERROR NOT A VALID PERSON");
            return -1;
        }
        if (persona.getCarnetDeDescuento() != -1) descuento += DESCUENTOCARNET;
        if (persona.isDiscapacitado()) descuento += DESCUENTODISCAPACITADO;
        switch (calcularTemporada(date)) {
            case MEDIA:
                descuento += DESCEUNTOTEMPMEDIA;
                break;
            case BAJA:
                descuento += DESCUENTOTEMPBAJA;
                break;
            case ALTA:
                descuento += INCREMENTOTEMPALTA;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + calcularTemporada(date));
        }
        if (descuento > MAXDESCUENTO) {
            descuento = MAXDESCUENTO;
        }
        if (vip) precio += PRECIOVIP;
        precio += PRECIOGENERAL;
        precio = precio * (1 - descuento);
        return precio;
    }

    private static Temporada calcularTemporada(LocalDate date) {
        if (date.getMonth() == Month.JANUARY && date.getDayOfMonth() < 9) {
            return Temporada.ALTA;
        } else if (date.getMonth() == Month.APRIL ||
                date.getMonth() == Month.DECEMBER ||
                date.getMonth() == Month.AUGUST) {
            return Temporada.ALTA;
        } else if (date.getMonth() == Month.FEBRUARY || date.getMonth() == Month.NOVEMBER) {
            return Temporada.BAJA;
        } else {
            return Temporada.MEDIA;
        }

    }

    public void mostrarEntrada() {
        /**TODO
         * ===========================
         * = Nombre.  Persona.Nombre =
         * = DNI.     Persona.DNI    =
         * =  if(VIP) **VIP**        =
         * = Fecha    date           =
         * = Entradas  TipoPersona    =
         * = Temporada TipoTemporada =
         * = if(Dis)**DISCAPACITADO**=
         * = if(Carnet) **CARNET**   =
         * = Precio    precio        =
         * ===========================
         *
         */
    }
}
