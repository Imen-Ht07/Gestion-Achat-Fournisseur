package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
import gestionachatfournisseur.gestionachatfournisseu.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    public Fournisseur getById(Long id) {
        return fournisseurRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur introuvable avec l'id: " + id));
    }

    public Fournisseur create(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public Fournisseur update(Long id, Fournisseur fournisseur) {
        Fournisseur existing = getById(id); // déclenche exception si non trouvé
        fournisseur.setId(existing.getId());
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(Long id) {
        Fournisseur existing = getById(id); // déclenche exception si non trouvé
        fournisseurRepository.deleteById(id);
    }
}
