package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.Services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
@CrossOrigin
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAll() {
        return fournisseurService.getAll();
    }

    @GetMapping("/{id}")
    public Fournisseur getById(@PathVariable Long id) {
        return fournisseurService.getById(id);
    }

    @PostMapping
    public Fournisseur save(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.save(fournisseur);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        fournisseurService.delete(id);
    }
}
