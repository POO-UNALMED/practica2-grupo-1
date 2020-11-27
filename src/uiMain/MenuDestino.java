package uiMain;

import uiMain.utils.BarraMenu;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import java.util.Map;
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
import javafx.scene.control.Alert;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
import uiMain.Main;
import uiMain.MenuApp;
import uiMain.Start;
import uiMain.utils.BarraMenu;
import uiMain.utils.FieldPane;
import uiMain.utils.FieldPane;

public class MenuDestino {

    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static BarraMenu barraMenu;
    public static FieldPane formulario;

    static Button bHoteles;
    static Button bCrear;
    static Button bInicio;
    static Button bClear;
    static Button bCrearHotel;

    Label nom;
    Label star;
    Label costo;

    VBox caja;
    Label titulo;
    Label datosDestino;
    GridPane gridCreacion;

    Viajero v;
    static Destino d;

    String[] tituloCriterios;
    String[] tipoCriterios;
    ImageView marcoIM;

    public MenuDestino() {
        inicializarDatos();

        marco.setTop(barraMenu.getMenu());
        marco.setCenter(formulario.getGrilla());
        marco.setPadding(new Insets(0, 0, 10, 0));
        scena = new Scene(marco, 600, 600);
    }

    public MenuDestino(Destino d) {
        actualizar(d);
        
        marco.setTop(barraMenu.getMenu());
        marco.setCenter(caja);
        marco.setBottom(marcoIM);
        marco.setPadding(new Insets(0, 0, 0, 0));
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos() {
        barraMenu = new BarraMenu();
        marco = new BorderPane();
        bCrear = new Button(" Crear Hotel ");
        bInicio = new Button(" Volver ");;
        bClear = new Button(" Clear ");;
        tituloCriterios = new String[]{"Nombre ", " Distancia ", " ¿Requiere visa? ", " Accesible por mar ", " Accesible por tierra "};
        tipoCriterios = new String[]{"text", "text", "choice", "check", "check"};
        formulario = new FieldPane(tituloCriterios, tipoCriterios);
        
    }

    public void actualizar(Destino d) {
        inicializarDatos();
        acciones();
        this.d = d;
        caja = new VBox(20);
        caja.setAlignment(Pos.CENTER);
        titulo = new Label(" DATOS DEL DESTINO TURÍSTICO");
        datosDestino = new Label(d.imprimirDatos());
        
        marcoIM = new ImageView(new Image("BaseDatos/pat.jpg"));
        marcoIM.setFitHeight(100);
        marcoIM.setFitWidth(Main.ancho);

        Label l2 = new Label(" - CREACION DE HOTEL PARA DESTINO - ");
        HBox b1 = new HBox(30);

        b1.getChildren().addAll(datosDestino, bHoteles);
        b1.setAlignment(Pos.CENTER);

        gridCreacion = new GridPane();
        gridCreacion.setAlignment(Pos.CENTER);
        gridCreacion.setVgap(20);
        nom = new Label(" Nombre: ");
        star = new Label(" Estrellas: ");
        costo = new Label(" Costo/Noche: ");
        TextField nomR = new TextField();
        ChoiceBox starR = new ChoiceBox();
        TextField costoR = new TextField();
        for (int i = 1; i <= 5; i++) {
            starR.getItems().add(i);
        }
        acciones();
        gridCreacion.add(nom, 0, 0);
        gridCreacion.add(nomR, 1, 0);
        gridCreacion.add(star, 0, 1);
        gridCreacion.add(starR, 1, 1);
        gridCreacion.add(costo, 0, 2);
        gridCreacion.add(costoR, 1, 2);

        caja.getChildren().add(titulo);
        caja.getChildren().add(b1);
        caja.getChildren().add(l2);
        caja.getChildren().add(gridCreacion);
        caja.getChildren().add(bCrearHotel);
        caja.getChildren().add(bInicio);

    }

    public void acciones() {
        bCrearHotel = new Button(" Construir Hotel ");
        bCrearHotel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                String nombre = ((TextField) gridCreacion.getChildren().get(1)).getText();
                int stars = (Integer) ((ChoiceBox) gridCreacion.getChildren().get(3)).getValue();
                System.out.println(stars);
                int costo = Integer.parseInt(((TextField) gridCreacion.getChildren().get(5)).getText());

                Hotel h = new Hotel(nombre, costo, d, stars);
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" HOTEL CREADO EXITOSAMENTE.");
                dialog.setContentText(h.imprimirDatos());
                dialog.showAndWait();
            }

        });

        bHoteles = new Button(" Ver listado de Hoteles ");
        bHoteles.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String infoHoteles = "";
                Boolean hayHoteles = false;
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);

                for (Hotel h : d.getHoteles()) {
                    infoHoteles = infoHoteles + h.imprimirDatos();
                    hayHoteles = true;
                }
                if (hayHoteles) {
                    TextArea txt1 = new TextArea(infoHoteles);
                    dialog.setHeaderText(" LISTADO DE HOTELES EN DESTINO TURISTICO ");
                    dialog.getDialogPane().setContent(txt1);
                    dialog.showAndWait();
                } else {
                    TextArea txt1 = new TextArea(" No hay hoteles disponibles en el destino turístico.");
                    dialog.setHeaderText(" PETICIÓN RECHAZADA ");
                    dialog.getDialogPane().setContent(txt1);
                    dialog.showAndWait();
                }

            }

        });

        bInicio = new Button(" - Volver al Menu Principal - ");
        bInicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                MenuApp s = new MenuApp();
                Main.window.setScene(s.getEscena());
            }

        });

    }

    public Scene getEscena() {
        return scena;
    }

    public static void cambiarScena(Destino d) {
        MenuDestino md = new MenuDestino(d);
        Main.window.setScene(md.getEscena());
    }
}
