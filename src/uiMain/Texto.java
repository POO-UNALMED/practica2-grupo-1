package uiMain;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import java.util.*;

public class Texto {

    //ESTA CLASE TIENE LA UTILIDAD DE IMPRIMIR TEXTOS UNICAMENTE.
    //Por no saturar el resto de código de impresiones
 
    public static void alertaNoSePuedePagarViaje(Destino d) {
        System.out.println("El presupuesto del viajero no alcanza para viajar a " + d.getNombre() + ".");
        System.out.println(" ");
    }

    public String imprimirTiquete(Tiquete t) {
        String datos = "";
        if (t.getDiasEstadia() != 0) {
            datos = datos + (" ") + "\n";
            datos = datos + ("//---COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---//") + "\n";
            datos = datos + (" ") + "\n";
            datos = datos + ("// Documento: " + t.getViajero().getCedula()) + "\n";
            datos = datos + ("// A nombre de: " + t.getViajero().getNombre()) + "\n";
            datos = datos + ("// Con destino a : " + t.getDestino().getNombre()) + "\n";
            datos = datos + ("// Estadia: " + t.getDiasEstadia() + " dia(s)") + "\n";
            datos = datos + ("// Transporte de tipo: " + t.getTransporte().getTipo()) + "\n";
            datos = datos + ("// Tiempo de Viaje: " + t.getTiempoViaje() + " horas") + "\n";
            datos = datos + ("// Hotel: " + t.getHotel().getNombre() + " de categoría: " + t.getHotel().getEstrellas() + " Estrellas.") + "\n";
            datos = datos + ("// Agente encargado: ID " + t.getAgente().getCedula() + " Nombre: " + t.getAgente().getNombre()) + "\n";
            datos = datos + (" ") + "\n";
            datos = datos + ("// PRECIO TOTAL: " + t.getPrecio() + " pesos.") + "\n";
            datos = datos + ("//--------------------------------------//") + "\n";
            datos = datos + (" ") + "\n";
        } else {
            datos = datos + (" ") + "\n";
            datos = datos + ("//---COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---//") + "\n";
            datos = datos + (" ") + "\n";
            datos = datos + ("// Documento: " + t.getViajero().getCedula()) + "\n";
            datos = datos + ("// A nombre de: " + t.getViajero().getNombre()) + "\n";
            datos = datos + ("// Con destino a : " + t.getDestino().getNombre()) + "\n";
            datos = datos + ("// Transporte de tipo: " + t.getTransporte().getTipo()) + "\n";
            datos = datos + ("// Tiempo de Viaje: " + t.getTiempoViaje() + " horas") + "\n";
            datos = datos + ("// Agente encargado: ID " + t.getAgente().getCedula() + " Nombre: " + t.getAgente().getNombre()) + "\n";
            datos = datos + (" ") + "\n";
            datos = datos + ("// PRECIO TOTAL: " + t.getPrecio() + " pesos.") + "\n";
            datos = datos + ("//--------------------------------------//") + "\n";
            datos = datos + (" ") + "\n";
        }
        return datos;

    }

    public String imprimirHotel(Hotel h) {
        String dato = "";
        dato = dato + ("//------------------------------") + "\n";
        dato = dato + ("Nombre de Hotel: " + h.getNombre()) + "\n";
        dato = dato + ("Costo por noche: " + h.getCosto() + " pesos") + "\n";
        dato = dato + ("Nivel del hotel: " + h.getEstrellas() + " Estrellas.") + "\n";
        dato = dato + (" ") + "\n";
        return dato;
    }

    public String imprimirViajero(Viajero v) {
        String datos;
        String visa;
        if (v.isVisado()) {
            visa = " Tiene pasaporte vigente.";
        } else {
            visa = " No tiene pasaporte.";
        }
        datos = ("//----------------------------------------//") + "\n";
        datos = datos + ("    ID: " + v.getCedula()) + "\n";
        datos = datos + ("    Nombre: " + v.getNombre() + "\n");
        datos = datos + ("    Visado: " + visa) + "\n";
        datos = datos + ("    Millas Acumuladas: " + v.getMillas()) + "\n";
        datos = datos + ("    Presupuesto: " + v.getPresupuesto()) + "\n";
        datos = datos + ("    Agente encargado: ID :" + v.getAgente().getCedula() + " Nombre: "
                + v.getAgente().getNombre()) + "\n";
        datos = datos + ("\n");

        return datos;
    }

    public String imprimirAgente(Agente a) {
        String datos;
        String visa;
        if (a.isVisado()) {
            visa = " Tiene pasaporte vigente.";
        } else {
            visa = " No tiene pasaporte.";
        }
        datos = ("//----------------------------------------//") + "\n";
        datos = datos + ("    ID: " + a.getCedula()) + "\n";
        datos = datos + ("    Nombre: " + a.getNombre() + "\n");
        datos = datos + ("    Visado: " + visa) + "\n";
        datos = datos + ("    Ha comisionado: " + a.getComision() + " pesos.") + "\n";
        datos = datos + ("\n");

        return datos;
    }

    public String imprimirDestino(Destino d) {
        String datos = "";
        String pasaporte;
        String mar;
        String tierra;
        if (d.isPideVisa()) {
            pasaporte = " Es necesario pasaporte.";
        } else {
            pasaporte = " No es necesario.";
        }
        if (d.isAccesoMar()) {
            mar = " Accesible.";
        } else {
            mar = " No es posible.";
        }
        if (d.isAccesoTierra()) {
            tierra = " Accesible.";
        } else {
            tierra = " No es posible.";
        }
        datos = datos + ("//------------------------------------------") + "\n";
        datos = datos + (" Nombre del Destino turístico : " + d.getNombre()) + "\n";
        datos = datos + (" A una distancia de: " + d.getDistancia() + " km de Medellin.") + "\n";
        datos = datos + (" Pide visa para viajer@s: " + pasaporte) + "\n";
        datos = datos + (" Acceso por mar : " + mar) + "\n";
        datos = datos + (" Acceso por tierra : " + tierra) + "\n";
        datos = datos + (" Cuenta con " + d.getHoteles().size() + " hoteles.") + "\n";
        datos = datos + (" ") + "\n";
        return datos;
    }

    public String ayuda() {
        String datos = "";
        datos = datos + ("               PROGRAMACION ORIENTADA A OBJETOS 2020") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + ("Programa disenado para administrar todos los procesos dentro de la agencia de viajes SAM-TRAVEL.") + "\n";
        datos = datos + ("Todos los derechos reservados.") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + (" INTEGRANTES :") + "\n";
        datos = datos + ("   - Carlos Mario Chávez Aguilera ") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + (" ") + "\n";
        return datos;
    }

    public String presentacion() {
        String datos = "";
        datos = datos + (" ") + "\n";
        datos = datos + (" ");
        datos = datos + ("//---------------------------------------------------//") + "\n";
        datos = datos + ("//---------------------------------------------------//") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + ("  //          BIENVENID@S A SAM-TRAVEL        //") + "\n";
        datos = datos + (" ") + "\n";
        datos = datos + ("//---------------------------------------------------//") + "\n";
        datos = datos + ("//---------------------------------------------------//") + "\n";
        datos = datos + (" ") + "\n";
        return datos;
    }

}
