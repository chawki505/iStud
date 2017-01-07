package iStud.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Imed on 06/01/2017.
 */

public class BonusController {

    @FXML
    public void ToMICINY(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MenuBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToImedBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("ImedBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToMohamedBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MohamedBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToIbtissemBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("IbtissemBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToYassminBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("YassmineBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToMenuBonus(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("BonusA.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToiStud(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("iStudBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToMenuP(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MenuPrincipale.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

    @FXML
    public void ToMenuBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("MenuBio.fxml"));
        Scene scene = new Scene(page);
        Stage app_stage=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.show();
    }

}
