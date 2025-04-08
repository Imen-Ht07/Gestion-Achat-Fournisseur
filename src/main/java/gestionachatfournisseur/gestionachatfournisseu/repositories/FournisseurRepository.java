package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    // Tu peux ajouter des méthodes personnalisées ici plus tard
}
