package Main;

import iStud.model.Etudiant;


import iStud.model.NoteHW;
import iStud.model.NoteTest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by chawki on 07/12/16.
 */
public class ListeEtudiant {

    private static ObservableList<Etudiant> personData = FXCollections.observableArrayList();
    private static ObservableList<NoteTest> personDataNoteTest = FXCollections.observableArrayList();
    private static ObservableList<NoteHW> personDataNoteHW = FXCollections.observableArrayList();


    public static ObservableList<Etudiant> getPersonData() {
        return personData;
    }


    public static void setPersonData(ObservableList<Etudiant> personData) {
        ListeEtudiant.personData = personData;
    }

    public static ObservableList<NoteTest> getPersonDataNoteTest() {
        return personDataNoteTest;
    }

    public static void setPersonDataNoteTest(ObservableList<NoteTest> personDataNoteTest) {
        ListeEtudiant.personDataNoteTest = personDataNoteTest;
    }

    public static ObservableList<NoteHW> getPersonDataNoteHW() {
        return personDataNoteHW;
    }

    public static void setPersonDataNoteHW(ObservableList<NoteHW> personDataNoteHW) {
        ListeEtudiant.personDataNoteHW = personDataNoteHW;
    }
}
