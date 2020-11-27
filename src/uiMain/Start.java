package uiMain;

import uiMain.eventos.Cursor;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import static uiMain.Main.alto;
import static uiMain.Main.altoGrid;
import static uiMain.Main.ancho;
import static uiMain.Main.anchoGrid;
import static uiMain.Main.insets;

public class Start {

    //Objetos Generales
    public static Scene scena;
    public static MenuApp menuApp;
    public static Presion botonHandler;
    public static Cursor cursorHandler;

    //Objetos Barra
    public static MenuBar menuBar;
    public static Menu menu1;
    public static MenuItem menuSalir;
    public static MenuItem menuDescripcion;

    //Objetos P3
    public static VBox p3;
    public static TextArea txt1;
    public static String saludo;
    public static String descripcion;

    //Objetos P4
    public static VBox p4;
    public static Button bInicio;
    public static ImageView marcoP4;
    public static Image imageP4;

    //Objetos P5
    public static VBox p5;
    public static Label hdv1;
    public static Label hdv2;
    

    //OBJETOS P6
    public static GridPane p6;
    public static ImageView marco1;
    public static ImageView marco2;
    public static ImageView marco3;
    public static ImageView marco4;
    public static ImageView marco5;
    public static ImageView marco6;
    public static ImageView marco7;
    public static ImageView marco8;
    public static Image im1;
    public static Image im2;
    public static Image im3;
    public static Image im4;    
    public static Image im5;
    public static Image im6;
    public static Image im7;
    public static Image im8;
    

    public Start() {

        //INSTANCIAS
        menuApp = new MenuApp();
        botonHandler = new Presion();
        cursorHandler = new Cursor();

        //CONSTANTES;
        ancho = 600;
        alto = 600;
        insets = 10;
        anchoGrid = Main.anchoGrid;
        altoGrid = Main.altoGrid;

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
        saludo = Main.t.presentacion();
        descripcion = " SAM-TRAVEL Es un programa diseñado para administrar el manejo de una agencia de viajes, contando con el manejo de usuarios, destinos y hoteles. Asi como del registro de viajes y cotizaciones. Esperamos que disfrute su experiencia en la plataforma.";
        p3 = new VBox(20);

        txt1 = new TextArea(saludo);
        txt1.setWrapText(true);
        txt1.setEditable(false);
        txt1.setPrefSize(anchoGrid, altoGrid-30);
        p3.getChildren().add(txt1);

        //Objetos P4
        p4 = new VBox();
        p4.setSpacing(15);
        p4.setAlignment(Pos.CENTER);

        marcoP4 = new ImageView();
        imageP4 = new Image("BaseDatos/1.jpg");
        marcoP4 = new ImageView(imageP4);

        marcoP4.setFitHeight(altoGrid - 30);
        marcoP4.setFitWidth(anchoGrid);
        marcoP4.setOnMouseExited(cursorHandler);
        bInicio = new Button("Inicio");
        bInicio.setOnAction(botonHandler);
        p4.getChildren().addAll(marcoP4, bInicio);

        //Objetos P5
        p5 = new VBox();
        p5.setPadding(new Insets(10,10,10,10));
        hdv1 = new Label("Mauricio Builes " + "\n" + 
                "\"Hola tengo 27 años soy estudiante de la Universidad Nacional de Colombia, En mi tiempo libre me gusta jugar ajedrez y baloncesto\"");
        hdv1.setMaxWidth(200);
        
        //descripcion.setMaxHeight(200);
        hdv1.setWrapText(true);
        hdv1.setFont(new Font("Arial",20));
        hdv1.setStyle("-fx-text-alignment: justify;");
        hdv1.setStyle("-fx-padding: 0 0 10 0;");    
               
        p5.setPrefSize(anchoGrid, altoGrid-30);
        p5.setStyle("-fx-border-color: black");
        
        String pres = "Mi nombre es Carlos Mario, tengo 26 años y estudio en la Universidad Nacional de Colombia, gasto mi tiempo entre mi familia, amigos cercanos y con actividades que considero aportantes.";
        String cv = "Persona activa, en constante aprendizaje y con interés de laborar en proyectos de mi área académica. Conocimiento y uso de herramientas ofimáticas, lenguajes de programación y sistemas gestores de datos.";
        hdv2 = new Label(pres + "\n" +" "+ "\n" + cv);
        hdv2.setMaxWidth(250);
        hdv2.setWrapText(true);
        p5.setOnMouseClicked(cursorHandler);
        p5.getChildren().addAll(hdv2);
        
        

        //Objetos P6
        p6 = new GridPane();
        im1 = new Image("BaseDatos/m1.jpg");
        im2 = new Image("BaseDatos/m2.jpg");
        im3 = new Image("BaseDatos/m3.jpg");
        im4 = new Image("BaseDatos/m4.jpg");
        im5 = new Image("BaseDatos/r1.jpg");
        im6 = new Image("BaseDatos/r2.jpg");
        im7 = new Image("BaseDatos/r3.jpg");
        im8 = new Image("BaseDatos/r4.jpg");

        marco1 = new ImageView(im1);
        marco2 = new ImageView(im2);
        marco3 = new ImageView(im3);
        marco4 = new ImageView(im4);
        marco5 = new ImageView(im5);
        marco6 = new ImageView(im6);
        marco7 = new ImageView(im7);
        marco8 = new ImageView(im8);

        marco1.setFitHeight(altoGrid / 2);
        marco1.setFitWidth(anchoGrid / 2);
        marco2.setFitHeight(altoGrid / 3);
        marco2.setFitWidth(anchoGrid / 2);
        marco3.setFitHeight(altoGrid / 2);
        marco3.setFitWidth(anchoGrid / 3);
        marco4.setFitHeight(altoGrid / 3);
        marco4.setFitWidth(anchoGrid / 3);
        marco5.setFitHeight(altoGrid / 2);
        marco5.setFitWidth(anchoGrid / 2);
        marco6.setFitHeight(altoGrid / 2);
        marco6.setFitWidth(anchoGrid / 2);
        marco7.setFitHeight(altoGrid / 2);
        marco7.setFitWidth(anchoGrid / 2);
        marco8.setFitHeight(altoGrid / 2);
        marco8.setFitWidth(anchoGrid / 2);

        p6.setPrefSize(anchoGrid, altoGrid);
        p6.setAlignment(Pos.CENTER);
        p6.setVgap(5);
        p6.setHgap(5);
        p6.add(marco1, 0, 0);
        p6.add(marco2, 0, 1);
        p6.add(marco3, 1, 0);
        p6.add(marco4, 1, 1);

        //Caracteristicas P1
        GridPane p1 = new GridPane();
        p1.setVgap(20);
        p1.setPrefSize(altoGrid, anchoGrid - 20);
        p1.setPadding(new Insets(10, 10, 10, 10));
        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        //Caracteristicas P2
        GridPane p2 = new GridPane();
        p2.setVgap(0);
        p2.setPrefSize(altoGrid, anchoGrid - 20);
        p2.setPadding(new Insets(10, 10, 10, 0));
        p2.add(p5, 0, 0);
        p2.add(p6, 0, 1);

        //BoderPane
        BorderPane marco = new BorderPane();
        marco.setPadding(new Insets(0, 10, 10, 10));
        marco.setTop(menuBar);
        marco.setLeft(p1);
        marco.setRight(p2);

        //Proyeccion
        scena = new Scene(marco, ancho, alto);
    }

    public static void setEscena(Scene s) {
        Main.window.setScene(s);
        Main.window.show();
    }

    public Scene getEscena() {
        return scena;
    }

    public static void cerrar() {
        Main.window.close();
    }

}