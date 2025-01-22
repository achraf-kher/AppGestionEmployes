public class Employee {
    private int id;
    private String nom;
    private String poste;
    private double salaire;

    // Constructeurs
    public Employee(int id, String nom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public Employee() {
        // Constructeur par défaut
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Poste: " + poste + ", Salaire: " + salaire + " €";
    }

    // Méthode statique pour comparer les salaires
    public static int compareParSalaire(Employee e1, Employee e2) {
        return Double.compare(e1.getSalaire(), e2.getSalaire());
    }
}