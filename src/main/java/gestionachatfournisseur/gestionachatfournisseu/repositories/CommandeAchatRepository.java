package gestionachatfournisseur.gestionachatfournisseu.repositories;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeAchatRepository extends JpaRepository<CommandeAchat, Long> {
}
