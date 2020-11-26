package gestorAplicacion.utils;

import java.util.ArrayList;

public class Transporte {

    private String tipo;
    private static final int costoKMAereo = 3;
    private static final int costoKMTerrestre = 1;
    private static final int costoKMMaritimo = 2;
    private Destino destino;
    private int precio;
    private int velocidad;
    private double tiempoDeViaje;
    private static ArrayList<Transporte> viajesRealizados = new ArrayList<>();
    
    
    public Transporte(String tipo, Destino d) {
        this.tipo = tipo;
        this.destino = d;
        if (tipo.equals("aereo")) {
            this.precio = d.getDistancia() * costoKMAereo;
            this.velocidad = 300;
            this.tiempoDeViaje = d.getDistancia() / velocidad;
        } else if (tipo.equals("terrestre")) {
            this.precio = d.getDistancia() * costoKMTerrestre;
            this.velocidad = 100;
            this.tiempoDeViaje = d.getDistancia() / velocidad;
        } else if (tipo.equals("maritimo")) {
            this.precio = d.getDistancia() * costoKMMaritimo;
            this.velocidad = 200;
            this.tiempoDeViaje = d.getDistancia() / velocidad;
        }else{
            this.precio = 10000000;
            this.velocidad = 100;
            this.tiempoDeViaje = 1;
        }
        viajesRealizados.add(this);
    }

    public Transporte() {

    }

    //METODOS TRANSPORTE
    //Método que devuelve todas las ofertas de transporte que podría adquirir un viajero.
    public int[] cotizacionTransporte(Destino d) {
        int[] cotizacion = new int[3];

        //Cotizacion viajes aereos.
        int costoAereo = d.getDistancia() * costoKMAereo;
        cotizacion[0] = costoAereo;

        //Cotizacion viajes por Tierra.
        if (d.isAccesoTierra()) {
            int costoTierra = d.getDistancia() * costoKMTerrestre;
            cotizacion[1] = costoTierra;
        } else {
            cotizacion[1] = -1;
        }
        
        //Cotizacion Viajes por mar.
        if (d.isAccesoMar()) {
            int costoMar = d.getDistancia() * costoKMMaritimo;
            cotizacion[2] = costoMar;
        } else {
            cotizacion[2] = -1;
        }

        return cotizacion;
    }

    //GETTERS AND SETTERS
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getTiempoDeViaje() {
        return tiempoDeViaje;
    }

    public void setTiempoDeViaje(double tiempoDeViaje) {
        this.tiempoDeViaje = tiempoDeViaje;
    }

    public static ArrayList<Transporte> getViajesRealizados() {
        return viajesRealizados;
    }

    public static void setViajesRealizados(ArrayList<Transporte> viajesRealizados) {
        Transporte.viajesRealizados = viajesRealizados;
    }

}
