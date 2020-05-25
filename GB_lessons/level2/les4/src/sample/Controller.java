package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.fxml.FXML;

public class Controller {
    @FXML
    private Button btn1;

    @FXML
    protected void onClick(ActionEvent event){
            btn1.setId();
            event.getTarget();

    }
}
