package gestionachatfournisseur.gestionachatfournisseu.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class CommandeAchat{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    private Fournisseur fournisseur;

    private LocalDate date;
    private String statut;
    private Double montant;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCommandeAchat> lignes;

    public CommandeAchat() {}

    // Getters & setters
}
