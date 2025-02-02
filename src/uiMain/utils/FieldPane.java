package uiMain.utils;

import gestorAplicacion.persons.Persona;
import uiMain.MenuViajero;
import uiMain.Main.*;
import gestorAplicacion.persons.Viajero;
import gestorAplicacion.utils.Destino;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import sun.applet.Main;
import uiMain.MenuDestino;
import uiMain.MenuVenta;

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
        int contador = 0;
        int contador2;
        boolean prestablecido;
        TextField t1 = new TextField();
        ChoiceBox c1 = new ChoiceBox();
        if (campos.length == 3) {
            bEnviar = new Button("Enviar");
            bBuscar = new Button("Buscar");
            l1 = new Label("     INSCRIPCION DE VIAJERO");
            l2 = new Label("     BUSQUEDA POR CEDULA");
            acciones1();
            prestablecido = true;

        } else {
            bEnviar = new Button(" Crear Destino ");
            bBuscar = new Button(" Elegir ");
            l1 = new Label("     CREACION DE NUEVO DESTINO");
            l2 = new Label("SELECCIONAR DESTINO");
            acciones2();
            prestablecido = false;
        }

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
            } else if (tipos[contador] == "check") {
                CheckBox k = new CheckBox();
                grid.add(k, 1, contador + 1);
            }
            contador++;
        }

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.add(l1, 0, 0);
        grid.add(bEnviar, 1, contador + 1);

        contador2 = contador + 3;
        grid.add(l2, 0, contador2);

        if (prestablecido) {
            grid.add(t1, 0, contador2 + 1);
        } else {
            for (Destino d : Destino.getListaDestinos()) {
                c1.getItems().add(d.getNombre());
            }
            grid.add(c1, 0, contador2 + 1);
        }
        grid.add(bBuscar, 1, contador2 + 1);

    }

    public void acciones1() {

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

                    TextArea txt1;

                    if (!(Persona.verificarCedula(ced))) {
                        Viajero v = new Viajero(ced, nom, visa, 0);
                        MenuViajero.cambiarScena(v);
                        txt1 = new TextArea(v.imprimirDatos());
                        dialog.setHeaderText("CREACION DE NUEVO USUARIO EXITOSA");
                        dialog.getDialogPane().setContent(txt1);
                        dialog.showAndWait();
                    } else {
                        txt1 = new TextArea("La cedula ingresada ya se encuentra registrada en nuestro sistema.");
                        dialog.setHeaderText("ACCIÓN DENEGADA");
                        dialog.getDialogPane().setContent(txt1);
                        dialog.showAndWait();
                    }

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

    public void acciones2() {

        bEnviar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert dialog = new Alert(Alert.AlertType.INFORMATION);
                dialog.setTitle(" SAM-TRAVEL");

                try {

                    String nombre = (String) ((TextField) grid.getChildren().get(1)).getText();
                    int distancia = Integer.parseInt(((TextField) grid.getChildren().get(3)).getText());
                    String choice = (String) ((ChoiceBox) grid.getChildren().get(5)).getValue();
                    Boolean accesoMar = ((CheckBox) grid.getChildren().get(7)).isSelected();
                    Boolean accesoTierra = ((CheckBox) grid.getChildren().get(9)).isSelected();
                    Boolean visa;
                    if (choice.equals("Si")) {
                        visa = true;
                    } else {
                        visa = false;
                    }
                    Destino d = new Destino(nombre, distancia, visa, accesoMar, accesoTierra);
                    MenuDestino.cambiarScena(d);
                    TextArea txt1 = new TextArea(d.imprimirDatos());
                    dialog.setHeaderText("CREACION DE NUEVO DESTINO EXITOSA");
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
                    String choice = (String) ((ChoiceBox) grid.getChildren().get(13)).getValue();
                    Destino d = Destino.devolverDestino(choice);
                    MenuDestino.cambiarScena(d);
                    TextArea txt1 = new TextArea(d.imprimirDatos());
                    dialog.setHeaderText(" DESTINO ENCONTRADO");
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
    }

    public GridPane getGrilla() {
        return grid;
    }

}
