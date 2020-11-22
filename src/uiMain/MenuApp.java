package uiMain;

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
    static Scene scena;
    static Stage window;
    
    static GridPane grid;
    static HBox cuadro;

    static MenuBar barraMenu;
    static Menu menuArchivos;
    static Menu menuConsultas;
    static Menu menuAyuda;

    static MenuItem comSalir;
    static MenuItem comInfo;
    static MenuItem comViajeros;
    static MenuItem comAgentes;
    static MenuItem comDestinos;

    static Presion botonHandler;

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
        comDestinos= new MenuItem("Listado de Destinos Turisticos");
        comViajeros.setOnAction(botonHandler);
        comAgentes.setOnAction(botonHandler); 
        comDestinos.setOnAction(botonHandler); 
        
        menuConsultas.getItems().addAll(comViajeros,comAgentes,comDestinos);
        

        barraMenu = new MenuBar();
        barraMenu.getMenus().addAll(menuArchivos, menuConsultas, menuAyuda);

        window = new Stage();
        window.setTitle("  SAM-TRAVEL v.01");

        grid= new GridPane();
        //grid.setAlignment(Pos.CENTER);
        BorderPane marco = new BorderPane();

        //Desde aquí va a depender del argumento de entrada de MenuApp
        
        cuadro = new HBox();
        cuadro.setAlignment(Pos.CENTER);
        Label l1 = new Label("Dato ");
        TextField t1 = new TextField();
        cuadro.getChildren().add(l1);
        cuadro.getChildren().add(t1);
        grid.add(cuadro, 0, 0);
        marco.setTop(barraMenu);
        marco.setCenter(grid);
        scena = new Scene(marco, 600, 600);
    }

    public Scene getEscena() {
        return scena;
    }

}
