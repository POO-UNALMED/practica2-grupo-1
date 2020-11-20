package uiMain;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import uiMain.Inicio.*;

public class Presion implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent e) {
        Object comando = e.getSource();
        if (comando instanceof MenuItem) {
            if (((MenuItem) comando).getText().equals("Salir")) {
                Main.window.close();
            }
            else if (((MenuItem) comando).getText().equals("Descripcion") && Inicio.txt1.getText().equals(Inicio.saludo)) {
                Inicio.txt1.setText(Inicio.descripcion);
                Inicio.menuDescripcion.setText("Saludo");
            }else {
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

}
