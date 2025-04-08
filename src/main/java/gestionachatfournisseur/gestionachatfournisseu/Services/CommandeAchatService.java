package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.CommandeAchatRepository;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommandeAchatService {

    @Autowired
    private CommandeAchatRepository commandeAchatRepository;

    @Autowired
    private FournisseurRepository fournisseurRepository; // Injection de FournisseurRepository

    public List<CommandeAchat> getAll() {
        return commandeAchatRepository.findAll();
    }

    public CommandeAchat getById(Long id) {
        return commandeAchatRepository.findById(id).orElse(null);
    }

    public CommandeAchat save(CommandeAchat commandeAchat) {
        // Assurez-vous que le fournisseur est déjà attaché à la commande
        if (commandeAchat.getFournisseur() != null && commandeAchat.getFournisseur().getId() != null) {
            // Récupère le fournisseur depuis la base de données à l'aide de l'instance injectée
            Fournisseur fournisseur = fournisseurRepository.findById(commandeAchat.getFournisseur().getId()).orElse(null);
            if (fournisseur == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fournisseur non trouvé");
            }
            commandeAchat.setFournisseur(fournisseur);

            // Associer chaque ligne à la commande avant de la sauvegarder
            if (commandeAchat.getLignes() != null) {
                for (LigneCommandeAchat ligne : commandeAchat.getLignes()) {
                    ligne.setCommande(commandeAchat); // Associer chaque ligne à la commande
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Les lignes de commande sont vides");
            }

            // Sauvegarde de la commande
            return commandeAchatRepository.save(commandeAchat);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le fournisseur est requis pour cette commande");
        }
    }

    public void delete(Long id) {
        commandeAchatRepository.deleteById(id);
    }
}
