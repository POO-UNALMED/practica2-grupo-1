package uiMain;

import uiMain.utils.BarraMenu;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import gestorAplicacion.utils.Transporte;
import java.util.ArrayList;
import java.util.Iterator;
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

public class MenuVenta {

    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static BarraMenu barraMenu;

    Image im;
    ImageView marcoIM;
    Viajero v;
    VBox screen;
    ArrayList<String> destinos;
    ChoiceBox cDestino;
    ChoiceBox cTrans;
    ChoiceBox cHotel;
    ChoiceBox cEstadia;
    int subtotal;
    TextField txtPago;
    Button bComprar;
    int costoTransporte;
    Destino d1;
    int presupuestoHotel;
    Hotel h1;
    Transporte tr;
    Tiquete tiquete;
    int diasEstadia;

    Map<Destino, int[]> opcionesTransporte;

    public MenuVenta(Viajero v) {
        inicializarDatos(v);

        marco.setTop(barraMenu.getMenu());
        marco.setRight(marcoIM);
        marco.setCenter(screen);
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos(Viajero v) {

        this.v = v;

        barraMenu = new BarraMenu();
        marco = new BorderPane();
        marco.setPadding(new Insets(0, 0, 10, 0));

        im = new Image("BaseDatos/venta.jpg");
        marcoIM = new ImageView(im);
        marcoIM.setFitHeight(Main.alto);
        marcoIM.setFitWidth(200);

        screen = new VBox(20);
        screen.setAlignment(Pos.CENTER);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        Label titulo = new Label(" - PLATAFORMA PARA VENTA DE TIQUETES - ");
        Label destino = new Label(" Destino:  ");
        Label trans = new Label(" Transporte:  ");
        Label hotel = new Label(" Hotel:  ");
        Label estadia = new Label(" Dias de estancia:  ");

        HBox total = new HBox(20);
        total.setAlignment(Pos.CENTER);
        Label ltotal = new Label(" Total: ");
        bComprar = new Button(" Comprar ");
        costoTransporte = 0;
        subtotal = 0;
        presupuestoHotel = 0;
        txtPago = new TextField(Integer.toString(subtotal));
        txtPago.setAlignment(Pos.CENTER);
        total.getChildren().addAll(ltotal, txtPago, bComprar);

        cDestino = new ChoiceBox();
        cTrans = new ChoiceBox();
        cHotel = new ChoiceBox();
        cEstadia = new ChoiceBox();
        for (String s1 : ofertaDestinos(v)) {
            cDestino.getItems().add(s1);
        }
        acciones();

        grid.add(destino, 0, 0);
        grid.add(cDestino, 1, 0);
        grid.add(trans, 0, 1);
        grid.add(cTrans, 1, 1);
        grid.add(hotel, 0, 2);
        grid.add(cHotel, 1, 2);
        grid.add(estadia, 0, 3);
        grid.add(cEstadia, 1, 3);
        screen.getChildren().add(titulo);
        screen.getChildren().add(grid);
        screen.getChildren().add(total);

    }

    public Scene getEscena() {
        return scena;
    }

    public void acciones() {

        cDestino.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                cTrans.getItems().clear();
                String nombreDestino = (String) cDestino.getValue();
                d1 = Destino.devolverDestino(nombreDestino);
                costoTransporte = 0;
                int[] transportes = opcionesTransporte.get(d1);
                if (transportes[0] != -1) {
                    cTrans.getItems().add("Aereo - Costo: " + transportes[0]);
                }
                if (transportes[1] != -1) {
                    cTrans.getItems().add("Terrestre - Costo: " + transportes[1]);
                }
                if (transportes[2] != -1) {
                    cTrans.getItems().add("Maritimo - Costo: " + transportes[2]);
                }
            }
        });

        cTrans.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                try {
                    subtotal = 0;
                    String imp = (String) cTrans.getValue();
                    costoTransporte = Integer.parseInt(imp.substring(imp.lastIndexOf(" ") + 1));
                    String[] cadena = imp.split(" ");
                    String tipoTransporte = cadena[0].toLowerCase();
                    tr = new Transporte(tipoTransporte,d1);
                    subtotal = subtotal + costoTransporte;
                    txtPago.setText(Integer.toString(subtotal));
                    presupuestoHotel = v.getPresupuesto() - costoTransporte;
                    if (!(d1.getHoteles().isEmpty())) {
                        for (Hotel h : d1.getHoteles()) {
                            if (h.getCosto() <= presupuestoHotel) {
                                cHotel.getItems().add(h.getNombre() + " - Costo " + h.getCosto());
                            }
                        }
                    } else {
                        System.out.println("llega aca12");
                        cHotel.getItems().add("No disponible");
                        cEstadia.getItems().add(0);
                    }
                } catch (Exception e) {
                    System.out.println("ERROR");
                }

            }
        });

        cHotel.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String cadena = (String) cHotel.getValue();
                String[] imp = cadena.split(" ");
                System.out.println(imp[0]);
                h1 = Hotel.devolverHotel(imp[0]);
                int maximoEstadia = Math.round(presupuestoHotel / h1.getCosto());
                for (int i = 1; i <= maximoEstadia; i++) {
                    cEstadia.getItems().add(i);
                }
            }
        });

        cEstadia.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int aux = subtotal;
                diasEstadia = (Integer) cEstadia.getValue();
                int costoHotel = h1.getCosto() * diasEstadia;
                aux = aux + costoHotel;
                txtPago.setText(Integer.toString(aux));
            }
        });

        bComprar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
                dialog.setHeaderText(" COMPROBANTE DE PAGO ");
                if( (Integer)cEstadia.getValue() == 0){
                    tiquete = new Tiquete(v,tr);
                    System.out.println(tiquete.getViajero().getNombre()); 
                }else{
                    tiquete = new Tiquete(v,tr,h1,diasEstadia);
                    System.out.println(tiquete.getPrecio());
                }
                TextArea ta = new TextArea(tiquete.imprimirDatos());
                ta.setWrapText(true);
                dialog.getDialogPane().setContent(ta);
                dialog.showAndWait();
                v.pagar(tiquete.getPrecio());
                MenuViajero.cambiarScena(v);
            }
        });

    }

    public ArrayList<String> ofertaDestinos(Viajero v) {
        destinos = new ArrayList<>();
        opcionesTransporte = Destino.esPosibleViajar(v);
        Iterator<Map.Entry<Destino, int[]>> entradas = opcionesTransporte.entrySet().iterator();
        while (entradas.hasNext()) {
            Map.Entry<Destino, int[]> entry = entradas.next();
            if ((entry.getValue()[0] != -1) || (entry.getValue()[1] != -1) || (entry.getValue()[2] != -1)) {
                destinos.add(entry.getKey().getNombre());
            }
        }
        return destinos;
    }

}
