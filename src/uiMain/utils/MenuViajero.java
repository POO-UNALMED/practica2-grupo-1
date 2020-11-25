/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uiMain.utils;

import uiMain.utils.BarraMenu;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
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
    String imp2;

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
        imp2 = "a";
    }

    public MenuViajero(Viajero v) {

        inicializarDatos();
        actualizar(v);
        imp2 = "a";

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
                            + "  Ud ha redimido las Millas de su cuenta " + "\n"
                            + "   Nuevo Saldo: " + v.getPresupuesto());
                }
                dialog.showAndWait();
            }
        });

        bCotizar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                cotizarViaje(v);
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
                v.retirarse();
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                dialog.setHeaderText(" Retiro de Usuario ");
                String retiro = "Sentimos mucho que se retire" +"\n"+
                        "Hasta luego " + v.getNombre() + ", vuelve pronto.";
                TextArea t1 = new TextArea(retiro);
                dialog.getDialogPane().setContent(t1);
                dialog.showAndWait();
                
                //Recargar de la página para mostrar la versión de MenuViajero
                //Que no tiene asociado un Viajero.
                MenuViajero mv = new MenuViajero();
                Main.window.setScene(mv.getEscena());
            }
        });

        bConsignar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                try {
                    int consignacion = Integer.parseInt(pozo.getText());
                    v.consignarDinero(consignacion);
                    l1.setText(top + v.imprimirDatos());
                    dialog.setHeaderText(" Consignación Exitosa");
                    dialog.showAndWait();
                } catch (Exception e) {
                    dialog.setHeaderText(" Error en Consignación");
                    dialog.showAndWait();
                }

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

    public void cotizarViaje(Viajero v) {

        try {
            String imp = "";
            imp = imp + (" ") + "\n";
            imp = imp + ("//---------- COTIZACION DE VIAJES ----------//") + "\n";
            imp = imp + (" ") + "\n";
            imp = imp + (" ") + "\n";
            imp = imp + ("//------- OFERTA DE TRANSPORTE PARA EL VIAJERO " + v.getNombre() + " -------//") + "\n";
            imp = imp + (" ");
            imp = imp + (" A continuación se imprimirán todas los posibles tiquetes de transporte que podría comprar el viajero.") + "\n";
            imp = imp + ("    Esto último a partir de su presupuesto actual de " + v.getPresupuesto() + " pesos.") + "\n";
            imp = imp + ("") + "\n";
            imp = imp + ("//--------------------------------------------------------------------------------------") + "\n";
            imp = imp + (" ") + "\n";

            //Proceso para determinar cuales tiquetes de viaje puede costear el Viajero.
            Map<Destino, int[]> opcionesTransporte = Destino.esPosibleViajar(v);

            opcionesTransporte.forEach((key, value) -> {
                String aux = "";
                if (imp2.equals("a")) {
                    imp2 = "";
                }
                aux = aux + ("//---------------------------------------------") + "\n";
                aux = aux + ("Destino: " + key.getNombre()) + "\n";
                for (int i = 0; i < value.length; i++) {
                    if ((i == 0) && (value[i] != -1)) {
                        aux = aux + ("    Costo tiquete aereo: " + value[0] + " pesos.") + "\n";
                    } else if ((i == 1) && (value[i] != -1)) {
                        aux = aux + ("    Costo tiquete terrestre: " + value[1] + " pesos.") + "\n";
                    } else if ((i == 2) && (value[i] != -1)) {
                        aux = aux + ("    Costo tiquete maritimo:  " + value[2] + " pesos.") + "\n";
                    }
                }
                imp2 = imp2 + aux;
            });
            imp2 = imp2 + ("//---------------------------------------------") + "\n";
            imp2 = imp2 + (" ") + "\n";

            Alert dialog = new Alert(Alert.AlertType.INFORMATION);
            TextArea t = new TextArea(imp2);
            t.setWrapText(true);
            t.setPrefSize(200, 500);
            dialog.setHeaderText("Estos son los viajes que se" + "\n" + "puede permitir Viajer@ " + v.getNombre());
            dialog.getDialogPane().setContent(t);
            dialog.showAndWait();

        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("No hay ningun viajero con la cedula digitada.");
        }

    }
}
