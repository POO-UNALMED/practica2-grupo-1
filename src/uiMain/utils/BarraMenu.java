/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiMain.utils;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import uiMain.eventos.Presion;

/**
 *
 * @author SAM
 */
public class BarraMenu {

    public static MenuBar barraMenu;
    public static Menu menuArchivos;
    public static Menu menuConsultas;
    public static Menu menuAyuda;

    public static MenuItem comSalir;
    public static MenuItem comInfo;
    public static MenuItem comViajeros;
    public static MenuItem comAgentes;
    public static MenuItem comDestinos;
    public static MenuItem comIntegrantes;

    public static Presion botonHandler;

    public BarraMenu() {
        botonHandler = new Presion();

        //Inicialización Menu de Barra
        menuArchivos = new Menu("Archivos");
        menuConsultas = new Menu("Procesos y Consultas");
        menuAyuda = new Menu("Ayuda");

        comSalir = new MenuItem("Inicio");
        comInfo = new MenuItem("Info de Sam-Travel");
        comSalir.setOnAction(botonHandler);
        comInfo.setOnAction(botonHandler);
        menuArchivos.getItems().addAll(comInfo, comSalir);

        comViajeros = new MenuItem("Listado de Viajeros");
        comAgentes = new MenuItem("Listado de Agentes");
        comDestinos = new MenuItem("Listado de Destinos Turisticos");
        comViajeros.setOnAction(botonHandler);
        comAgentes.setOnAction(botonHandler);
        comDestinos.setOnAction(botonHandler);
        menuConsultas.getItems().addAll(comViajeros, comAgentes, comDestinos);

        comIntegrantes = new MenuItem("Integrantes");
        comIntegrantes.setOnAction(botonHandler);
        menuAyuda.getItems().addAll(comIntegrantes);

        barraMenu = new MenuBar();
        barraMenu.getMenus().addAll(menuArchivos, menuConsultas, menuAyuda);

    }
    public MenuBar getMenu(){
        return barraMenu;
    }
}
