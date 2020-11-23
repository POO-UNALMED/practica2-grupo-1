package uiMain;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import gestorAplicacion.utils.Hotel;
import gestorAplicacion.utils.Tiquete;
import gestorAplicacion.utils.Transporte;
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

public class Main extends Application {

    public static Stage window;
    public static Start inicho;
    public static Texto t;

    //Constantes
    public static int ancho;
    public static int alto;
    public static int insets;
    public static int anchoGrid;
    public static int altoGrid;

    @Override
    public void start(Stage stage) throws Exception {

        //Inicialización de GUI
        Start Inicio = new Start();
        window = new Stage();
        window.setTitle("SAM-TRAVEL v 1.0");
        window.setScene(new Start().getEscena());
        window.show();
    }

    public static void main(String[] args) {
        cargarInstancias();
        t = new Texto();
        launch(args);
    }

    public static void cargarInstancias() {
        //CONSTANTES;
        ancho = 600;
        alto = 600;
        insets = 10;
        anchoGrid = (ancho / 2) - 20;
        altoGrid = (alto / 2) - 40;

        //INSTANCIAS DE AGENTE
        Agente agenteSupremo = new Agente(10, "SAM", true);
        Agente agente1 = new Agente(11, "Bustamante", true);
        Agente agente2 = new Agente(12, "Ramirez", false);
        Agente agente3 = new Agente(13, "Bastidas", false);
        Agente agente4 = new Agente(14, "Castillo", true);
        Agente agente5 = new Agente(15, "Reinoso", true);

        //INSTANCIAS DE VIAJERO
        Viajero viajero1 = new Viajero(1, "Carlos", true, 5000);
        Viajero viajero2 = new Viajero(2, "Marcela", false, 20000);
        Viajero viajero3 = new Viajero(3, "Luisa", true, 1000);
        Viajero viajero4 = new Viajero(4, "Andrea", false, 1100);
        Viajero viajero5 = new Viajero(5, "Estefania", false, 1000);
        Viajero viajero6 = new Viajero(6, "Diana", true, 10000);
        Viajero viajero7 = new Viajero(7, "Ulises", false, 2500);
        Viajero viajero8 = new Viajero(8, "Julio", true, 0);
        Viajero viajero9 = new Viajero(9, "Alberto", false, 100);

        //INSTANCIAS DE DESTINO
        Destino destino1 = new Destino("SanAndres", 500, false, true, false);
        Destino destino2 = new Destino("Cartagena", 300, false, true, true);
        Destino destino3 = new Destino("BuenosAires", 1000, true, true, true);
        Destino destino4 = new Destino("RioDeJaneiro", 800, true, true, false);
        Destino destino5 = new Destino("Cusco", 400, true, false, true);
        Destino destino6 = new Destino("Bogota", 100, false, false, true);
        Destino destino7 = new Destino("Santiago", 1000, true, true, true);
        Destino destino8 = new Destino("Panama", 800, false, true, false);
        Destino destino9 = new Destino("Lima", 700, false, true, true);
        Destino destino10 = new Destino("Patagonia", 1200, true, false, false);

        //INSTANCIAS DE HOTEL
        Hotel hotel1 = new Hotel("Andira", 60, destino1, 2);
        Hotel hotel2 = new Hotel("Tiburon", 80, destino1, 3);
        Hotel hotel3 = new Hotel("PlayaBlanca", 120, destino1, 4);
        Hotel hotel4 = new Hotel("Decameron", 160, destino1, 5);
        Hotel hotel5 = new Hotel("Litium", 110, destino2, 4);
        Hotel hotel6 = new Hotel("Hijano", 90, destino2, 3);
        Hotel hotel7 = new Hotel("Luxury", 120, destino3, 5);
        Hotel hotel8 = new Hotel("Tango", 80, destino3, 5);
        Hotel hotel9 = new Hotel("Angel", 70, destino3, 4);
        Hotel hotel10 = new Hotel("CostaDelSol", 60, destino4, 4);
        Hotel hotel11 = new Hotel("Limon", 60, destino5, 2);
        Hotel hotel12 = new Hotel("Tiburon", 80, destino5, 1);
        Hotel hotel13 = new Hotel("Chocolate", 60, destino6, 4);
        Hotel hotel14 = new Hotel("Normandy", 70, destino6, 3);
        Hotel hotel15 = new Hotel("Bugaloo", 85, destino7, 4);
        Hotel hotel16 = new Hotel("Revolucion", 100, destino7, 3);
        Hotel hotel17 = new Hotel("SanBlas", 130, destino8, 4);
        Hotel hotel18 = new Hotel("LaMiel", 60, destino8, 2);
        Hotel hotel19 = new Hotel("Barreda", 160, destino8, 5);
        Hotel hotel20 = new Hotel("Ceviche", 110, destino9, 4);

        //INSTANCIAS DE TRANSPORTE
        Transporte transporte1 = new Transporte("aereo", destino1);
        Transporte transporte2 = new Transporte("maritimo", destino2);
        Transporte transporte3 = new Transporte("terrestre", destino3);
        Transporte transporte4 = new Transporte("maritimo", destino3);
        Transporte transporte5 = new Transporte("aereo", destino4);
        Transporte transporte6 = new Transporte("terrestre", destino5);
        Transporte transporte7 = new Transporte("aereo", destino5);
        Transporte transporte8 = new Transporte("terrestre", destino7);
        Transporte transporte9 = new Transporte("terrestre", destino9);
        Transporte transporte10 = new Transporte("aereo", destino10);

        //INSTANCIAS DE TIQUETE
        Tiquete tiquete1 = new Tiquete(viajero1, transporte1);
        Tiquete tiquete2 = new Tiquete(viajero2, transporte2);
        Tiquete tiquete3 = new Tiquete(viajero3, transporte3);
        Tiquete tiquete4 = new Tiquete(viajero3, transporte4);
        Tiquete tiquete5 = new Tiquete(viajero4, transporte10);
        Tiquete tiquete6 = new Tiquete(viajero4, transporte6, hotel12, 2);
        Tiquete tiquete7 = new Tiquete(viajero5, transporte7, hotel12, 3);
        Tiquete tiquete8 = new Tiquete(viajero6, transporte8, hotel15, 5);
        Tiquete tiquete9 = new Tiquete(viajero8, transporte9, hotel20, 4);
        Tiquete tiquete10 = new Tiquete(viajero9, transporte5, hotel10, 8);
    }

}
