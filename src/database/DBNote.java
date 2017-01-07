package database;

import iStud.model.NoteHW;
import iStud.model.NoteTest;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by chawki on 25/11/16.
 */

public class DBNote extends DBConnection {


    //insert une note CC pour un etudiant
    public boolean insertnoteCC(NoteTest note, int cle) {
        if (!isEtat())
            return false;
        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO " +
                    "TEST(VALEUR,CLE) VALUES (?,?)");
            preparedStatement.setDouble(1, note.getTest());
            preparedStatement.setInt(2, cle);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;
    }

    //suprimer une note test
    public boolean supNoteTest(int id) {
        if (!isEtat()) {
            return false;
        }
        try {
            setStatement(getConnection().createStatement());
            getStatement().executeUpdate("DELETE FROM TEST WHERE ID=" + id);
            getStatement().close();
            getConnection().close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //insert note hw
    public boolean insertnoteHommeWork(NoteHW note, int cle) {
        if (!isEtat())
            return false;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "INSERT INTO HOMMEWORK(VALEUR,CLE ) VALUES (?,?)");
            preparedStatement.setDouble(1, note.getHomeWork());
            preparedStatement.setInt(2, cle);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;

    }

    //suprimer une note test
    public boolean supNoteHW(int id) {
        if (!isEtat()) {
            return false;
        }
        try {
            setStatement(getConnection().createStatement());
            getStatement().executeUpdate("DELETE FROM HOMMEWORK WHERE ID=" + id);
            getStatement().close();
            getConnection().close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    //rajoute le point en plus pour un etudiant
    public boolean insertPointPlus(double point, int id) {
        if (!isEtat()) return false;
        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT SET" +
                    " POINTPlus=POINTPlus+" + point + " WHERE ID=" + id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;
    }

    //inseret un note getNoteExamen
    public boolean insertExamen(double note, int id) {
        if (!isEtat()) {
            return false;
        }
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement("UPDATE ETUDIANT SET " +
                    "EXAMEN=" + note + " WHERE ID=" + id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;
    }

}
