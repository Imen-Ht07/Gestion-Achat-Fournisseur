package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.Services.CommandeAchatService;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
import gestionachatfournisseur.gestionachatfournisseu.enumrate.StatutCommande;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin
public class CommandeAchatController {

    @Autowired
    private CommandeAchatService commandeAchatService;

    @Autowired
    private FournisseurRepository fournisseurRepository;

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
        // Vérifie si le fournisseur existe
        Fournisseur fournisseur = fournisseurRepository.findById(commandeAchat.getFournisseur().getId()).orElse(null);
        if (fournisseur == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fournisseur non trouvé");
        }

        commandeAchat.setFournisseur(fournisseur);

        // Associe la commande à chaque ligne
        if (commandeAchat.getLignes() != null) {
            for (LigneCommandeAchat ligne : commandeAchat.getLignes()) {
                ligne.setCommande(commandeAchat);
            }
        }

        return commandeAchatService.save(commandeAchat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandeAchatService.delete(id);
    }

    // ✅ Filtrage par statut
    @GetMapping("/by-statut/{statut}")
    public List<CommandeAchat> getByStatut(@PathVariable StatutCommande statut) {
        return commandeAchatService.getByStatut(statut);
    }

    // ✅ BONUS : filtrage dynamique (statut, fournisseur, dates)
    @GetMapping("/filter")
    public List<CommandeAchat> filterCommandes(
            @RequestParam(required = false) StatutCommande statut,
            @RequestParam(required = false) Long fournisseurId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return commandeAchatService.filterCommandes(statut, fournisseurId, startDate, endDate);
    }
}
