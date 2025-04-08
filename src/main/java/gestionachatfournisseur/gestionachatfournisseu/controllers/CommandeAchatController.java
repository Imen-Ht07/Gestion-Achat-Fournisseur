package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.Services.CommandeAchatService;
import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;  // Importation du FournisseurRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;  // Importation de HttpStatus
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;  // Importation de ResponseStatusException

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin
public class CommandeAchatController {

    @Autowired
    private CommandeAchatService commandeAchatService;

    @Autowired
    private FournisseurRepository fournisseurRepository;  // Injection de FournisseurRepository

    @GetMapping
    public List<CommandeAchat> getAll() {
        return commandeAchatService.getAll();
    }

    @GetMapping("/{id}")
    public CommandeAchat getById(@PathVariable Long id) {
        return commandeAchatService.getById(id);
    }

    @PostMapping
    public CommandeAchat save(@RequestBody CommandeAchat commandeAchat) {
        // Vérifie si le fournisseur existe dans la base de données
        Fournisseur fournisseur = fournisseurRepository.findById(commandeAchat.getFournisseur().getId()).orElse(null);
        if (fournisseur == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fournisseur non trouvé");
        }
        commandeAchat.setFournisseur(fournisseur);
        // Vérifie que chaque ligne de commande est associée à la commande
        if (commandeAchat.getLignes() != null) {
            for (LigneCommandeAchat ligne : commandeAchat.getLignes()) {
                // On associe la commande à chaque ligne
                ligne.setCommande(commandeAchat);
            }
        }

        return commandeAchatService.save(commandeAchat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandeAchatService.delete(id);
    }
}
