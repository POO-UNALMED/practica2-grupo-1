package uiMain;

import uiMain.utils.BarraMenu;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
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

    public MenuVenta(Viajero v) {
        inicializarDatos(v);

        marco.setTop(barraMenu.getMenu());
        marco.setRight(marcoIM);
        marco.setCenter(screen);
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos(Viajero v) {

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
        ChoiceBox cDestino = new ChoiceBox();
        for (String s1 : ofertaDestinos(v)) {
            cDestino.getItems().add(s1);
        }
        ChoiceBox cTrans = new ChoiceBox();
        if(grid.getChildren().get(2).getV){
            
        }
        ChoiceBox cHotel = new ChoiceBox();
        ChoiceBox cEstadia = new ChoiceBox();
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

    }

    public Scene getEscena() {
        return scena;
    }

    public ArrayList<String> ofertaDestinos(Viajero v) {
        destinos = new ArrayList<>();
        Map<Destino, int[]> opcionesTransporte = Destino.esPosibleViajar(v);
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
