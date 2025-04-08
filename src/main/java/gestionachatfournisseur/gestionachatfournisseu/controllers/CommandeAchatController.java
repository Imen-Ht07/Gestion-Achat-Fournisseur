package Systeme_gestion_achats_fournisseurs.gestion_achats_fournisseurs.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.Services.CommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin
public class CommandeAchatController {

    @Autowired
    private CommandeAchatService commandeAchatService;

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
        return commandeAchatService.save(commandeAchat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commandeAchatService.delete(id);
    }
}
