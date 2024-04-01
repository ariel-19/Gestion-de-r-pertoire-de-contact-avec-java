package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Contact {
    private String code; 
    private String nom; 
    private Date dateNaissance; 
    private String adresse; 
    private String email; 
    private String telNumber; 

    public Contact(String code, String nom, String string, String adresse, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.dateNaissance = string;
        this.adresse = adresse;
        this.email = email;
        this.telNumber = telNumber;
    }

    // Getters et setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    // Méthode pour insérer un contact dans la base de données
    public void insertIntoDatabase(Connection connection) throws SQLException {
        // Préparation de la requête SQL
        String sql = "INSERT INTO VOTRE_TABLE (code, nom, date_naissance, adresse, email, tel_number) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        // Remplissage des valeurs des paramètres
        statement.setString(1, getCode());
        statement.setString(2, getNom());
        statement.setDate(3, new java.sql.Date(getDateNaissance().getTime()));
        statement.setString(4, getAdresse());
        statement.setString(5, getEmail());
        statement.setString(6, getTelNumber());

        // Exécution de la requête
        statement.executeUpdate();

        // Fermeture du PreparedStatement
        closeStatement(statement);
    }

    // Méthode utilitaire pour fermer un PreparedStatement
    public void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Gérer l'exception selon votre logique
            }
        }
    }
}
