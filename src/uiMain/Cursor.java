package uiMain;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Cursor implements EventHandler<MouseEvent> {
    
    static int noFoto = 1;
    
    @Override
    public void handle(MouseEvent m) {
        
        ImageView comandoIm = (ImageView)m.getSource();
        
        if ((comandoIm instanceof ImageView)) {
            
            Image imagen;
            if(noFoto==1){
                imagen = new Image(getClass().getResourceAsStream("2.jpg"));
                noFoto = 3;
            }
            else if(noFoto<6){
                imagen = new Image(getClass().getResourceAsStream(Integer.toString(noFoto) + ".jpg"));
                noFoto++;
            }
            else{
                noFoto = 1;
                imagen = new Image(getClass().getResourceAsStream("1.jpg"));
                noFoto++;
            }
            
            ImageView marcoNuevo = new ImageView(imagen);
            marcoNuevo.setFitHeight(Inicio.altoGrid - 30);
            marcoNuevo.setFitWidth(Inicio.anchoGrid);     
            Inicio.marcoP4 = marcoNuevo;
            Inicio.marcoP4.setImage(imagen);
            Inicio.marcoP4.setOnMouseExited(Inicio.cursorHandler);
            Inicio.p4.getChildren().clear();
            Inicio.p4.getChildren().addAll(Inicio.marcoP4,Inicio.bInicio);
        }

    }

}
