package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.Services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fournisseurs")
@CrossOrigin(origins = "http://localhost:4200") // Spécifie le front Angular si tu l'utilises
public class FournisseurController {

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public List<Fournisseur> getAll() {
        return fournisseurService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        Optional<Fournisseur> fournisseur = Optional.ofNullable(fournisseurService.getById(id));
        return fournisseur.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fournisseur> save(@RequestBody Fournisseur fournisseur) {
        Fournisseur saved = fournisseurService.create(fournisseur);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id,@RequestBody Fournisseur fournisseur) {
        Fournisseur existing = fournisseurService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        fournisseur.setId(id);
        Fournisseur updated = fournisseurService.create(fournisseur);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Fournisseur existing = fournisseurService.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        fournisseurService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
