package database;


import java.sql.*;

/**
 * Created by chawki on 15/11/16.
 */

public class DBConnection {

    private static Connection connection;
    private static Statement statement;
    private static boolean etat;
    private static String bdd;

    /**
     * constructeur
     **/

    public DBConnection(String bdd) {
        DBConnection.bdd = bdd;
        etat = false;

    }

    public DBConnection() {
//        bdd = "iStud.db";
//        etat = false;

    }

    /**
     * GETTERS / SETTERS
     */

    public boolean isEtat() {
        return etat;
    }

    public String getBdd() {
        return bdd;
    }

    public Statement getStatement() {
        return statement;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setStatement(Statement statement) {
        DBConnection.statement = statement;
    }

    public void setEtat(boolean etat) {
        DBConnection.etat = etat;
    }

    public void setConnection(Connection connection) {
        DBConnection.connection = connection;
    }

    public void setBdd(String bdd) {
        DBConnection.bdd = bdd;
    }


    /**
     * Methode pour la connection avec la base de données
     **/

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + bdd);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            etat = false;
        }
        etat = true;
    }

    /**
     * Methode pour la creation de la table dans la base de données
     * WARNING : elle se fait une seule fois
     *
     * @return Etat de l'execution de la methode
     */

    public boolean contract() {

        if (!etat)
            return false;

        try {
            statement = connection.createStatement();
            //table des etudiant
            String sql = "CREATE TABLE ETUDIANT " +
                    "(ID INTEGER  PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL ," +
                    " NOM           TEXT    NOT NULL, " +
                    " PRENOM            TEXT     NOT NULL, " +
                    " DATEDENAISSENCE TEXT NOT NULL ," +
                    " SEXE TEXT NOT NULL," +
                    " POINTPlus REAL NOT NULL," +
                    " ABSENCE INTEGER NOT NULL," +
                    " EXAMEN REAL NOT NULL );";

            //table des note cc
            String sql2 = "CREATE TABLE TEST " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL ," +
                    "VALEUR REAL NOT NULL ," +
                    "CLE  INTEGER NOT NULL," +
                    "FOREIGN KEY (CLE) REFERENCES ETUDIANT(ID)" +
                    ");";

            //table des note homework
            String sql3 = "CREATE TABLE HOMMEWORK " +
                    "(ID INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL ," +
                    "VALEUR REAL NOT NULL ," +
                    "CLE  INTEGER NOT NULL," +
                    "FOREIGN KEY (CLE) REFERENCES ETUDIANT(ID) " +
                    ");";

            statement.executeUpdate(sql); //exection de la requete 1
            statement.executeUpdate(sql2);//exection de la requete 2
            statement.executeUpdate(sql3);//exection de la requete 3


            statement.close();//fin des requetes
            connection.close();//fermer la connexion de la bdd
        } catch (SQLException e) {
            System.out.println("table deja creer !");
            return false;
        }
        return true;
    }


    /**
     * methode pour executer les requet dans la base de donnee
     **/
    public ResultSet query(String requet) {
        ResultSet resultat = null;
        try {
            statement = connection.createStatement();
            resultat = statement.executeQuery(requet);
        } catch (SQLException e) {
            System.out.println("Erreur dans la requet : " + requet);
        }
        return resultat;

    }


    //supprimer toute la base de donnes
    public boolean viderbdd() {
        if (!etat)
            return false;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM HOMMEWORK");
            statement.executeUpdate("DELETE FROM TEST");
            statement.executeUpdate("DELETE FROM ETUDIANT");
            statement.executeUpdate("UPDATE sqlite_sequence SET seq=0");

            statement.close();
            connection.close();
        } catch (SQLException e) {

            return false;
        }
        return true;
    }


    //calcule moy des test
    public double calculMoyTest(int id) {
        if (!etat) {
            return 0;
        }
        double moy;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = query("SELECT " +
                    "AVG(VALEUR) FROM TEST WHERE CLE=" + id);


            moy = resultSet.getDouble(1);
            resultSet.close();


        } catch (SQLException e) {
            return 0;
        }
        return moy;

    }

    //calcule moy des hw
    public double calculMoyHW(int id) {
        if (!etat) {
            return 0;
        }
        double moy = 0;
        try {
            ResultSet resultSet = query("SELECT avg(VALEUR) " +
                    "FROM HOMMEWORK WHERE CLE=" + id);
            moy = resultSet.getDouble(1);
            resultSet.close();
        } catch (SQLException e) {
            return 0;
        }
        return moy;

    }


    //calcule moyenne du cc
    public double calculMoyCC(int id) {

        return (calculMoyTest(id) + calculMoyHW(id)) / 2;
    }

    //recuperer la note Examen dun etudiant
    private double getNoteExamen(int id) {
        if (!etat)
            return 0;
        double note;
        try {
            ResultSet resultSet = query("SELECT " +
                    "EXAMEN FROM ETUDIANT WHERE ID=" + id);
            note = resultSet.getDouble(1);
            resultSet.close();
        } catch (SQLException e) {
            return 0;
        }
        return note;
    }


    //calcule moyennne general
    public double calculMoyT(int id) {
        return (getNoteExamen(id) * 0.6) + (calculMoyCC(id) * 0.4);

    }
}
