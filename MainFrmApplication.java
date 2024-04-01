package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainFrmApplication {
   
    Connection connection;

    public static void main(String[] args) {
        MainFrmApplication app = new MainFrmApplication();
        app.initializeConnection();
    }

    public void initializeConnection() {
        String url = "jdbc:mysql://localhost:3306/repertoire_contacts";
        String user = "root";
        String password = "came2003";
        try {
            // Chargement du pilote JDBC MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Établissement de la connexion à la base de données
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion établie !");
        } catch (ClassNotFoundException e) {
            System.err.println("Le pilote JDBC MySQL n'a pas été trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Méthode pour enregistrer les contacts dans la base de données
    public void enregistrer(Repertoire repertoire) {
        try {
            for (Contact contact : repertoire.getListeContacts()) {
                contact.insertIntoDatabase(connection);
            }
            System.out.println("Tous les contacts ont été enregistrés dans la base de données.");
        } catch (SQLException e) {
            System.err.println("Erreur lors de l'enregistrement des contacts dans la base de données : " + e.getMessage());
        }
    }
}
