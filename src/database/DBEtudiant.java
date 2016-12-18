package database;

import Main.ListeEtudiant;
import iStud.model.Etudiant;
import iStud.model.NoteHW;
import iStud.model.NoteTest;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chawki on 25/11/16.
 */
public class DBEtudiant extends DBConnection {


    //pour inseret un etudiant
    public boolean insertEtudiant(Etudiant etudiant) {
        if (!isEtat())
            return false;

        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO ETUDIANT" +
                    "(NOM,PRENOM,DATEDENAISSENCE,SEXE,POINTPlus,ABSENCE,EXAMEN) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getDateNaissance());
            preparedStatement.setString(4, etudiant.getSexe());
            preparedStatement.setDouble(5, etudiant.getPointPlus());
            preparedStatement.setInt(6, etudiant.getAbsence());
            preparedStatement.setDouble(7, etudiant.getExamen());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;

    }

    //pour metre a jour ou modifier un etudiant
    public boolean updateEtudiant(Etudiant etudiant, int id) {
        if (!isEtat())
            return false;

        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE  ETUDIANT SET " +
                    "NOM=?,PRENOM=?,DATEDENAISSENCE=?,SEXE=? WHERE ID=" + id);
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getDateNaissance());
            preparedStatement.setString(4, etudiant.getSexe());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("ERREUR update impossible ");
            return false;
        }
        return true;

    }


    public boolean getNoteEtudiantTest(int id) {
        if (!isEtat()) {
            return false;
        }
        ListeEtudiant.getPersonDataNoteTest().clear();


        try {

            ResultSet resultSet = query("SELECT *FROM ETUDIANT,TEST " +
                    "WHERE TEST.CLE=" + id + " AND " +
                    "ETUDIANT.ID=" + id);
            while (resultSet.next()) {

                ListeEtudiant.getPersonDataNoteTest().add(new NoteTest(resultSet.getDouble(10), resultSet.getInt(9)));

            }
            resultSet.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    public boolean getNoteEtudiantHW(int id) {
        if (!isEtat()) {
            return false;
        }

        ListeEtudiant.getPersonDataNoteHW().clear();

        try {

            ResultSet resultSet = query("SELECT *FROM ETUDIANT,HOMMEWORK " +
                    "WHERE HOMMEWORK.CLE=" + id + " AND " +
                    "ETUDIANT.ID=" + id);
            while (resultSet.next()) {
                ListeEtudiant.getPersonDataNoteHW().add(new NoteHW(resultSet.getDouble(10), resultSet.getInt(9)));
            }
            resultSet.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    public boolean getDataEtudiant() {

        ListeEtudiant.getPersonData().clear();
        if (!isEtat()) {
            return false;
        }
        int id, absence;
        double examen, pointplus;
        String nom, prenom, date, sexe;
        try {
            ResultSet resultSet = query("SELECT * FROM ETUDIANT");
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                nom = resultSet.getString(2);
                prenom = resultSet.getString(3);
                date = resultSet.getString(4);
                sexe = resultSet.getString(5);
                pointplus = resultSet.getDouble(6);
                absence = resultSet.getInt(7);
                examen = resultSet.getDouble(8);

                ListeEtudiant.getPersonData().add(new Etudiant(id, nom, prenom, date, sexe, absence, examen, pointplus));
            }
            resultSet.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    //suprimer un etudiant avec son id
    public boolean supprimerID(int id) {
        if (!isEtat())
            return false;
        try {
            setStatement(getConnection().createStatement());
            getStatement().executeUpdate("DELETE FROM HOMMEWORK WHERE CLE=" + id);
            getStatement().executeUpdate("DELETE FROM TEST WHERE CLE=" + id);
            getStatement().executeUpdate("DELETE FROM ETUDIANT WHERE ID=" + id);

            getStatement().close();
            getConnection().close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //incremente le compteur des absence +1
    public boolean insertAbsence(int id) {
        if (!isEtat())
            return false;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT SET " +
                    "ABSENCE=ABSENCE+1 WHERE ID=" + id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    public boolean edit(int id, String x, int choix) {
        if (!isEtat()) return false;
        try {
            PreparedStatement preparedStatement = null;
            switch (choix) {
                case 1:
                    preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT" +
                            " SET NOM=" + x + " WHERE ID=" + id);
                    break;

                case 2:
                    preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT" +
                            " SET PRENOM=" + x + " WHERE ID=" + id);

                    break;
                case 3:
                    preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT" +
                            " SET SEXE=" + x + " WHERE ID=" + id);
                    break;


            }
            assert preparedStatement != null;
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }


}

