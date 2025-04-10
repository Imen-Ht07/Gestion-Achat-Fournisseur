package gestionachatfournisseur.gestionachatfournisseu.models;

import gestionachatfournisseur.gestionachatfournisseu.enumrate.StatutCommande;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CommandeAchat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;
    @Column(nullable = false)
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private StatutCommande statut;
    private Double montant;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCommandeAchat> lignes;

    public CommandeAchat() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public List<LigneCommandeAchat> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeAchat> lignes) {
        this.lignes = lignes;
    }
}
