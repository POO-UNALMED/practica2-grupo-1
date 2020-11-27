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

//Aca se crea el diseño del menu venta
public class MenuVenta {

    
    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static BarraMenu barraMenu;
    public static FieldPane formulario;

    Image im;
    ImageView marcoIM;
    Viajero v;
    public static String[] n;

    String[] tituloCriterios;
    String[] tipoCriterios;

    public MenuVenta(Viajero v) {
        inicializarDatos(v);
        Hotel[] hoteles;
        marco.setTop(barraMenu.getMenu());
        marco.setCenter(formulario.getGrilla());
        marco.setPadding(new Insets(0, 0, 10, 0));
        marco.setRight(marcoIM);
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos(Viajero v) {
        barraMenu = new BarraMenu();
        marco = new BorderPane();
        tituloCriterios = new String[]{"Destino ", " Transporte ", " Hotel ", " Estadia"};
        tipoCriterios = new String[]{"choice", "choice", "choice", "text"};
        n = new String[100];
        formulario = new FieldPane(v, tituloCriterios, tipoCriterios);
        im = new Image("BaseDatos/venta.jpg");
        marcoIM = new ImageView();
        
    }

    public Scene getScena() {
        return scena;
    }

    public static String[] ofertaDestinos(Viajero v) {
        n = new String[1000];
        Map<Destino, int[]> opcionesTransporte = Destino.esPosibleViajar(v);
        opcionesTransporte.forEach((key, value) -> {
            if((value[0] != -1) && (value[1] != -1) && (value[2] != -1)) {
                n[n.length] = key.getNombre();
            }
        });
        return n;
    }

}
