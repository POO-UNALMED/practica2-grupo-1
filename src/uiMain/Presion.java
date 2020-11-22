package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import uiMain.Inicio.*;
import static uiMain.Main.inicho;

public class Presion implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        Object comando = e.getSource();
        if (comando instanceof MenuItem) {
            MenuItem item = (MenuItem) comando;
            if (item.equals(Inicio.menuSalir)) {
                Main.window.close();
            } else if (item.equals(Inicio.menuDescripcion)&& Inicio.txt1.getText().equals(Inicio.saludo)) {
                Inicio.txt1.setText(Inicio.descripcion);
                Inicio.menuDescripcion.setText("Saludo");
            } else if (item.equals(MenuApp.comSalir)) {
                Inicio nuevoInicio = new Inicio();
                Main.window.setScene(nuevoInicio.getEscena());
                Main.window.show();
            } else if (item.equals(MenuApp.comInfo)) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle("Informacion");
                dialog.setHeaderText("Info de Sam-Travel");
                dialog.showAndWait();
            } else if (item.equals(MenuApp.comViajeros)) {
                imprimirViajeros();
                
            } else {
                Inicio.txt1.setText(Inicio.saludo);
                Inicio.menuDescripcion.setText("Descripcion");
            }
        }
        if (comando instanceof Button) {
            if (((Button) comando).getText().equals("Inicio")) {
                MenuApp menuApp = new MenuApp();
                Scene scena = menuApp.getEscena();
                Main.window.setScene(scena);
                Main.window.show();
            }
        }

    }
    
    public void imprimirViajeros(){
        TextArea txt = new TextArea("Prueba");
        MenuApp.cuadro.getChildren().clear();
        MenuApp.cuadro.getChildren().add(txt);      
    }

}
