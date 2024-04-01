package core;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.sql.PreparedStatement;

public class Agent extends Contact {
    private int salaire;
    private String statut;
    private String categorie;
    private int indiceSalaire;
    private String occupation;

    public Agent(String code, String nom, Date dateNaissance, String adresse, String email, String telNumber, int salaire, String statut, String categorie, int indiceSalaire, String occupation) {
        super(code, nom, dateNaissance, adresse, email, telNumber);
        this.salaire = salaire;
        this.statut = statut;
        this.categorie = categorie;
        this.indiceSalaire = indiceSalaire;
        this.occupation = occupation;
    }

    // Getters et setters
    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getIndiceSalaire() {
        return indiceSalaire;
    }

    public void setIndiceSalaire(int indiceSalaire) {
        this.indiceSalaire = indiceSalaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void insertIntoDatabase(Connection connection) throws SQLException {
        // Préparation de la requête SQL
        String sql = "INSERT INTO VOTRE_TABLE (code, nom, date_naissance, adresse, email, tel_number, cycle, niveau) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);

        // Remplissage des valeurs des paramètres
        statement.setString(1, getCode());
        statement.setString(2, getNom());
        statement.setDate(3, new java.sql.Date(getDateNaissance().getTime()));
        statement.setString(4, getAdresse());
        statement.setString(5, getEmail());
        statement.setString(6, getTelNumber());
        statement.setString(7, getOccupation());
        statement.setString(8, getCategorie());
        statement.setInt(9, getIndiceSalaire());
        statement.setString(10, getStatut());
        statement.setInt(11,  getSalaire());
        
}