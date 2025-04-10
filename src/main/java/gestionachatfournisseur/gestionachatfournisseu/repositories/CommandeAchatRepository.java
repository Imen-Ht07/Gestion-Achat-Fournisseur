package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.enumrate.StatutCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, Long> {
    List<CommandeAchat> findByStatut(StatutCommande statut);
    List<CommandeAchat> findByFournisseurId(Long fournisseurId);
    List<CommandeAchat> findByDateBetween(LocalDate start, LocalDate end);
}
