package uiMain.utils;

import uiMain.Main.*;
import gestorAplicacion.persons.Viajero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sun.applet.Main;

/**
 *
 * @author SAM
 */
public class FieldPane extends Pane {

    GridPane grid;
    Button bEnviar;
    Button bBuscar;
    Label l1;
    Label l2;

    public FieldPane(String[] campos, String[] tipos) {

        grid = new GridPane();
        bEnviar = new Button("Enviar");
        bBuscar = new Button("Buscar");
        l1 = new Label("     INSCRIPCION DE VIAJERO");
        l2 = new Label("     BUSQUEDA POR CEDULA");
        TextField t1 = new TextField();
        acciones();
        int contador = 0;
        int contador2;

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);

        for (String s : campos) {
            Label l = new Label(s);
            grid.add(l, 0, contador + 1);
            if (tipos[contador] == "text") {
                TextField t = new TextField();
                grid.add(t, 1, contador + 1);

            } else if (tipos[contador] == "choice") {
                ChoiceBox c = new ChoiceBox();
                c.getItems().add("Si");
                c.getItems().add("No");
                grid.add(c, 1, contador + 1);
            }
            contador++;
        }
        grid.add(l1, 0, 0);
        grid.add(bEnviar, 1, contador + 1);

        contador2 = contador + 3;
        grid.add(l2, 0, contador2);
        grid.add(t1, 0, contador2 + 1);
        grid.add(bBuscar, 1, contador2 + 1);

    }
    
    public FieldPane(Viajero v){
        
    }

    FieldPane() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void acciones() {

        bEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                try {
                    int ced = Integer.parseInt(((TextField) grid.getChildren().get(1)).getText());
                    String nom = (String) ((TextField) grid.getChildren().get(3)).getText();
                    String choice = (String) ((ChoiceBox) grid.getChildren().get(5)).getValue();
                    Boolean visa;
                    if (choice.equals("Si")) {
                        visa = true;
                    } else {
                        visa = false;
                    }
                    Viajero v = new Viajero(ced, nom, visa, 0);
                    MenuViajero.cambiarScena(v);
                    TextArea txt1 = new TextArea(v.imprimirDatos());
                    dialog.setHeaderText("CREACION DE NUEVO USUARIO EXITOSA");
                    dialog.getDialogPane().setContent(txt1);
                    dialog.showAndWait();

                } catch (Exception e) {
                    TextArea txt1 = new TextArea("ERROR AL INTRODUCIR LOS DATOS" + "\n" + "POR FAVOR INTENTELO DE NUEVO.");
                    dialog.setHeaderText("¡Ups!");
                    dialog.getDialogPane().setContent(txt1);
                    dialog.showAndWait();
                }

            }
        });

        bBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");
                try {
                    int ced = Integer.parseInt(((TextField) grid.getChildren().get(9)).getText());
                    if (Viajero.verificarCedula(ced)) {
                        Viajero v = Viajero.devolverPorCedula(ced);
                        MenuViajero.cambiarScena(v);
                        TextArea txt1 = new TextArea(v.imprimirDatos());
                        dialog.setHeaderText("VIAJERO ENCONTRADO");
                        dialog.getDialogPane().setContent(txt1);
                        dialog.showAndWait();
                    } else {
                        throw new Exception("No se encontró cédula.");
                    }
                } catch (Exception e) {
                    TextArea txt1 = new TextArea("ERROR AL INTRODUCIR LOS DATOS" + "\n" + "POR FAVOR INTENTELO DE NUEVO.");
                    dialog.setHeaderText("¡Ups!");
                    dialog.getDialogPane().setContent(txt1);
                    dialog.showAndWait();
                }
            }
        });
    }

    public GridPane getGrilla() {
        return grid;
    }
    
}