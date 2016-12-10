package iStud.view;

import Main.Main;
import iStud.model.Etudiant;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * Created by chawki on 04/12/16.
 */
public class PersonEditDialogController {
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField sexeField;
    @FXML
    private TextField birthdayField;


    private Stage dialogStage;
    private Etudiant etudiant;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the etudiant to be edited in the dialog.
     *
     * @param etudiant
     */
    public void setEtudiant(Etudiant etudiant ) {
        this.etudiant = etudiant;

        firstNameField.setText(etudiant.getNom());
        lastNameField.setText(etudiant.getPrenom());
        sexeField.setText(etudiant.getSexe());
        birthdayField.setText(etudiant.getDateNaissance());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            etudiant.setNom(firstNameField.getText());
            etudiant.setPrenom(lastNameField.getText());
            etudiant.setSexe(sexeField.getText());
            etudiant.setDateNaissance(birthdayField.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }


        if (sexeField.getText() == null || sexeField.getText().length() == 0) {
            errorMessage += "No valid sexe!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    public static boolean showPersonEditDialog(Etudiant person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PersonEditDialogController.class.getResource("PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the etudiant into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEtudiant(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
