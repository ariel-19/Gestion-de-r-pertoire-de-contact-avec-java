package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Etudiant extends Contact {
    private String cycle;
    private int niveau;

    public Etudiant(String code, String nom, Date dateNaissance, String adresse, String email, String telNumber, String cycle, int niveau) {
        super(code, nom, dateNaissance, adresse, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public void insertIntoDatabase(Connection connection) throws SQLException {
        // Préparation de la requête SQL
        String sql = "INSERT INTO VOTRE_TABLE (code, nom, date_naissance, adresse, email, tel_number, cycle, niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Remplissage des valeurs des paramètres
        statement.setString(1, getCode());
        statement.setString(2, getNom());
        statement.setDate(3, new java.sql.Date(getDateNaissance().getTime()));
        statement.setString(4, getAdresse());
        statement.setString(5, getEmail());
        statement.setString(6, getTelNumber());
        statement.setString(7, getCycle());
        statement.setInt(8, getNiveau());

        // Exécution de la requête
        statement.executeUpdate();

        // Fermeture du PreparedStatement
        closeStatement(statement);
    }
}
