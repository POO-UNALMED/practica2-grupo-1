package gestorAplicacion.utils;

import gestorAplicacion.persons.Viajero;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import uiMain.Texto;

public class Destino {

    private String nombre;
    private int distancia;
    private boolean pideVisa;
    private boolean accesoMar;
    private boolean accesoTierra;
    private ArrayList<Hotel> hoteles = new ArrayList<>();
    private static ArrayList<Destino> listaDestinos = new ArrayList<>();

    public Destino(String nombre, int distancia, boolean pideVisa, boolean accesoMar, boolean accesoTierra) {
        this.nombre = nombre;
        this.distancia = distancia;
        this.pideVisa = pideVisa;
        this.accesoMar = accesoMar;
        this.accesoTierra = accesoTierra;
        listaDestinos.add(this);
    }

    //METODO
    public static boolean existeDestino(String nombreDestino) {
        boolean existe = false;
        for (Destino d : listaDestinos) {
            if (d.getNombre().equals(nombreDestino)) {
                existe = true;
            }
        }
        return existe;
    }

    public static Destino devolverDestino(String nombreDestino) {
        Destino destino = null;
        for (Destino d : listaDestinos) {
            if (d.getNombre().equals(nombreDestino)) {
                destino = d;
            }
        }
        return destino;
    }

    public boolean tieneHoteles() {
        if (this.getHoteles().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    /*
    Metodo que determina si el presupuesto del viajero es el suficiente para las diferentes ofertas de transporte del programa.
     */

    public static Map<Destino, int[]> esPosibleViajar(Viajero v) {
        Transporte t = new Transporte();
        int[] cotizacion = new int[3];
        Map<Destino, int[]> cotizacionPorDestino = new HashMap<Destino, int[]>();
        for (Destino d : listaDestinos) {
            cotizacion = t.cotizacionTransporte(d);
            for (int i = 0; i < cotizacion.length; i++) {
                if (cotizacion[i] > v.getPresupuesto()) {
                    cotizacion[i] = -1;
                }
            }
            if ((cotizacion[0] == -1) && (cotizacion[1] == -1) && (cotizacion[2] == -1)) {
                Texto.alertaNoSePuedePagarViaje(d);

            } else {
                cotizacionPorDestino.put(d, cotizacion);
            }
        }
        return cotizacionPorDestino;

    }

    //GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public boolean isPideVisa() {
        return pideVisa;
    }

    public void setPideVisa(boolean pideVisa) {
        this.pideVisa = pideVisa;
    }

    public boolean isAccesoMar() {
        return accesoMar;
    }

    public void setAccesoMar(boolean accesoMar) {
        this.accesoMar = accesoMar;
    }

    public boolean isAccesoTierra() {
        return accesoTierra;
    }

    public void setAccesoTierra(boolean accesoTierra) {
        this.accesoTierra = accesoTierra;
    }

    public ArrayList<Hotel> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public static ArrayList<Destino> getListaDestinos() {
        return listaDestinos;
    }

    public static void setListaDestinos(ArrayList<Destino> listaDestinos) {
        Destino.listaDestinos = listaDestinos;
    }

}
