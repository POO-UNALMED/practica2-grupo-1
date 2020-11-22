package gestorAplicacion.persons;

import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;


import java.util.*;

public class Viajero extends Persona implements Consumidor {

    private int presupuesto;
    private Agente agente;
    private int millas;
    private static ArrayList<Viajero> listaViajeros = new ArrayList<>();
    private ArrayList<Tiquete> viajesRealizados = new ArrayList<>();

    // CONSTRUCTORES
    public Viajero() {

    }

    public Viajero(int cedula, String nombre, boolean visado, int presupuesto) {
        super(cedula, nombre, visado);
        this.presupuesto = presupuesto;
        this.agente = Agente.agenteAleatorio();
        this.millas = 0;
        listaViajeros.add(this);
        agente.atenderCliente(this);
    }

    //METODOS HEREDADOS ABSTRACT
    // Para que al ciudadano se le pueda otorgar una visa, debe tener un mínimo de presupuesto de 5000.
    //Además debe haber viajado por lo menos una vez.
    public void obtenerVisado() {
        int money = this.presupuesto;
        int viajesHechos = this.viajesRealizados.size();
        if ((money >= 5000) && (viajesHechos >= 1)) {
            this.setVisado(true);
        } else {
            this.setVisado(false);
        }
    }
    
    //Método que hace que el viajero se retire del sistema.
    @Override
    public void retirarse() {
        listaViajeros.remove(this);
    }
    
    //Método que se implementa de la interfaz de consumidor.
    @Override
    public void pagar(int cobro) {
        int actual = this.getPresupuesto();
        setPresupuesto(actual - cobro);

    }
    
    //METODO HEREDADO DE PERSONA
    //Busca si el viajero está dentro de la base de datos.
    //Lo buscará a partir de su número de cédula.
    //Devolverá un booleano si lo encuentra o no.
    public static boolean verificarCedula(int cedulaEntrante) {
        boolean existe = false;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedulaEntrante) {
                existe = true;
            }
        }
        return existe;
    }
    
    //MÉTODOS NORMALES
    //Busca si el viajero está dentro de la base de datos.
    //Lo buscará a partir de su número de cédula.
    //Devolverá la instancia que coincida con la búsqueda.
    public static Viajero devolverPorCedula(int cedula) {
        Viajero viajeroActual = null;
        for (Viajero v : listaViajeros) {
            if (v.getCedula() == cedula) {
                viajeroActual = v;
            }
        }
        return viajeroActual;
    }
    
    //Para aumentar el presupuesto de un viajero.
    public void consignarDinero(int consignacion) {
        int presupuesto = this.presupuesto;
        this.setPresupuesto(presupuesto + consignacion);
    }

    //Método que recorre destinos, buscando si exigen o no el visado (en caso de que el viajero no tenga)
    // y también si el presupuesto del viajero es el necesario para ir al destino.
    public ArrayList<Destino> destinosPosibles() {
        ArrayList<Destino> destinos = Destino.getListaDestinos();
        ArrayList<Destino> destinosPosibles = new ArrayList<>();
        int costo;
        for (Destino d : destinos) {
            if (d.isPideVisa() && (this.isVisado())) {
                costo = d.getDistancia();
                if (this.getPresupuesto() >= costo) {
                    destinosPosibles.add(d);
                }
            } 
        }
        return destinosPosibles;
    }
    
    //Verifica si el viajero puede o no permitirse pagar un hotel.
    public boolean puedePagarHotel(Destino d) {
        ArrayList<Hotel> hoteles = d.getHoteles();
        int contador = 0;
        for (Hotel h : hoteles) {
            if (this.getPresupuesto() > h.getCosto()) {
                contador++;
            }
        }
        if (contador == 0) {
            return false;
        } else {
            return true;
        }
    }
    //Se llama este método cuando se quiere saber si cumple el requisito para sacar pasaporte.
    //Este requisito es que el viajero haya realizado por lo menos un viaje.
    public boolean haViajado() {
        if (this.getViajesRealizados().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
    //Método que se invoca cuando el viajero quiere redimir millas.
    public void redimirMillas() {
        this.setPresupuesto(this.presupuesto + this.millas);
        this.setMillas(0);
    }

    // GETTERS AND SETTERS
    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public int getMillas() {
        return millas;
    }

    public void setMillas(int millas) {
        this.millas = millas;
    }

    public static ArrayList<Viajero> getListaViajeros() {
        return listaViajeros;
    }

    public static void setListaViajeros(ArrayList<Viajero> listaViajeros) {
        Viajero.listaViajeros = listaViajeros;
    }

    public ArrayList<Tiquete> getViajesRealizados() {
        return viajesRealizados;
    }

    public void setViajesRealizados(ArrayList<Tiquete> viajesRealizados) {
        this.viajesRealizados = viajesRealizados;
    }

}
