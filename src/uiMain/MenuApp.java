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

public class MenuApp extends Application {

    //Objetos Generales
    Stage window;
    Scene scena;

    @Override
    public void start(Stage stage) throws Exception {

        //Proyeccion
        window.setTitle("  SAM-TRAVEL v.0");
        Label lb = new Label("Page1");
        Button b1 = new Button("OK");
        FlowPane layout1 = new FlowPane(lb,b1);
        scena = new Scene(layout1);
        window.setScene(scena);
        window.show();
        
    }

}
