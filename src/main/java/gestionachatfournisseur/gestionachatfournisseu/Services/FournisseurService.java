package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
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
        return fournisseurRepository.findById(id).orElse(null);
    }

    public Fournisseur save(Fournisseur fournisseur) {
        return fournisseurRepository.save(fournisseur);
    }

    public void delete(Long id) {
        fournisseurRepository.deleteById(id);
    }
}
