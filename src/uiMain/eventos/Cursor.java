package uiMain.eventos;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uiMain.Main;
import uiMain.Start;
import javafx.scene.layout.VBox;
import static uiMain.Main.altoGrid;
import static uiMain.Main.anchoGrid;
import static uiMain.Start.marco1;
import static uiMain.Start.marco2;
import static uiMain.Start.marco3;
import static uiMain.Start.marco4;
import static uiMain.Start.marco5;
import static uiMain.Start.marco6;
import static uiMain.Start.marco7;
import static uiMain.Start.marco8;
import static uiMain.Start.p6;

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
        if (comando instanceof VBox) {
            if (comando.equals(Start.p5) && Start.p5.getChildren().get(0) == Start.hdv1) {                
                Start.p5.getChildren().clear();   
                p6.getChildren().clear();
                Start.p5.getChildren().add(Start.hdv2);                
                p6.setPrefSize(anchoGrid, altoGrid);
                p6.setAlignment(Pos.CENTER);
                p6.setVgap(5);
                p6.setHgap(5);
                p6.add(marco1, 0, 0);
                p6.add(marco2, 0, 1);
                p6.add(marco3, 1, 0);
                p6.add(marco4, 1, 1);
               
            } else {
                Start.p5.getChildren().clear();
                Start.p5.getChildren().add(Start.hdv1);
                p6.setPrefSize(anchoGrid, altoGrid);
                p6.setAlignment(Pos.CENTER);
                p6.setVgap(5);
                p6.setHgap(5);
                p6.add(marco5, 0, 0);
                p6.add(marco6, 0, 1);
                p6.add(marco7, 1, 0);
                p6.add(marco8, 1, 1);
                
            }

        }

    }

}
