package iStud.view;

import iStud.model.Etudiant;
import iStud.model.NoteHW;
import iStud.model.NoteTest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Main.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by chawki on 03/12/16.
 */
public class PersonOverviewController {

    @FXML
    private TableView<Etudiant> personTable;
    @FXML
    private TableView<NoteTest> noteTableTest;
    @FXML
    private TableView<NoteHW> noteTableHw;


    @FXML
    private TableColumn<Etudiant, Number> idColumn;
    @FXML
    private TableColumn<Etudiant, String> firstNameColumn;
    @FXML
    private TableColumn<Etudiant, String> lastNameColumn;

    @FXML
    private TableColumn<NoteTest, Number> testColumn;
    @FXML
    private TableColumn<NoteHW, Number> homeWorkColumn;

    @FXML
    private Label pointLabel;
    @FXML
    private Label examenLabel;

    @FXML
    private Label ccLabel;
    @FXML
    private Label moyenneLabel;

    @FXML
    private Label remarqueLabel;


    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label idLabel;
    @FXML
    private Label sexeLabel;
    @FXML
    private Label absenceLabel;
    @FXML
    private Label birthdayLabel;


    private Connexion cnx = new Connexion();
    private DecimalFormat df = new DecimalFormat("##.##");

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonOverviewController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
//    @FXML
//    private void initialize() {
//        // Initialize the person table with the two columns.
//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
//        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
//    }
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.


        idColumn.setCellValueFactory(
                cellData -> cellData.getValue().idProperty());
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().nomProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().prenomProperty());
        initTableNote();

        // Clear person details.
        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));

    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param
     */

    //methode pour afficher la liste des etudiant
    private void setdataEtudiant() {

        // Add observable list data to the table
        cnx.getDataEtudiant();
        personTable.setItems(ListeEtudiant.getPersonData());

    }

    //methode pour afficher les note pour chaque etudiant
    private void setDataNote(int id) {
        cnx.getNoteEtudiant(id);
        noteTableTest.setItems(ListeEtudiant.getPersonDataNoteTest());
        noteTableHw.setItems(ListeEtudiant.getPersonDataNoteHW());
        ccLabel.setText(String.valueOf(df.format(cnx.moyCC(id))));
        moyenneLabel.setText(String.valueOf(df.format(cnx.moyT(id))));
        if (cnx.moyT(id) < 10) {
            remarqueLabel.setText("AJOURNÉ");
        } else remarqueLabel.setText("ADMIS");
        noteTableTest.refresh();
        noteTableHw.refresh();
    }


    //methode dinitialisation des tableux des note pour chaque etudiant
    private void initTableNote() {
        testColumn.setCellValueFactory(cellData -> cellData.getValue().testProperty());
        homeWorkColumn.setCellValueFactory(cellData -> cellData.getValue().homeWorkProperty());
    }

    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */

    //affiche les detaile de chque etudiant
    private void showPersonDetails(Etudiant person) {
        if (person != null) {
            // Fill the labels with info from the person object.
            idLabel.setText(Integer.toString(person.getId()));
            nomLabel.setText(person.getNom());
            prenomLabel.setText(person.getPrenom());
            sexeLabel.setText(person.getSexe());
            birthdayLabel.setText(person.getDateNaissance());
            absenceLabel.setText(Integer.toString(person.getAbsence()));
            examenLabel.setText(Double.toString(person.getExamen()));
            pointLabel.setText(Double.toString(person.getPointPlus()));
            setDataNote(person.getId());


        } else {
            // Person is null, remove all the text.
            idLabel.setText("");
            nomLabel.setText("");
            prenomLabel.setText("");
            sexeLabel.setText("");
            absenceLabel.setText("");
            birthdayLabel.setText("");
            pointLabel.setText("");
            examenLabel.setText("");
            ccLabel.setText("");
            moyenneLabel.setText("");
            remarqueLabel.setText("");
        }
    }


    /**
     * Called when the user clicks on the delete button.
     */
    //suprimer un etudiant a partire de la liste
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        Etudiant select = personTable.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            cnx.suppresion(select.getId());
            setdataEtudiant();
            personTable.refresh();

        } else {
            generateMessageErreurNotSelected();
        }


    }

    //supprimer note test
    @FXML
    private void handleDeleteNoteTest() {
        int selectedIndex = noteTableTest.getSelectionModel().getSelectedIndex();
        NoteTest select = noteTableTest.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            cnx.subNotetest(select.getId());
            setdataEtudiant();
            noteTableTest.getItems().remove(selectedIndex);

        } else {
            generateMessageErreurNotSelected();
        }


    }

    //supprimer note hw
    @FXML
    private void handleDeleteNoteHW() {
        int selectedIndex = noteTableHw.getSelectionModel().getSelectedIndex();
        NoteHW select = noteTableHw.getSelectionModel().getSelectedItem();
        if (selectedIndex >= 0) {
            cnx.subNoteHW(select.getId());
            setdataEtudiant();
            noteTableHw.getItems().remove(selectedIndex);

        } else {
            generateMessageErreurNotSelected();
        }


    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    //ajouter un nouveau etudiant
    @FXML
    private void handleNewPerson() {
        Etudiant tempPerson = new Etudiant();
        boolean okClicked = PersonEditDialogController.showPersonEditDialog(tempPerson);
        if (okClicked) {
            ListeEtudiant.getPersonData().add(tempPerson);
            cnx.insertion(tempPerson);
            initialize();
            setdataEtudiant();

        }
    }

    //ajouter note test
    @FXML
    private void handleNewNoteTest() {
        NoteAddController.setChoix("test");
        NoteTest note = new NoteTest();
        Etudiant select = personTable.getSelectionModel().getSelectedItem();
        if (select != null) {
            boolean okClicked = NoteAddController.showNoteEditDialogTest(note);

            if (okClicked) {
                ListeEtudiant.getPersonDataNoteTest().add(note);
                cnx.insertionNoteCC(note, select.getId());
                initialize();
                setDataNote(select.getId());
            }
        } else generateMessageErreurNotSelected();
    }

    @FXML
    //ajouter note homework
    private void handleNewNoteHW() {
        NoteAddController.setChoix("hw");
        NoteHW note = new NoteHW();
        Etudiant select = personTable.getSelectionModel().getSelectedItem();
        if (select != null) {
            boolean okClicked = NoteAddController.showNoteEditDialogHw(note);
            if (okClicked) {
                cnx.insertionNoteHW(note, select.getId());
                setDataNote(select.getId());

            }
        } else generateMessageErreurNotSelected();
    }

    @FXML
    private void abssence() {
        Etudiant selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            cnx.insertAbsence(selectedPerson.getId());
            setdataEtudiant();
        } else {
            generateMessageErreurNotSelected();

        }


    }

    @FXML
    private void insertExamen() {
        NoteAddController.setChoix("test");
        NoteTest note = new NoteTest();
        Etudiant select = personTable.getSelectionModel().getSelectedItem();
        if (select != null) {
            boolean okClicked = NoteAddController.showNoteEditDialogTest(note);
            if (okClicked) {
                cnx.insertionNoteExamen(note.getTest(), select.getId());
                initialize();
                setdataEtudiant();
            }
        } else generateMessageErreurNotSelected();


    }

    @FXML
    private void insertPointPlus() {
        NoteAddController.setChoix("point");
        NoteTest note = new NoteTest();
        Etudiant select = personTable.getSelectionModel().getSelectedItem();
        if (select != null) {
            boolean okClicked = NoteAddController.showNoteEditDialogTest(note);
            if (okClicked) {
                cnx.insertionPP(note.getTest(), select.getId());
                initialize();
                setdataEtudiant();
            }
        } else generateMessageErreurNotSelected();


    }

    private void generateMessageErreurNotSelected() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.initOwner(Main.getPrimaryStage());
        alert.setTitle("No Selection");
        alert.setHeaderText("No Person Selected");
        alert.setContentText("SVP ! selectioner une personne ");

        alert.showAndWait();
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    //modifier les info principale d'un etudiant
    @FXML
    private void handleEditPerson() {
        Etudiant selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = PersonEditDialogController.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                cnx.updateEtudiant(selectedPerson, selectedPerson.getId());
                showPersonDetails(selectedPerson);
            }

        } else {
            generateMessageErreurNotSelected();
        }
    }


    //methode principal pour lencer l'interface
    public static void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PersonOverviewController.class.getResource("PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            RootLayoutControl.getRootLayout().setCenter(personOverview);


            // Give the controller access to the main app.
            PersonOverviewController controller = loader.getController();
            controller.setdataEtudiant();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void retour() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
        Main.getPrimaryStage().close();
        Main.setPrimaryStage(new Stage());
        Main.getPrimaryStage().setScene(new Scene(root));
        Main.getPrimaryStage().setResizable(false);
        Main.getPrimaryStage().setAlwaysOnTop(true);
        Main.getPrimaryStage().setTitle("iStud");
        Main.getPrimaryStage().show();

    }

}
