package gestionachatfournisseur.gestionachatfournisseu.controllers;

import gestionachatfournisseur.gestionachatfournisseu.models.HistoriqueAchats;
import gestionachatfournisseur.gestionachatfournisseu.Services.HistoriqueAchatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiques-achats")
@CrossOrigin
public class HistoriqueAchatsController {

    @Autowired
    private HistoriqueAchatsService historiqueAchatsService;

    @GetMapping
    public List<HistoriqueAchats> getAll() {
        return historiqueAchatsService.getAll();
    }

    @GetMapping("/{id}")
    public HistoriqueAchats getById(@PathVariable Long id) {
        return historiqueAchatsService.getById(id);
    }

    @PostMapping
    public HistoriqueAchats save(@RequestBody HistoriqueAchats historiqueAchats) {
        return historiqueAchatsService.save(historiqueAchats);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        historiqueAchatsService.delete(id);
    }
}
