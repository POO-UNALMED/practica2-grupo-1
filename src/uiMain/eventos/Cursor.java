package uiMain.eventos;

import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uiMain.Main;
import uiMain.Start;

public class Cursor implements EventHandler<MouseEvent> {

    static int noFoto = 1;

    @Override
    public void handle(MouseEvent m) {

        Object comando = m.getSource();

        if ((comando instanceof ImageView)) {

            Image imagen;
            if (noFoto == 1) {
                imagen = new Image("BaseDatos/2.jpg");
                noFoto = 3;
            } else if (noFoto < 6) {
                imagen = new Image("BaseDatos/" + (Integer.toString(noFoto) + ".jpg"));
                noFoto++;
            } else {
                noFoto = 1;
                imagen = new Image("BaseDatos/1.jpg");
                noFoto++;
            }

            ImageView marcoNuevo = new ImageView(imagen);
            marcoNuevo.setFitHeight(Main.altoGrid - 30);
            marcoNuevo.setFitWidth(Main.anchoGrid);
            Start.marcoP4 = marcoNuevo;
            Start.marcoP4.setImage(imagen);
            Start.marcoP4.setOnMouseExited(Start.cursorHandler);
            Start.p4.getChildren().clear();
            Start.p4.getChildren().addAll(Start.marcoP4, Start.bInicio);
        }
        if (comando instanceof TextArea) {
            TextArea t = (TextArea) comando;
            if (t.equals(Start.hoja1)) {
                Start.p5.getChildren().clear();
                Start.p5.getChildren().add(Start.hoja2);
            } else if (t.equals(Start.hoja2)) {
                Start.p5.getChildren().clear();
                Start.p5.getChildren().add(Start.hoja1);
            }

        }

    }

}
