package uiMain;

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

public class MenuApp {

    //Objetos Generales
    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;

    public static GridPane opciones;

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

    public static Button b1;
    public static Button b2;
    public static Button b3;

    public static Presion botonHandler;

    public MenuApp() {

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

        //IMAGEN LATERAL
        Image im = new Image("BaseDatos/m.jpg");
        ImageView lateral = new ImageView(im);
        lateral.setFitWidth(400);

        marco = new BorderPane();

        //Desde aquí va a depender del argumento de entrada de MenuApp
        opciones = new GridPane();
        opciones.setAlignment(Pos.TOP_CENTER);
        b1 = new Button("Viajeros");
        b2 = new Button("Destinos");
        b3 = new Button("Compra");
        b1.setMinSize(200, 190);
        b2.setMinSize(200, 200);
        b3.setMinSize(200, 200);
        b1.setOnAction(botonHandler);
        b2.setOnAction(botonHandler);
        b3.setOnAction(botonHandler);

        opciones.add(b1, 0, 0);
        opciones.add(b2, 0, 1);
        opciones.add(b3, 0, 2);

        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setLeft(lateral);
        marco.setCenter(opciones);
        scena = new Scene(marco, 600, 600);
    }

    public Scene getEscena() {
        return scena;
    }

}
