package gestorAplicacion.utils;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.persons.Viajero;
import java.util.ArrayList;

public class Tiquete {

    private Viajero viajero;
    private Agente agente;
    private Transporte transporte;
    private int tiempoViaje;
    private int diasEstadia;
    private Destino destino;
    private Hotel hotel;
    private double precio;
    private static ArrayList<Tiquete> viajesRealizados = new ArrayList<>();
    
    //Aquí se puede evidenciar el uso de dos diferentes constructores de una clase.
    //Este constructor es usado cuando el viajero compra transporte y tambien reserva un hotel.
    public Tiquete(Viajero viajero, Transporte transporte, Hotel hotel, int diasEstadia) {
        this.viajero = viajero;
        this.agente = viajero.getAgente();
        this.transporte = transporte;
        this.destino = transporte.getDestino();
        this.tiempoViaje = this.destino.getDistancia() / transporte.getVelocidad();
        this.diasEstadia = diasEstadia;
        this.hotel = hotel;
        this.precio = calcularPrecio(transporte, hotel, diasEstadia);
        viajesRealizados.add(this);
        viajero.setMillas((int) Math.floor(destino.getDistancia() / 10));
        viajero.getViajesRealizados().add(this);
        agente.comisionar((int)precio);
    }

    //Este constructor es usado cuando el usuario unicamente compra el transporte al destino.
    public Tiquete(Viajero viajero, Transporte transporte) {
        this.viajero = viajero;
        this.agente = viajero.getAgente();
        this.transporte = transporte;
        this.destino = transporte.getDestino();
        this.tiempoViaje = this.destino.getDistancia() / transporte.getVelocidad();
        this.diasEstadia = 0;
        this.hotel = null;
        this.precio = calcularPrecio(transporte);
        viajesRealizados.add(this);
        viajero.setMillas(destino.getDistancia() / 10);
        viajero.getViajesRealizados().add(this);
        agente.comisionar((int)precio);
    }
    
    //SOBRECARGA DE MÉTODOS.
    //Son dos métodos usados en calcular el precio del tiquete, uno para cada tipo de tiquete.
    //Calcula el precio de transporte + hotel.
    public static int calcularPrecio(Transporte t, Hotel h, int diasEstadia) {
        int precio;
        int costoTransporte = t.getPrecio();
        int costoHotel = h.getCosto() * diasEstadia;
        precio = costoTransporte + costoHotel;
        return precio;
    }
    
    //Calcula el precio del transporte.
    public static int calcularPrecio(Transporte t) {
        int precio;
        int costoTransporte = t.getPrecio();
        precio = costoTransporte;
        return precio;
    }
    
    //GETTERS AND SETTERS
    public Viajero getViajero() {
        return viajero;
    }

    public void setViajero(Viajero viajero) {
        this.viajero = viajero;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public int getTiempoViaje() {
        return tiempoViaje;
    }

    public void setTiempoViaje(int tiempoViaje) {
        this.tiempoViaje = tiempoViaje;
    }

    public int getDiasEstadia() {
        return diasEstadia;
    }

    public void setDiasEstadia(int diasEstadia) {
        this.diasEstadia = diasEstadia;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static ArrayList<Tiquete> getViajesRealizados() {
        return viajesRealizados;
    }

    public static void setViajesRealizados(ArrayList<Tiquete> viajesRealizados) {
        Tiquete.viajesRealizados = viajesRealizados;
    }

}
