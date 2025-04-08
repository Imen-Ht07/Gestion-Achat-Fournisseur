package gestionachatfournisseur.gestionachatfournisseu.models;

import jakarta.persistence.*;

@Entity
public class LigneCommandeAchat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String produit;
    private Integer quantite;
    private Double prixUnitaire;

    @ManyToOne

    @JoinColumn(name = "commande_id")

    private CommandeAchat commande;

    public LigneCommandeAchat() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public CommandeAchat getCommande() {
        return commande;
    }

    public void setCommande(CommandeAchat commande) {
        this.commande = commande;
    }
}
