package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by chawki on 25/11/16.
 */
public class DBNote extends DBConnection {


    //insert une note CC pour un etudiant
    public boolean insertnoteCC(double note, int cle) {
        if (!isEtat())
            return false;
        try {

            PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO " +
                    "TEST(VALEUR,CLE) VALUES (" + note + "," + cle + ")");

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
            return false;
        }
        return true;
    }

    //insert note hw
    public boolean insertnoteHommeWork(double note, int cle) {
        if (!isEtat())
            return false;
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(
                    "INSERT INTO HOMMEWORK(VALEUR,CLE ) VALUES (?,?)");
            preparedStatement.setDouble(1, note);
            preparedStatement.setInt(2, cle);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            System.out.println("ERREUR insertion impossible ");
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
