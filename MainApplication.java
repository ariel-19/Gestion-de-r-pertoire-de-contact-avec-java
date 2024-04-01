public class MainApplication {
    public static void main(String[] args) {
        // Création d'instances de contacts
        Etudiant etudiant1 = new Etudiant("E123", "Ariel", "01/05/2003", "Biyem-assi", "ariel@12.com", "123456789", "Licence", "L3");
        Enseignant enseignant1 = new Enseignant("T456", "sharon", "15/10/2004", "Melen", "sharon@12.com", "987654321", "Permanent");
        Agent agent1 = new Agent("A789", "Carol", "20/03/2000", "Obili", "carol@123.com", "555555555", 3000.0, "Permanent");

        // Création du répertoire
        Repertoire repertoire = new Repertoire();

        // Ajout des contacts au répertoire
        repertoire.ajouterContact(etudiant1);
        repertoire.ajouterContact(enseignant1);
        repertoire.ajouterContact(agent1);

        // Test des méthodes du répertoire
        System.out.println("Liste des contacts :");
        repertoire.afficherContacts();

        // Recherche d'un contact par code
        Contact contactRecherche = repertoire.rechercherContact("T456");
        if (contactRecherche != null) {
            System.out.println("Contact trouvé : " + contactRecherche.getNom());
        } else {
            System.out.println("Contact non trouvé.");
        }

        // Recherche du contact à supprimer
        Contact contactASupprimer = repertoire.rechercherContact("A789");
        if (contactASupprimer != null) {
            // Suppression du contact trouvé
            boolean suppressionOk = repertoire.supprimerContact(contactASupprimer);
            if (suppressionOk) {
                System.out.println("Contact supprimé avec succès.");
            } else {
                System.out.println("Échec de la suppression du contact.");
            }
        } else {
            System.out.println("Contact non trouvé.");
        }
    }
}
