package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.Services.LigneCommandeAchatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lignes-commandes")
@CrossOrigin
public class LigneCommandeAchatController {

    @Autowired
    private LigneCommandeAchatService ligneCommandeAchatService;

    @GetMapping
    public List<LigneCommandeAchat> getAll() {
        return ligneCommandeAchatService.getAll();
    }

    @GetMapping("/{id}")
    public LigneCommandeAchat getById(@PathVariable Long id) {
        return ligneCommandeAchatService.getById(id);
    }

    @PostMapping
    public LigneCommandeAchat save(@RequestBody LigneCommandeAchat ligneCommandeAchat) {
        return ligneCommandeAchatService.save(ligneCommandeAchat);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ligneCommandeAchatService.delete(id);
    }
}
