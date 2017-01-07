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
 * Created by Imed on 06/01/2017.
 */

public class BonusController {

    @FXML
    public void ToMICINY(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Menu/MenuBio.fxml"));
        passage(actionEvent, page);
    }


    @FXML
    private void ToChawkiBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/chawkiBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToImedBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/ImedBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToMohamedBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/mohamedBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToIbtissemBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/IbtissemBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToYassminBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/YassmineBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToMenuBonus(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Menu/BonusA.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToiStud(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Bio/iStudBio.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    public void ToMenuP(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Menu/MenuPrincipale.fxml"));
        passage(actionEvent, page);
    }

    @FXML
    private void ToMenuBio(ActionEvent actionEvent) throws IOException {
        Parent page = FXMLLoader.load(getClass().getResource("/iStud/view/Menu/MenuBio.fxml"));
        passage(actionEvent, page);
    }

    private void passage(ActionEvent actionEvent, Parent page) {
        Scene scene = new Scene(page);
        Stage app_stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        app_stage.setScene(scene);
        app_stage.centerOnScreen();
        app_stage.show();
    }
}
