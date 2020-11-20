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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;

public class Inicio {

    //Objetos Generales
    static Stage window;
    static Scene scena;
    static MenuApp menuApp;
    static Presion botonHandler;
    static Cursor cursorHandler;

    //Constantes
    static int ancho;
    static int alto;
    static int insets;
    static int anchoGrid;
    static int altoGrid;

    //Objetos Barra
    static MenuBar menuBar;
    static Menu menu1;
    static MenuItem menuSalir;
    static MenuItem menuDescripcion;

    //Objetos P3
    static VBox p3;
    static TextArea txt1;
    static String saludo;
    static String descripcion;

    //Objetos P4
    static VBox p4;
    static Button bInicio;
    static ImageView marcoP4;
    static Image imageP4;

    //Objetos P5
    static String cv;
    static Button b2;
    static VBox p5;
    static TextArea txt2;
    static Image image1;
    static ImageView imageView1;

    public Inicio() {
        
        //INSTANCIAS
        menuApp = new MenuApp();
        botonHandler = new Presion();
        cursorHandler = new Cursor();
        
        
        //CONSTANTES;
        ancho = 500;
        alto = 600;
        insets = 10;
        anchoGrid = (ancho / 2) - 2 * insets;
        altoGrid = (alto / 2) - 2 * insets;

        //BARRA DE MENU
        menuBar = new MenuBar();
        menu1 = new Menu("Inicio");
        menuDescripcion = new MenuItem("Descripcion");
        menuSalir = new MenuItem("Salir");

        menu1.getItems().addAll(menuDescripcion, menuSalir);
        menuBar.getMenus().add(menu1);
        menuSalir.setOnAction(botonHandler);
        menuDescripcion.setOnAction(botonHandler);

        //Objetos P3
        saludo = "Un texto es una composición de signos codificados en un sistema de escritura que forma una unidad de sentido. También es una composición de caracteres imprimibles generados por un algoritmo de cifrado que, aunque no tienen sentido para cualquier persona, sí puede ser descifrado por su destinatario original.";
        descripcion = "Descripcion";

        p3 = new VBox(20);
        txt1 = new TextArea(saludo);

        txt1.setPrefSize(anchoGrid, altoGrid);

        p3.getChildren().add(txt1);

        //Objetos P4
        p4 = new VBox();
        p4.setSpacing(15);
        p4.setAlignment(Pos.CENTER);

        marcoP4 = new ImageView();
        imageP4 = new Image(getClass().getResourceAsStream("yo.jpg"));
        marcoP4 = new ImageView(imageP4);

        marcoP4.setFitHeight(altoGrid - 30);
        marcoP4.setFitWidth(anchoGrid);
        marcoP4.setOnMouseClicked(cursorHandler);
        bInicio = new Button("Inicio");
        bInicio.setOnAction(botonHandler);

        p4.getChildren().addAll(marcoP4, bInicio);

        //Objetos P5
        cv = "Hoja de Vida";
        b2 = new Button("Fotos");
        p5 = new VBox(20);
        txt2 = new TextArea(cv);
        txt2.setPrefSize((ancho / 2) - 2 * insets, (alto / 2) - 2 * insets);
        p5.getChildren().addAll(txt2);

        //Objetos P6
        
        //Caracteristicas P1
        GridPane p1 = new GridPane();

        p1.setVgap(20);
        p1.setPrefSize(altoGrid, anchoGrid);
        p1.setPadding(new Insets(insets));
        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        //Caracteristicas P2
        GridPane p2 = new GridPane();
        p2.setPadding(new Insets(insets));
        p2.add(p5, 0, 0);
        p2.add(b2, 0, 1);

        //BoderPane
        BorderPane marco = new BorderPane();
        marco.setTop(menuBar);
        marco.setLeft(p1);
        marco.setRight(p2);

        //Proyeccion
        scena = new Scene(marco, ancho, alto);
    }

    public static void setEscena(Scene s) {
        window.setScene(s);
        window.show();
    }

    public static Scene getEscena() {
        return scena;
    }
    
    public static void cerrar(){
        window.close();
    }

}
