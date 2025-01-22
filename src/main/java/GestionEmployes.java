import java.util.Arrays;
import java.util.Scanner;

public class GestionEmployes {
    private static final int MAX_EMPLOYES = 50;
    private static Employee[] employes = new Employee[MAX_EMPLOYES];
    private static int nombreEmployes = 0;
    private static Scanner scanner = new Scanner(System.in);

    // Méthode pour afficher le menu
    public static void printMenu() {
        System.out.println("\n=== Menu de Gestion des Employés ===");
        System.out.println("1. Ajouter un employé");
        System.out.println("2. Modifier un employé");
        System.out.println("3. Supprimer un employé");
        System.out.println("4. Afficher tous les employés");
        System.out.println("5. Rechercher un employé");
        System.out.println("6. Calculer la masse salariale");
        System.out.println("7. Trier les employés par salaire");
        System.out.println("0. Quitter");
        System.out.print("Choisissez une option : ");
    }

    // Méthode pour ajouter un employé
    public static void ajouterEmployee() {
        if (nombreEmployes < MAX_EMPLOYES) {
            System.out.print("Entrez l'ID de l'employé : ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            System.out.print("Entrez le nom de l'employé : ");
            String nom = scanner.nextLine();

            System.out.print("Entrez le poste de l'employé : ");
            String poste = scanner.nextLine();

            System.out.print("Entrez le salaire de l'employé : ");
            double salaire = scanner.nextDouble();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            Employee employee = new Employee(id, nom, poste, salaire);
            employes[nombreEmployes] = employee;
            nombreEmployes++;
            System.out.println("Employé ajouté avec succès !");
        } else {
            System.out.println("Le tableau est plein, impossible d'ajouter un nouvel employé.");
        }
    }

    // Méthode pour modifier un employé
    public static void modifierEmployee() {
        System.out.print("Entrez l'ID de l'employé à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.print("Entrez le nouveau nom : ");
        String nouveauNom = scanner.nextLine();

        System.out.print("Entrez le nouveau poste : ");
        String nouveauPoste = scanner.nextLine();

        System.out.print("Entrez le nouveau salaire : ");
        double nouveauSalaire = scanner.nextDouble();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                employes[i].setNom(nouveauNom);
                employes[i].setPoste(nouveauPoste);
                employes[i].setSalaire(nouveauSalaire);
                System.out.println("Employé modifié avec succès !");
                return;
            }
        }
        System.out.println("Aucun employé trouvé avec l'ID " + id);
    }

    // Méthode pour supprimer un employé
    public static void supprimerEmployee() {
        System.out.print("Entrez l'ID de l'employé à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getId() == id) {
                for (int j = i; j < nombreEmployes - 1; j++) {
                    employes[j] = employes[j + 1];
                }
                nombreEmployes--;
                System.out.println("Employé supprimé avec succès !");
                return;
            }
        }
        System.out.println("Aucun employé trouvé avec l'ID " + id);
    }

    // Méthode pour afficher tous les employés
    public static void afficherEmployes() {
        if (nombreEmployes == 0) {
            System.out.println("Aucun employé à afficher.");
        } else {
            for (int i = 0; i < nombreEmployes; i++) {
                System.out.println(employes[i]);
            }
        }
    }

    // Méthode pour rechercher un employé
    public static void rechercherEmployee() {
        System.out.print("Entrez un nom ou un poste pour rechercher : ");
        String critere = scanner.nextLine();

        boolean trouve = false;
        for (int i = 0; i < nombreEmployes; i++) {
            if (employes[i].getNom().equalsIgnoreCase(critere) || employes[i].getPoste().equalsIgnoreCase(critere)) {
                System.out.println(employes[i]);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun employé trouvé avec le critère : " + critere);
        }
    }

    // Méthode pour calculer la masse salariale
    public static void calculerMasseSalariale() {
        double masseSalariale = 0;
        for (int i = 0; i < nombreEmployes; i++) {
            masseSalariale += employes[i].getSalaire();
        }
        System.out.println("La masse salariale totale est : " + masseSalariale + " €");
    }

    // Méthode pour trier les employés par salaire
    public static void trierEmployesParSalaire() {
        System.out.print("Trier par ordre croissant (true) ou décroissant (false) ? ");
        boolean ordreCroissant = scanner.nextBoolean();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        Arrays.sort(employes, 0, nombreEmployes, (e1, e2) -> {
            if (ordreCroissant) {
                return Double.compare(e1.getSalaire(), e2.getSalaire());
            } else {
                return Double.compare(e2.getSalaire(), e1.getSalaire());
            }
        });
        System.out.println("Employés triés par salaire (" + (ordreCroissant ? "croissant" : "décroissant") + ") :");
        afficherEmployes();
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterEmployee();
                    break;
                case 2:
                    modifierEmployee();
                    break;
                case 3:
                    supprimerEmployee();
                    break;
                case 4:
                    afficherEmployes();
                    break;
                case 5:
                    rechercherEmployee();
                    break;
                case 6:
                    calculerMasseSalariale();
                    break;
                case 7:
                    trierEmployesParSalaire();
                    break;
                case 0:
                    running = false;
                    System.out.println("Merci d'avoir utilisé l'application. Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}