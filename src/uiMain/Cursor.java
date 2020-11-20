package uiMain;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Cursor implements EventHandler<MouseEvent> {

    Inicio control;

    @Override
    public void handle(MouseEvent m) {
        control = new Inicio();
        Object comando = m;
        if (!(comando instanceof ImageView)) {
            control.imageP4 = new Image(getClass().getResourceAsStream("darla.jpg"));
            control.marcoP4.setImage(control.imageP4);
            control.p4.getChildren().add(control.marcoP4);
        }

    }

}
