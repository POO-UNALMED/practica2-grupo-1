package gestorAplicacion.utils;

import gestorAplicacion.utils.Destino;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.persons.Viajero;
import java.util.*;

public class Hotel {

    private String nombre;
    private int costo;
    private Destino destino;
    private int estrellas;
    private static ArrayList<Hotel> hoteles = new ArrayList<>();

    public Hotel(String nombre, int costo, Destino destino, int estrellas) {
        this.nombre = nombre;
        this.costo = costo;
        this.destino = destino;
        this.estrellas = estrellas;
        hoteles.add(this);
        destino.getHoteles().add(this);
    }

    public static boolean existeHotel(String nombreHotel) {
        boolean existe = false;
        for (Hotel h : hoteles) {
            if (h.getNombre().equals(nombreHotel)) {
                existe = true;
            }
        }
        return existe;
    }

    public static Hotel devolverHotel(String nombreHotel) {
        Hotel hotel = null;
        for (Hotel h : hoteles) {
            if (h.getNombre().equals(nombreHotel)) {
                hotel = h;
            }
        }
        return hotel;
    }

    /*
    Este método determina si el Viajero puede pagar aunque sea un hotel que esté en el destino ingresado.
    Esto con la intención de saber cuando le podría costar la estadía, para saber si puede pagarla o no.
    Si no pudiera pagar ni lo más barato, entonces no podría reservar hotel con SAM-TRAVEL, aunque solo
    compraría tiquete de transporte.
     */
    public static Boolean minimoDeEstadia(Viajero v,Destino d) {
        boolean puedePagarNoche = false;
        for(Hotel h : d.getHoteles()){
            if(v.getPresupuesto() >= h.getCosto()){
                puedePagarNoche = true;
            }
        }
        return puedePagarNoche;
    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

}
