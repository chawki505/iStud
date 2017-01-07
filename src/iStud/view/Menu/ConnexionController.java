package iStud.view.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dell on 05/01/2017.
 */
public class ConnexionController {

    @FXML
    private void ToMenuP(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MenuPrincipale.fxml"));
        passage(actionEvent, page);
    }

    static void passage(ActionEvent actionEvent, Parent page) {
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }
}
