package core;

import java.util.ArrayList;
import java.util.List;

public class Repertoire {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void ajouterContact(Contact contact) {
        contacts.add(contact);
    }

    public void supprimerContact(Contact contactASupprimer) {
        contacts.remove(contactASupprimer);
    }

    public void modifierContact(Contact contact, String nouveauNom, String nouvelleAdresse, String nouvelEmail, String nouveauTelNumber) {
        contact.setNom(nouveauNom);
        contact.setAdresse(nouvelleAdresse);
        contact.setEmail(nouvelEmail);
        contact.setTelNumber(nouveauTelNumber);
    }

    public Contact rechercherContact(String nom) {
        for (Contact contact : contacts) {
            if (contact.getNom().equals(nom)) {
                return contact;
            }
        }
        return null;
    }

    // Méthode pour obtenir la liste de contacts
    public List<Contact> getListeContacts() {
        return contacts;
    }
}
