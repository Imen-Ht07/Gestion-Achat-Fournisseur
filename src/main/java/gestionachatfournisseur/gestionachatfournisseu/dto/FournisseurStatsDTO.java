package gestionachatfournisseur.gestionachatfournisseu.dto;

public class FournisseurStatsDTO {

    private Long id;
    private String nom;
    private Double note;
    private Long nombreCommandes;
    private Double montantMoyen;

    public FournisseurStatsDTO(Long id, String nom, Double note, Long nombreCommandes, Double montantMoyen) {
        this.id = id;
        this.nom = nom;
        this.note = note;
        this.nombreCommandes = nombreCommandes;
        this.montantMoyen = montantMoyen;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Double getNote() { return note; }
    public void setNote(Double note) { this.note = note; }

    public Long getNombreCommandes() { return nombreCommandes; }
    public void setNombreCommandes(Long nombreCommandes) { this.nombreCommandes = nombreCommandes; }

    public Double getMontantMoyen() { return montantMoyen; }
    public void setMontantMoyen(Double montantMoyen) { this.montantMoyen = montantMoyen; }
}
