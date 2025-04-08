package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

    // Exemple de méthode personnalisée : recherche par nom
    List<Fournisseur> findByNomContainingIgnoreCase(String nom);
}
