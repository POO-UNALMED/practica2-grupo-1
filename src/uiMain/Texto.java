package uiMain;

import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import java.util.*;

public class Texto {
    
    //ESTA CLASE TIENE LA UTILIDAD DE IMPRIMIR TEXTOS UNICAMENTE.
    //Por no saturar el resto de código de impresiones

    public void presentacion() {

        System.out.println(" ");
        System.out.println(" ");
        System.out.println("                  //---------------------//--------------------//---------------------//");
        System.out.println("                  //---------------------//--------------------//---------------------//");
        System.out.println(" ");
        System.out.println("                  //-------------------- BIENVENID@S A SAM-TRAVEL --------------------//");
        System.out.println(" ");
        System.out.println("                  //---------------------//--------------------//---------------------//");
        System.out.println("                  //---------------------//--------------------//---------------------//");
        System.out.println(" ");
        System.out.println("PROGRAMACION ORIENTADA A OBJETOS 2020");
        System.out.println("Programa disenado para administrar todos los procesos dentro de la agencia de viajes SAM-TRAVEL.");
        System.out.println("Todos los derechos reservados.");
        System.out.println(" INTEGRANTES :");
        System.out.println("   - Carlos Mario Chávez Aguilera ");
        System.out.println("   - Rafael Mauricio Builes ");
        System.out.println(" ");

    }

    public void menuUsuario() {
        System.out.println(" ");
        System.out.println("                  //-------------------- MENU DE USUARIO --------------------//");
        System.out.println(" ");
        System.out.println("     ¿Que desea hacer en esta sesion?");
        System.out.println(" ");
        System.out.println("          1. Menu administracion de Viajero.");
        System.out.println("          2. Menu administracion de Agentes de viaje.");
        System.out.println("          3. Menu administracion de Oferta Turistica.");
        System.out.println("          4. Menu de venta de Viajes.");
        System.out.println(" ");
        System.out.println("             0. Salir del sistema.");
        System.out.println(" ");
        System.out.println("     Su eleccion:");
        System.out.println(" ");
    }

    public void menuViajero() {
        System.out.println(" ");
        System.out.println("                  //-------------------- INFORMACION DE VIAJEROS --------------------//");
        System.out.println(" ");
        System.out.println("     A continuacion las opciones del Menu:");
        System.out.println(" ");
        System.out.println("          1. Ver listado de Viajeros inscritos.");
        System.out.println("          2. Inscribir a un viajero.");
        System.out.println("          3. Otorgar visado a cliente.");
        System.out.println("          4. Ver viajes realizados para un cliente.");
        System.out.println("          5. Consignar dinero para un Viajero.");
        System.out.println("          6. Redimir millas en dinero para un Viajero.");
        System.out.println("          7. Retirar a un viajero del sistema.");
        System.out.println(" ");
        System.out.println("             0. Volver al Menu anterior.");
        System.out.println(" ");
        System.out.println("     Su eleccion:");
        System.out.println(" ");
    }

    public void menuAgente() {
        System.out.println(" ");
        System.out.println("                  //-------------------- INFORMACION DE AGENTES --------------------//");
        System.out.println(" ");
        System.out.println("     A continuacion las opciones del Menu:");
        System.out.println(" ");
        System.out.println("          1. Ver listado de agentes.");
        System.out.println("          2. Agente con mejores ventas.");
        System.out.println("          3. Clientes por agente.");
        System.out.println("          4. Contratar agente.");
        System.out.println(" ");
        System.out.println("             0. Volver al Menu anterior.");
        System.out.println(" ");
        System.out.println("     Su eleccion:");
        System.out.println(" ");
    }

    public void menuTurismo() {
        System.out.println(" ");
        System.out.println("                  //-------------------- INFORMACION DE TURISMO --------------------//");
        System.out.println(" ");
        System.out.println("     A continuacion las opciones del Menu:");
        System.out.println(" ");
        System.out.println("          1. Ver listado de Destinos turisticos disponibles.");
        System.out.println("          2. Ver hoteles por Destino.");
        System.out.println("          3. Crear un nuevo destino turístico.");
        System.out.println("          4. Construir un nuevo hotel en destino turístico.");
        System.out.println(" ");
        System.out.println("             0. Volver al Menu anterior.");
        System.out.println(" ");
        System.out.println("     Su eleccion:");
        System.out.println(" ");
    }

    public void menuVenta() {
        System.out.println(" ");
        System.out.println("                  //-------------------- VENTA DE VIAJES --------------------//");
        System.out.println(" ");
        System.out.println("     A continuacion las opciones del Menu:");
        System.out.println(" ");
        System.out.println("          1. Cotizar un viaje.");
        System.out.println("          2. Vender un viaje.");
        System.out.println("          3. Ver listado de tiquetes realizados por la empresa Sam-Travel.");
        System.out.println(" ");
        System.out.println("             0. Volver al Menu anterior.");
        System.out.println(" ");
        System.out.println("     Su eleccion:");
        System.out.println(" ");
    }

    public void imprimirDestino(Destino d) {
        String pasaporte;
        if (d.isPideVisa()) {
            pasaporte = " Es necesario pasaporte.";
        } else {
            pasaporte = " No es necesario.";
        }
        System.out.println("//------------------------------------------");
        System.out.println(" Nombre del Destino turístico : " + d.getNombre());
        System.out.println(" A una distancia de: " + d.getDistancia() + " km de Medellin.");
        System.out.println(" Pide visa para viajer@s:" + pasaporte);
        System.out.println(" Cuenta con " + d.getHoteles().size() + " hoteles.");
        System.out.println(" ");
    }

    public static void alertaNoSePuedePagarViaje(Destino d) {
        System.out.println("El presupuesto del viajero no alcanza para viajar a " + d.getNombre() + ".");
        System.out.println(" ");
    }

    public void imprimirViaje(Tiquete t) {
        System.out.println("//----------------------------");
        System.out.println(" Viaje realizado por : " + t.getViajero().getNombre());
        System.out.println(" Con destino a: " + t.getDestino().getNombre());
        System.out.println(" A un precio de: " + t.getPrecio());
        System.out.println(" ");
    }

    public void imprimirTiquete(Tiquete t) {
        if (t.getDiasEstadia() != 0) {
            System.out.println(" ");
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("//--------COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---------//");
            System.out.println("//                                                           //");
            System.out.println("// Documento: " + t.getViajero().getCedula());
            System.out.println("// A nombre de: " + t.getViajero().getNombre());
            System.out.println("// Con destino a : " + t.getDestino().getNombre());
            System.out.println("// Estadia: " + t.getDiasEstadia() + " dia(s)");
            System.out.println("// Transporte de tipo: " + t.getTransporte().getTipo());
            System.out.println("// Tiempo de Viaje: " + t.getTiempoViaje() + " horas");
            System.out.println("// Hotel: " + t.getHotel().getNombre() + " de categoría: " + t.getHotel().getEstrellas() + " Estrellas.");
            System.out.println("// Agente encargado: ID " + t.getAgente().getCedula() + " Nombre: " + t.getAgente().getNombre());
            System.out.println(" ");
            System.out.println("// PRECIO TOTAL: " + t.getPrecio() + " pesos.");
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("//-----------------------------------------------------------//");
        } else {
            System.out.println(" ");
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("//--------COMPROBANTE DE TIQUETE DE VIAJE SAM-TRAVEL---------//");
            System.out.println("//                                                           //");
            System.out.println("// Documento: " + t.getViajero().getCedula());
            System.out.println("// A nombre de: " + t.getViajero().getNombre());
            System.out.println("// Con destino a : " + t.getDestino().getNombre());
            System.out.println("// Transporte de tipo: " + t.getTransporte().getTipo());
            System.out.println("// Tiempo de Viaje: " + t.getTiempoViaje() + " horas");
            System.out.println("// Agente encargado: ID " + t.getAgente().getCedula() + " Nombre: " + t.getAgente().getNombre());
            System.out.println(" ");
            System.out.println("// PRECIO TOTAL: " + t.getPrecio() + " pesos.");
            System.out.println("//-----------------------------------------------------------//");
            System.out.println("//-----------------------------------------------------------//");
        }

    }

    public void imprimirHotel(Hotel h) {
        System.out.println("//------------------------------");
        System.out.println("Nombre de Hotel: " + h.getNombre());
        System.out.println("Costo por noche: " + h.getCosto() + " pesos");
        System.out.println("Nivel del hotel: " + h.getEstrellas() + " Estrellas.");
    }

    public void imprimirViajero(Viajero v) {
        String visa;
        if (v.isVisado()) {
            visa = " Tiene pasaporte vigente.";
        } else {
            visa = " No tiene pasaporte.";
        }
        System.out.println("//----------------------------------------//");
        System.out.println("    ID: " + v.getCedula());
        System.out.println("    Nombre: " + v.getNombre());
        System.out.println("    Visado: " + visa);
        System.out.println("    Millas Acumuladas: " + v.getMillas());
        System.out.println("    Presupuesto: " + v.getPresupuesto());
        System.out.println("    Agente encargado: ID :" + v.getAgente().getCedula() + " Nombre: "
                + v.getAgente().getNombre());
        System.out.println(" ");
    }
}
