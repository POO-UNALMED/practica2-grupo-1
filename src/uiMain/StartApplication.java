package uiMain;

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

public class StartApplication extends Application {

    //Objetos Generales
    Stage window;
    Presion handler = new Presion();
    Cursor cursorHandler = new Cursor();

    //Constantes
    int ancho = 500;
    int alto = 600;
    int insets = 10;
    int anchoGrid = (ancho / 2) - 2 * insets;
    int altoGrid = (alto / 2) - 2 * insets;

    //Objetos Barra
    MenuBar menuBar;
    Menu menu1;
    MenuItem menuSalir;
    MenuItem menuDescripcion;

    //Objetos P3
    VBox p3;
    TextArea txt1;
    String saludo;
    String descripcion;

    //Objetos P4
    VBox p4;
    Button bInicio;
    ImageView marcoP4;
    Image imageP4;

    //Objetos P5
    String cv;
    Button b2;
    VBox p5;
    TextArea txt2;
    Image image1;
    ImageView imageView1;

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Titulo");

        //BARRA DE MENU
        menuBar = new MenuBar();
        menu1 = new Menu("Inicio");
        menuDescripcion = new MenuItem("Descripcion");
        menuSalir = new MenuItem("Salir");

        menu1.getItems().addAll(menuDescripcion, menuSalir);
        menuBar.getMenus().add(menu1);
        menuSalir.setOnAction(handler);
        menuDescripcion.setOnAction(handler);

        //Objetos P3
        saludo = "Un texto es una composición de signos codificados en un sistema de escritura que forma una unidad de sentido. También es una composición de caracteres imprimibles generados por un algoritmo de cifrado que, aunque no tienen sentido para cualquier persona, sí puede ser descifrado por su destinatario original.";
        descripcion = "Descripcion";

        p3 = new VBox(20);
        txt1 = new TextArea(saludo);
        txt1.setPrefSize(anchoGrid, altoGrid);
        p3.getChildren().add(txt1);

        //Objetos P4
        p4 = new VBox();
        p4.setSpacing(15);
        p4.setAlignment(Pos.CENTER);
        bInicio = new Button("Inicio");
        marcoP4 = new ImageView();
        imageP4 = new Image(getClass().getResourceAsStream("yo.jpg"));
        marcoP4 = new ImageView(imageP4);
        marcoP4.setFitHeight(altoGrid - 30);
        marcoP4.setFitWidth(anchoGrid);
        marcoP4.setOnMouseClicked(cursorHandler);

        p4.getChildren().addAll(marcoP4, bInicio);

        //Objetos P5
        cv = "Hoja de Vida";
        b2 = new Button("Fotos");
        p5 = new VBox(20);
        txt2 = new TextArea(cv);
        txt2.setPrefSize((ancho / 2) - 2 * insets, (alto / 2) - 2 * insets);
        /*
        image1 = new Image(getClass().getResourceAsStream("yo.jpg"));
        imageView1 = new ImageView(image1);
        imageView1.setFitHeight(50);
        imageView1.setFitWidth(50);
         */
        p5.getChildren().addAll(txt2);

        //Objetos P6
        //Caracteristicas P1
        GridPane p1 = new GridPane();
        p1.setVgap(20);
        p1.setPrefSize(altoGrid, anchoGrid);
        p1.setPadding(new Insets(insets));
        p1.add(p3, 0, 0);
        p1.add(p4, 0, 1);

        //Caracteristicas P2
        GridPane p2 = new GridPane();
        p2.setPadding(new Insets(insets));
        p2.add(p5, 0, 0);
        p2.add(b2, 0, 1);

        //BoderPane
        BorderPane marco = new BorderPane();
        marco.setTop(menuBar);
        marco.setLeft(p1);
        marco.setRight(p2);

        //Proyeccion
        window.setTitle("  SAM-TRAVEL v.0");
        Scene scena = new Scene(marco, ancho, alto);
        window.setScene(scena);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
        //MenuApp ma = new MenuApp();
    }

    class Presion implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            Object comando = e.getSource();
            if (comando instanceof MenuItem) {
                if (((MenuItem) comando).getText().equals("Descripcion") && txt1.getText().equals(saludo)) {
                    txt1.setText(descripcion);
                    menuDescripcion.setText("Saludo");
                } else {
                    txt1.setText(saludo);
                    menuDescripcion.setText("Descripcion");
                }
                if (((MenuItem) comando).getText().equals("Salir")) {
                    window.close();
                }
            }
            if (comando instanceof Button) {
                if (((Button) comando).getText().equals("Inicio")) {
                    window.close();
                }
            }

        }

    }

    class Cursor implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent m) {
            Object comando = m;
            if (!(comando instanceof ImageView)) {
                //marcoP4
                imageP4 = new Image(getClass().getResourceAsStream("darla.jpg"));
                marcoP4.setImage(imageP4);
                p4.getChildren().add(marcoP4);
            }

        }

    }
}
