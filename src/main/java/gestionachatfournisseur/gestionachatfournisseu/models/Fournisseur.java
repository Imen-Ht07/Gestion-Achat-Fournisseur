
package gestionachatfournisseur.gestionachatfournisseu.models;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String contact;
    private String qualiteService;
    private Double note;

    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeAchat> commandes;

    @OneToMany(mappedBy = "fournisseur")
    private List<HistoriqueAchats> historiques;

    public Fournisseur() {}
//getter setter
}
