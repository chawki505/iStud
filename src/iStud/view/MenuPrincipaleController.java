package iStud.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dell on 05/01/2017.
 */
public class MenuPrincipaleController {

    @FXML
    private Label UserAcc;


    @FXML
    private void Menuetudiant() {
        RootLayoutControl.initRootLayout();
        PersonOverviewController.showPersonOverview();
    }

    @FXML
    public void ToConnexion(ActionEvent actionEvent) throws IOException{
        Parent page = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToMenuUser(ActionEvent actionEvent) throws IOException{
        Parent page = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToBonus(ActionEvent actionEvent) throws IOException{
        Parent page = FXMLLoader.load(getClass().getResource("BonusA.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

}
