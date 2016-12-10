package ch.makery.address.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by chawki on 09/12/16.
 */
public class Etudiant {

    private final IntegerProperty id;
    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty sexe;
    private final StringProperty dateNaissance;
    private final IntegerProperty absence;
    private final DoubleProperty examen;
    private final DoubleProperty pointPlus;


    public Etudiant() {
        this(0, null, null, null, null, 0, 0, 0);
    }

    public Etudiant(int id, String nom, String prenom, String date, String sexe, int absence, double examen, double point) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.sexe = new SimpleStringProperty(sexe);
        this.dateNaissance = new SimpleStringProperty(date);
        this.absence = new SimpleIntegerProperty(absence);
        this.examen = new SimpleDoubleProperty(examen);
        this.pointPlus = new SimpleDoubleProperty(point);

    }


    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getSexe() {
        return sexe.get();
    }

    public StringProperty sexeProperty() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe.set(sexe);
    }

    public String getDateNaissance() {
        return dateNaissance.get();
    }

    public StringProperty dateNaissanceProperty() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance.set(dateNaissance);
    }

    public int getAbsence() {
        return absence.get();
    }

    public IntegerProperty absenceProperty() {
        return absence;
    }

    public void setAbsence(int absence) {
        this.absence.set(absence);
    }

    public double getExamen() {
        return examen.get();
    }

    public DoubleProperty examenProperty() {
        return examen;
    }

    public void setExamen(double examen) {
        this.examen.set(examen);
    }

    public double getPointPlus() {
        return pointPlus.get();
    }

    public DoubleProperty pointPlusProperty() {
        return pointPlus;
    }

    public void setPointPlus(double pointPlus) {
        this.pointPlus.set(pointPlus);
    }

}
