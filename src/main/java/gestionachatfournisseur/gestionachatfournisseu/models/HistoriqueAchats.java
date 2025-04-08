package gestionachatfournisseur.gestionachatfournisseu.models;
import jakarta.persistence.*;

@Entity
public class HistoriqueAchats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    private String produit;
    private int quantite;
    private int delaiLivraison; // en jours

    public HistoriqueAchats() {}

    // Getters & setters
}
