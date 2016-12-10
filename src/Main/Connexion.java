package Main;

import ch.makery.address.model.Etudiant;

import database.DBConnection;
import database.DBEtudiant;
import database.DBNote;


/**
 * Created by chawki on 16/11/16.
 */

public class Connexion {


    private DBConnection dbConnection = new DBConnection("iStud.db");
    private DBEtudiant dbEtudiant = new DBEtudiant();
    private DBNote dbNote = new DBNote();


    //pour etablire la cnx avec la base de donnee
    private void connexion() {
        dbConnection.connect();

        if (dbConnection.isEtat())
            System.out.println("Connection vers SQLITE reussite");
        else
            System.out.println("Echec de la connection vers SQLITE");

    }


    public void getDataEtudiant() {
        connexion();
        boolean get = dbEtudiant.getDataEtudiant();
        if (get) {
            System.out.println("Execution de la recuperation des donnée : SUCCESS");
        } else System.out.println("Execution de la recuperation des donnée : ERROR");
    }

    public void getNoteEtudiant(int id) {
        boolean get1 = dbEtudiant.getNoteEtudiantTest(id);
        boolean get2 = dbEtudiant.getNoteEtudiantHW(id);
        if (get1 && get2) {
            System.out.println("Execution de la recuperation des note : SUCCESS");
        } else System.out.println("Execution de la recuperation des note : ERROR");
    }


    //Creation de la table
    public void creation() {
        connexion();
        boolean contract = dbConnection.contract();

        /*pour creer la table
        EVITER la duplication des tables*/
        if (contract)
            System.out.println("Execution de la creation de la table : SUCCESS");
        else
            System.out.println("Execution de la creation de la table : ERROR");

    }


    //ajouter un nouveau etudiant
    public void insertion(Etudiant etudiant) {
        connexion();
        //pour inserer
        boolean insert = dbEtudiant.insertEtudiant(etudiant);

        if (insert)
            System.out.println("Execution de l'insertion : SUCCESS");
        else
            System.out.println("Execution de l'insertion  : ERROR");


    }

    //update etudiant
    public void updateEtudiant(Etudiant etudiant, int id) {
        connexion();
        boolean update = dbEtudiant.updateEtudiant(etudiant, id);
        if (update)
            System.out.println("Execution de l'insertion : SUCCESS");
        else
            System.out.println("Execution de l'insertion  : ERROR");
    }


    //ajouter note test
    public void insertionNoteCC(double note, int cle) {
        connexion();
        boolean insert = dbNote.insertnoteCC(note, cle);
    }


    //ajouter note hw
    public void insertionNoteHW(double note, int cle) {
        connexion();
        boolean insert = dbNote.insertnoteHommeWork(note, cle);
    }


    //ajouter ou modifier examen
    public void insertionNoteExamen(double note, int cle) {
        connexion();
        boolean insert = dbNote.insertExamen(note, cle);
    }

    //ajouter point plus
    public void insertionPP(double note, int cle) {
        connexion();
        boolean insert = dbNote.insertPointPlus(note, cle);
    }


    //ajouter absence
    public void insertAbsence(int id) {
        connexion();
        boolean insert = dbEtudiant.insertAbsence(id);
    }


    //suprimer une personne
    public void suppresion(int id) {
        connexion();
        boolean sup = dbEtudiant.supprimerID(id);
        if (sup) {
            System.out.println("Execution de la suppression  : SUCCESS");
        } else
            System.out.println("Execution de le suppression  : ERROR");
    }


    //vider la bdd(tous suprimer)
    public void viderbdd() {
        connexion();
        boolean vide = dbConnection.viderbdd();
        if (vide) {
            System.out.println("Execution de la suppression dans la table : SUCCESS");
        } else
            System.out.println("Execution de le suppression dans la table : ERROR");
    }


    //calcule moyenne cc
    public double moyCC(int id) {
        connexion();
        return dbConnection.calculMoyCC(id);

    }

    //calcule moyenne total
    public double moyT(int id) {
        connexion();
        return dbConnection.calculMoyT(id);
    }


}
