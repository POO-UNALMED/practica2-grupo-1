/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiMain.ventanas;

import gestorAplicacion.persons.Viajero;
import uiMain.eventos.Presion;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import uiMain.utils.FieldPane;

public class MenuViajero {

    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static FieldPane formulario;

    public static MenuBar barraMenu;
    public static Menu menuArchivos;
    public static Menu menuFunciones;
    public static Menu menuConsultas;
    public static Menu menuAyuda;

    public static MenuItem comSalir;
    public static MenuItem comInfo;
    public static MenuItem comViajeros;
    public static MenuItem comAgentes;
    public static MenuItem comDestinos;
    public static MenuItem comIntegrantes;
    
    public static Button bInicio;
    public static Button bLimpiar;
    public static HBox botones;

    public static Presion botonHandler;

    public MenuViajero() {
        
        inicializarDatos();
           
        String[] tituloCriterios = new String[]{"Cedula","Nombre","¿Tiene visado? "};
        
        formulario = new FieldPane(tituloCriterios);
        
        marco = new BorderPane();
        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setCenter(formulario.getGrilla());
        marco.setBottom(botones);
        scena = new Scene(marco, 600, 600);
        
        
        
        

    }

    public MenuViajero(Viajero v) {
        
        inicializarDatos();
        //formulario = new FieldPane();
        
        marco = new BorderPane();
        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setBottom(botones);
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos() {
        
        //Inicializar Botones
        botonHandler = new Presion();
        bInicio = new Button("Volver");
        bLimpiar = new Button("Clear");
        botones = new HBox(2);
        botones.setPadding(new Insets(10));
        botones.getChildren().addAll(bInicio,bLimpiar);
        botones.setAlignment(Pos.BOTTOM_LEFT);
        
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
    
    public Scene getEscena(){
        return scena;
    }
}
