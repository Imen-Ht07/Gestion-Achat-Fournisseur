package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.enumrate.StatutCommande;
import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.CommandeAchatRepository;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeAchatService {

    @Autowired
    private CommandeAchatRepository commandeAchatRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<CommandeAchat> getAll() {
        return commandeAchatRepository.findAll();
    }

    public CommandeAchat getById(Long id) {
        return commandeAchatRepository.findById(id).orElse(null);
    }

    public CommandeAchat save(CommandeAchat commandeAchat) {
        if (commandeAchat.getFournisseur() != null && commandeAchat.getFournisseur().getId() != null) {
            Fournisseur fournisseur = fournisseurRepository.findById(commandeAchat.getFournisseur().getId()).orElse(null);
            if (fournisseur == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fournisseur non trouvé");
            }
            commandeAchat.setFournisseur(fournisseur);

            if (commandeAchat.getLignes() != null && !commandeAchat.getLignes().isEmpty()) {
                for (LigneCommandeAchat ligne : commandeAchat.getLignes()) {
                    ligne.setCommande(commandeAchat);
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Les lignes de commande sont vides");
            }

            return commandeAchatRepository.save(commandeAchat);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le fournisseur est requis pour cette commande");
        }
    }

    public void delete(Long id) {
        commandeAchatRepository.deleteById(id);
    }

    public List<CommandeAchat> getByStatut(StatutCommande statut) {
        return commandeAchatRepository.findByStatut(statut);
    }

    public List<CommandeAchat> filterCommandes(StatutCommande statut, Long fournisseurId, LocalDate startDate, LocalDate endDate) {
        List<CommandeAchat> commandes = commandeAchatRepository.findAll();

        return commandes.stream()
                .filter(c -> (statut == null || c.getStatut() == statut))
                .filter(c -> (fournisseurId == null || (c.getFournisseur() != null && fournisseurId.equals(c.getFournisseur().getId()))))
                .filter(c -> (startDate == null || (c.getDate() != null && !c.getDate().isBefore(startDate))))
                .filter(c -> (endDate == null || (c.getDate() != null && !c.getDate().isAfter(endDate))))
                .collect(Collectors.toList());
    }
}
