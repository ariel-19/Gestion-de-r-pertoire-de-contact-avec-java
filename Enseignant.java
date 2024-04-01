package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Enseignant extends Contact {
    private String statut;

    public Enseignant(String code, String nom, String string, String adresse, String email, String telNumber, String statut) {
        super(code, nom, string, adresse, email, telNumber);
        this.statut = statut;
    }

    // Getters et setters
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    public void insertIntoDatabase(Connection connection) throws SQLException {
        // Préparation de la requête SQL
        String sql = "INSERT INTO VOTRE_TABLE (code, nom, date_naissance, adresse, email, tel_number, cycle, niveau) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

        // Remplissage des valeurs des paramètres
        statement.setString(1, getCode());
        statement.setString(2, getNom());
        statement.setDate(3, new java.sql.Date(getDateNaissance().getTime()));
        statement.setString(4, getAdresse());
        statement.setString(5, getEmail());
        statement.setString(6, getTelNumber());
        statement.setString(7, getStatut());

        // Exécution de la requête
        statement.executeUpdate();

        // Fermeture du PreparedStatement
        closeStatement(statement);
    }
}

    