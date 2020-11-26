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
