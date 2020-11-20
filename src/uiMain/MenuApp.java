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

public class MenuApp{

    //Objetos Generales
    Scene scena;
    Stage window;

    public MenuApp(){
        //Proyeccion
        Label lb = new Label("Page1");
        GridPane grid2 = new GridPane();
        window = new Stage();
        window.setTitle("  SAM-TRAVEL v.01");
        Button b1 = new Button("OK");
        grid2.getChildren().setAll(b1);
        scena = new Scene(grid2,200,200);
    }
    
    public Scene getEscena(){
        return scena;
    }

}