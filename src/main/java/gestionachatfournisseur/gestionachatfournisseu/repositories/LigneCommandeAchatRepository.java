package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeAchatRepository extends JpaRepository<LigneCommandeAchat, Long> {
}
