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
import uiMain.eventos.Cursor;
import uiMain.utils.BarraMenu;

public class MenuApp {

    //Objetos Generales
    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static MenuBar barraMenu;
    public static GridPane opciones;

    public static Button b1;
    public static Button b2;
    public static Button bInicio;

    public static Presion botonHandler;
    public static Cursor cursorHandler;

    public MenuApp() {

        inicializarDatos();
        //Inicializador de receptores de Eventos.
        botonHandler = new Presion();
        cursorHandler = new Cursor();

        //IMAGEN LATERAL
        Image im = new Image("BaseDatos/m.jpg");
        ImageView lateral = new ImageView(im);
        lateral.setFitWidth(400);

        opciones.add(b1, 0, 0);
        opciones.add(b2, 0, 1);
        opciones.add(bInicio, 0, 2);

        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setLeft(lateral);
        marco.setCenter(opciones);
        scena = new Scene(marco, 600, 600);
    }

    public Scene getEscena() {
        return scena;
    }

    public void inicializarDatos() {
        marco = new BorderPane();
        barraMenu = new BarraMenu().getMenu();

        //Desde aquí va a depender del argumento de entrada de MenuApp
        opciones = new GridPane();
        opciones.setAlignment(Pos.TOP_CENTER);
        String s1 = "Viajeros:" + "\n" + "\n" + " - Formulario de Inscripcion." + "\n" + " - Encontrar Viajero existente."+ "\n" + " - Funciones de Viajero."+ "\n" + " - Venta de Tiquetes.";
        String s2 = "Destino:" + "\n" + "\n" + " - Crear Destino" + "\n" + " - Encontrar Destino existente."+ "\n" + " - Consulta de Hoteles por Destino"+ "\n" + " - Creacion de Hoteles";
        b1 = new Button(s1);
        b2 = new Button(s2);
        bInicio = new Button(" - Volver al Inicio - ");
        b1.setMinSize(200, 190);
        b2.setMinSize(200, 200);
        bInicio.setMinSize(200, 200);

        b1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Main.window.setScene(new MenuViajero().getEscena());
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Main.window.setScene(new MenuDestino().getEscena());
            }
        });

        bInicio.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Main.window.setScene(new Start().getEscena());
            }
        });

    }

}
