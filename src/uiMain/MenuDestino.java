package uiMain;

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
import uiMain.utils.BarraMenu;
import uiMain.utils.FieldPane;
import uiMain.utils.FieldPane;

public class MenuDestino {

    public static Scene scena;
    public static Stage window;
    public static BorderPane marco;
    public static BarraMenu barraMenu;
    public static FieldPane formulario;
    
    static Button bComprar;
    static Button bCotizar;
    static Button bClear;
    
    Viajero v;

    String[] tituloCriterios;
    String[] tipoCriterios;

    public MenuDestino(Viajero v) {
        inicializarDatos(v);
        
        
        

        marco.setTop(barraMenu.getMenu());
        marco.setCenter(formulario.getGrilla());
        marco.setPadding(new Insets(0, 0, 10, 0));
        scena = new Scene(marco, 600, 600);
    }

    public void inicializarDatos(Viajero v) {
        barraMenu = new BarraMenu();
        marco = new BorderPane();
        tituloCriterios = new String[]{"Destino ", " Transporte ", " Hotel "," Estadia"};
        tipoCriterios = new String[]{"choice", "choice", "choice","text"};
        formulario = new FieldPane(v,tituloCriterios,tipoCriterios);
    }

    public Scene getScena() {
        return scena;
    }
}
