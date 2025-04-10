package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.Fournisseur;
import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.FournisseurRepository;
import gestionachatfournisseur.gestionachatfournisseu.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gestionachatfournisseur.gestionachatfournisseu.dto.FournisseurStatsDTO;
import java.util.List;
import java.util.stream.Collectors;

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
    //Evaluation des Fournisseurs
    public List<FournisseurStatsDTO> getFournisseursStats() {
        return fournisseurRepository.findAll().stream().map(f -> {
            double total = f.getCommandes().stream().mapToDouble(CommandeAchat::getMontant).sum();
            long nb = f.getCommandes().size();
            double moyenne = nb > 0 ? total / nb : 0;
            return new FournisseurStatsDTO(f.getId(), f.getNom(), f.getNote(), nb, moyenne);
        }).collect(Collectors.toList());
    }

}
