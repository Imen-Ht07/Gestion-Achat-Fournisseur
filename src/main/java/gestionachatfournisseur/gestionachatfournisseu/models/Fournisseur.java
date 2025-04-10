package gestionachatfournisseur.gestionachatfournisseu.models;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @Column(nullable = false)
    private String contact;

    private String qualiteService;
    @Min(0)
    @Max(5)
    private Double note;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeAchat> commandes;

    @OneToMany(mappedBy = "fournisseur")
    private List<HistoriqueAchats> historiques;

    public Fournisseur() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQualiteService() {
        return qualiteService;
    }

    public void setQualiteService(String qualiteService) {
        this.qualiteService = qualiteService;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }

    public List<CommandeAchat> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<CommandeAchat> commandes) {
        this.commandes = commandes;
    }

    public List<HistoriqueAchats> getHistoriques() {
        return historiques;
    }

    public void setHistoriques(List<HistoriqueAchats> historiques) {
        this.historiques = historiques;
    }
}
