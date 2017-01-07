package iStud.view.Menu;

import Main.Main;
import iStud.model.NoteHW;
import iStud.model.NoteTest;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by chawki on 10/12/16.
 */
public class NoteAddController {

    @FXML
    private TextField noteField;
    private Stage dialogStage;
    private boolean okClicked = false;

    private NoteHW noteHW;
    private NoteTest noteTest;


    private static String choix;


    public NoteHW getNoteHW() {
        return noteHW;
    }

    static void setChoix(String choix) {
        NoteAddController.choix = choix;
    }

    @FXML
    private void initialize() {

    }

    private void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    private boolean isOkClicked() {
        return okClicked;
    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            switch (choix) {
                case "test":
                    noteTest.setTest(Double.parseDouble(noteField.getText()));
                    break;
                case "hw":
                    noteHW.setHomeWork(Double.parseDouble(noteField.getText()));
                    break;
                case "note":
                    noteTest.setTest(Double.parseDouble(noteField.getText()));
                    break;
                case "point":
                    noteTest.setTest(Double.parseDouble(noteField.getText()));
                    break;
                default:
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid chose");
                    alert.setHeaderText("Please correct chose");
                    alert.showAndWait();
                    break;
            }
            okClicked = true;
            dialogStage.close();
        }
    }


    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    private boolean isInputValid() {
        String errorMessage = "";

        if (noteField.getText() == null || noteField.getText().length() == 0) {
            errorMessage += "No valid note!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


    public void setNoteTest(NoteTest note) {
        this.noteTest = note;
        noteField.setText(String.valueOf(noteTest.getTest()));
    }

    public void setNoteHW(NoteHW note) {
        this.noteHW = note;
        noteField.setText(String.valueOf(noteHW.getHomeWork()));
    }


    //menu pour note test
    public static boolean showNoteEditDialogTest(NoteTest note) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NoteAddController.class.getResource("NoteAdd.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Note");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the etudiant into the controller.
            NoteAddController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setNoteTest(note);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    //menu pour note hw
    public static boolean showNoteEditDialogHw(NoteHW note) {

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(NoteAddController.class.getResource("NoteAdd.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Note");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(Main.getPrimaryStage());
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the etudiant into the controller.
            NoteAddController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setNoteHW(note);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}


