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
