package gestorAplicacion.persons;

import java.util.*;

public abstract class Persona {

    protected int cedula;
    protected String nombre;
    protected boolean visado;
    public static ArrayList<Persona> listaPersonas = new ArrayList<>();

    public Persona(int cedula, String nombre, boolean visado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.visado = visado;
        listaPersonas.add(this);

    }

    public Persona() {

    }

    // METODOS ABSTRACT: Método que se herederán en las clases hijas Viajero y Agente.
    public abstract void obtenerVisado();

    public abstract void retirarse();

    //MÉTODOS
    //Verifica si hay alguna persona con el mismo numero de cedula que se ingresa.
    public static boolean verificarCedula(int cedulaEntrante) {
        boolean disponible = false;
        for (Persona p : listaPersonas) {
            if (p.getCedula() == cedulaEntrante) {
                disponible = true;
            }
        }
        return disponible;
    }

    // GETTERS AND SETTERS
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisado() {
        return visado;
    }

    public void setVisado(boolean visado) {
        this.visado = visado;
    }

    public static ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static void setListaPersonas(ArrayList<Persona> listaPersonas) {
        Persona.listaPersonas = listaPersonas;
    }
}
