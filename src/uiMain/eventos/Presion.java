package uiMain.eventos;

import gestorAplicacion.persons.Agente;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import uiMain.Main;
import uiMain.MenuApp;
import uiMain.Start;
import uiMain.Start.*;
import static uiMain.Start.*;
import static uiMain.Main.*;
import uiMain.utils.BarraMenu;
import uiMain.MenuViajero;

public class Presion implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        
        Object comando = e.getSource();
        
        if (comando instanceof MenuItem) {
            MenuItem item = (MenuItem) comando;
            if (item.equals(Start.menuSalir)) {
                Main.window.close();
            } else if (item.equals(Start.menuDescripcion) && Start.txt1.getText().equals(Start.saludo)) {
                Start.txt1.setText(Start.descripcion);
                Start.menuDescripcion.setText("Saludo");
            } else if (item.equals(BarraMenu.comSalir)) {
                Start nuevoInicio = new Start();
                Main.window.setScene(nuevoInicio.getEscena());
                Main.window.show();
            } else if (item.equals(BarraMenu.comInfo)) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle("Informacion");
                dialog.setHeaderText("Info de Sam-Travel");
                dialog.showAndWait();
            } else if (item.equals(BarraMenu.comViajeros)) {
                imprimirViajeros();

            } else if (item.equals(BarraMenu.comAgentes)) {
                imprimirAgentes();

            } else if (item.equals(BarraMenu.comDestinos)) {
                imprimirDestinos();

            } else if (item.equals(BarraMenu.comIntegrantes)) {
                imprimirAyuda();
            } else {
                Start.txt1.setText(Start.saludo);
                Start.menuDescripcion.setText("Descripcion");
            }
            
        } else if (comando instanceof Button) {
            Button b = (Button)comando;
            if (b.equals(Start.bInicio)) {
                MenuApp menuApp = new MenuApp();
                Scene scena = menuApp.getEscena();
                Main.window.setScene(scena);
                Main.window.show();
                
            }else if(b.equals(MenuApp.b1)){
                Main.window.setScene(new MenuViajero().getEscena());            
            }else if(b.equals(MenuApp.b2)){
                
            }else if(b.equals(MenuApp.b3)){
                
            }
        }

    }

    public void imprimirViajeros() {
        String impresion = "";
        for (Viajero v : Viajero.getListaViajeros()) {
            impresion = impresion + v.imprimirDatos();
        }
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("SAM-TRAVEL");
        dialog.setHeaderText("LISTADO DE VIAJEROS");
        TextArea txt = new TextArea(impresion);
        txt.setEditable(false);
        txt.setWrapText(true);
        txt.setPrefSize(400, 500);
        dialog.getDialogPane().setContent(txt);
        dialog.setResizable(true);
        dialog.showAndWait();
    }

    public void imprimirAgentes() {
        String impresion = "";
        for (Agente a : Agente.getListaAgentes()) {
            impresion = impresion + a.imprimirDatos();
        }
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("SAM-TRAVEL");
        dialog.setHeaderText("LISTADO DE AGENTES");
        TextArea txt = new TextArea(impresion);
        txt.setEditable(false);
        txt.setWrapText(true);
        txt.setPrefSize(400, 500);
        dialog.getDialogPane().setContent(txt);
        dialog.setResizable(true);
        dialog.showAndWait();
    }

    public void imprimirDestinos() {
        String impresion = "";
        for (Destino d : Destino.getListaDestinos()) {
            impresion = impresion + d.imprimirDatos();
        }
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("SAM-TRAVEL");
        dialog.setHeaderText("LISTADO DE DESTINOS");
        TextArea txt = new TextArea(impresion);
        txt.setEditable(false);
        txt.setWrapText(true);
        txt.setPrefSize(300, 500);
        dialog.getDialogPane().setContent(txt);
        dialog.setResizable(true);
        dialog.showAndWait();
    }

    public void imprimirAyuda() {
        String impresion = "";
        impresion = Main.t.ayuda();
        Alert dialog = new Alert(Alert.AlertType.INFORMATION);
        dialog.setTitle("SAM-TRAVEL");
        dialog.setHeaderText("AYUDA");
        TextArea txt = new TextArea(impresion);
        txt.setEditable(false);
        txt.setWrapText(true);
        txt.setPrefSize(400, 200);
        dialog.getDialogPane().setContent(txt);
        dialog.setResizable(true);
        dialog.showAndWait();
    }

    public void imprimirPresentacion() {

    }

}
