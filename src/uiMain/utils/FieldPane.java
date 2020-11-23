package uiMain.utils;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author SAM
 */
public class FieldPane extends Pane {
        
        GridPane grid;
        
    public FieldPane(String[] campos){
        
        grid = new GridPane();
        Button b1 = new Button("Enviar");
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        int contador = 0;
        
        for (String s : campos){
            
            Label l = new Label(s);
            TextField t = new TextField();
            grid.add(l, 0, contador);
            grid.add(t,1,contador);
            contador ++;
            
        }
        grid.add(b1,1,contador);
        
        
    }

    
    public GridPane getGrilla(){
        return grid;
    }
}
