package gestionachatfournisseur.gestionachatfournisseu.models;
import jakarta.persistence.*;

@Entity
public class LigneCommandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "commande_id")
    private CommandeAchat commande;

    private String produit;
    private int quantite;
    private double prixUnitaire;

    public LigneCommandeAchat() {}

    // Getters & setters
}
