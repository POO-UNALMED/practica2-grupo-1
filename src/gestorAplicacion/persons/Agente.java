package gestorAplicacion.persons;

import gestorAplicacion.persons.Persona;
import gestorAplicacion.persons.Viajero;
import java.util.*;
import java.util.Map.Entry;

public class Agente extends Persona {

    private final double pComision = 0.10;
    private int comision;
    private ArrayList<Viajero> listaClientes = new ArrayList<>();
    private static ArrayList<Agente> listaAgentes = new ArrayList<>();

    //CONSTRUCTOR
    public Agente(int cedula, String nombre, boolean visado) {
        super(cedula, nombre, visado);
        this.comision = 0;
        listaAgentes.add(this);
    }

    //METODOS HEREDADOS ABSTRACT
    //Métodos heredados de Persona
    @Override
    public void obtenerVisado(){
        this.setVisado(true);
    }
    
    @Override
    public void retirarse(){
        listaAgentes.remove(this);
    }
    
    //MÉTODOS
    public void atenderCliente(Viajero viajero){
        this.listaClientes.add(viajero);
    }

    public static boolean verificarCedula(int cedula) {
        int contador = 0;
        for (Agente a : listaAgentes) {
            if (a.getCedula() == cedula) {
                continue;
            } else {
                contador++;
            }
        }
        if (contador == listaAgentes.size()) {
            return false;
        } else {
            return true;
        }
    }

    public static Persona devolverPorCedula(int cedula) {
        Agente agenteActual = null;
        for (Agente a : listaAgentes) {
            if (a.getCedula() == cedula) {
                agenteActual = a;
            }
        }
        return agenteActual;
    }

    public static Agente agenteAleatorio() {
        Agente agenteAsignado = Agente.getListaAgentes().get(0);
        int numeroAleatorio = (int) Math.floor(Math.random()*Agente.numeroAgentes());
        agenteAsignado = Agente.getListaAgentes().get(numeroAleatorio);
        return agenteAsignado;
    }
    
    public static int numeroAgentes(){
        return Agente.getListaAgentes().size();
    }

    public static List<Entry<String, Integer>> mejoresAgentes() {
        HashMap<String, Integer> agentes = new HashMap<>();

        for (Agente agente : listaAgentes) {

            agentes.put(agente.getNombre(), agente.getListaClientes().size());
        }

        Set<Entry<String, Integer>> entrySet = agentes.entrySet();

        List<Entry<String, Integer>> list = new ArrayList<>(entrySet);

        Collections.sort(list, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        return list;
    }
    
    public static Agente existeAgente(int cedula){
        for(Agente agente : listaAgentes){
            if(agente.getCedula() == (cedula)){
                return agente;
            }
        }
        return null;
    }
    
    public static double comision(String nombre) {
    	for (Agente agente : listaAgentes) {
			if(agente.getNombre().equals(nombre)) {
				
				return agente.getComision();				
			}
		}
    	return 0;
    }
    
    public static boolean buscarCedula(int cedula) {
    	for (Agente agente : listaAgentes) {
			if(agente.getCedula() == cedula) {
				return true;
			}
		}
    	return false;
    }
    
    public void comisionar(int total){
        setComision((int)(total*pComision));
    }

    // GETTERS AND SETTERS

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public ArrayList<Viajero> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Viajero> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public static ArrayList<Agente> getListaAgentes() {
        return listaAgentes;
    }

    public static void setListaAgentes(ArrayList<Agente> listaAgentes) {
        Agente.listaAgentes = listaAgentes;
    }
    

}
