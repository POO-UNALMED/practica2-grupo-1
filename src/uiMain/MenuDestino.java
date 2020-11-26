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

    VBox caja;
    Label titulo;
    Label datosDestino;

    Viajero v;
    static Destino d;

    String[] tituloCriterios;
    String[] tipoCriterios;

    public MenuDestino() {
        inicializarDatos();

        marco.setTop(barraMenu.getMenu());
        marco.setCenter(formulario.getGrilla());
        marco.setPadding(new Insets(0, 0, 10, 0));
        scena = new Scene(marco, 600, 600);
    }

    public MenuDestino(Destino d) {
        inicializarDatos();
        actualizar(d);
        marco.setTop(barraMenu.getMenu());
        marco.setCenter(caja);
        marco.setPadding(new Insets(0, 0, 10, 0));
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
        this.d = d;
        caja = new VBox(10);
        caja.setAlignment(Pos.CENTER);
        titulo = new Label(" DATOS DEL DESTINO TURÍSTICO");
        datosDestino = new Label(d.imprimirDatos());
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
        

        caja.getChildren().add(titulo);
        caja.getChildren().add(datosDestino);
        caja.getChildren().add(bHoteles);

    }

    public Scene getEscena() {
        return scena;
    }

    public static void cambiarScena(Destino d) {
        MenuDestino md = new MenuDestino(d);
        Main.window.setScene(md.getEscena());
    }
}
