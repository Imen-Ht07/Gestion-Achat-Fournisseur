package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.HistoriqueAchats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueAchatsRepository extends JpaRepository<HistoriqueAchats, Long> {
}
