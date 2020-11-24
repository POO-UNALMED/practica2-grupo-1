/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiMain.utils;

import uiMain.utils.BarraMenu;
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
import javafx.scene.control.Alert;
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
import uiMain.Main;
import uiMain.MenuApp;
import uiMain.Start;
import uiMain.utils.FieldPane;

public class MenuViajero {

    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static MenuBar barraMenu;
    public static FieldPane formulario;
    Viajero v;

    public static HBox botones;
    public static Button bInicio;
    public static Button bLimpiar;

    public static Button bRedimir;
    public static Button bSolicitar;
    public static Button bRetirar;
    public static Button bCotizar;
    public static Button bComprar;
    public static Button bConsignar;
    public static TextField pozo;
    Label l1;
    String top;

    public static HBox botones1;
    public static HBox botones2;
    public static ImageView marcoIM;

    public static Presion botonHandler;
    String[] tituloCriterios;
    String[] tipoCriterios;

    public MenuViajero() {

        inicializarDatos();
        tituloCriterios = new String[]{"Cedula", "Nombre", "¿Tiene visado?  "};
        tipoCriterios = new String[]{"text", "text", "choice"};
        formulario = new FieldPane(tituloCriterios, tipoCriterios);
        barraMenu = new BarraMenu().getMenu();

        marco = new BorderPane();
        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setCenter(formulario.getGrilla());
        marco.setBottom(botones);
        scena = new Scene(marco, 600, 600);
    }

    public MenuViajero(Viajero v) {

        inicializarDatos();
        actualizar(v);

        VBox info = new VBox(30);
        info.setAlignment(Pos.TOP_CENTER);
        info.setPadding(new Insets(50, 10, 10, 10));
        top = ("//----------------------------------------//") + "\n"
                + "             DATOS PERSONALES" + "\n";

        l1 = new Label(top + v.imprimirDatos());

        info.getChildren().addAll(l1, botones1, botones2, bInicio);
        formulario = new FieldPane(v);
        marco = new BorderPane();
        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setTop(barraMenu);
        marco.setCenter(info);
        marco.setBottom(marcoIM);
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos() {

        tituloCriterios = new String[]{"Cedula", "Nombre", "¿Tiene visado?  "};
        tipoCriterios = new String[]{"text", "text", "choice"};

        //Inicializar Botones
        botonHandler = new Presion();
        bInicio = new Button("Volver");
        bLimpiar = new Button("Clear");

        bInicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Main.window.setScene(new MenuApp().getEscena());
            }
        });
        bLimpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                FieldPane a = new FieldPane(tituloCriterios, tipoCriterios);
                marco.setCenter(a.getGrilla());
            }
        });
        botones = new HBox(2);
        botones.setPadding(new Insets(10));
        botones.getChildren().addAll(bInicio, bLimpiar);
        botones.setAlignment(Pos.BOTTOM_LEFT);

    }

    public void actualizar(Viajero v) {

        marcoIM = new ImageView(new Image("BaseDatos/p1.jpg"));
        marcoIM.setFitHeight(150);
        marcoIM.setFitWidth(Main.ancho);

        botones1 = new HBox(10);
        botones2 = new HBox(10);
        bSolicitar = new Button("Solicitar Visa");
        bRedimir = new Button("Redimir Millas");
        bCotizar = new Button("Cotizacion");
        bComprar = new Button("Compra de Tiquetes");
        bRetirar = new Button("Retirarse");
        bConsignar = new Button("Consignar Dinero");
        pozo = new TextField();
        botones1.getChildren().addAll(bSolicitar, bRedimir, bCotizar, bComprar);
        botones2.getChildren().addAll(bConsignar, pozo, bRetirar);
        botones1.setAlignment(Pos.CENTER);
        botones2.setAlignment(Pos.CENTER);

        bSolicitar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Solicitud de visa");
                if (v.solicitarVisa()) {
                    if (v.isVisado() == true) {
                        dialog.setContentText(" Viajer@ " + v.getNombre() + " ya cuenta con un pasaporte internacional vigente.");
                    } else {
                        v.setVisado(true);
                        l1.setText(top + v.imprimirDatos());
                        dialog.setContentText(" ¡FELICITACIONES!" + "\n"
                                + "    Ud ahora cuenta con un pasaporte internacional.");
                    }
                } else {
                    dialog.setContentText(" ¡LO SENTIMOS!" + "\n"
                            + "    Su solicitud de visado ha sido rechazada.");
                }
                dialog.showAndWait();
            }
        });

        bRedimir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Redimir un viaje.");
                if (v.getMillas() == 0) {
                    dialog.setContentText(" ¡LO SENTIMOS!" + "\n"
                            + "  " + v.getNombre() + " No cuenta con Millas vigentes.");
                } else {
                    v.redimirMillas();
                    l1.setText(top + v.imprimirDatos());
                    dialog.setContentText(" ¡REDIMIDO!" + "\n"
                            + "  Ud ha redimido las Millas de su cuenta "+ "\n"
                            + "   Nuevo Saldo: " + v.getPresupuesto());
                }
                dialog.showAndWait();
            }
        });

        bCotizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Cotizar un viaje");
                dialog.showAndWait();
            }
        });

        bComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Comprar un Tiquete");
                dialog.showAndWait();
            }
        });

        bRetirar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Retiro del Sistema");
                dialog.showAndWait();
            }
        });

        bConsignar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Solicitud de visa");
                dialog.showAndWait();
            }
        });
    }

    public static void cambiarScena(Viajero v) {
        MenuViajero mv = new MenuViajero(v);
        Main.window.setScene(mv.getEscena());
    }

    public Scene getEscena() {
        return scena;
    }
}
