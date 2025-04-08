package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.LigneCommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.LigneCommandeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigneCommandeAchatService {

    @Autowired
    private LigneCommandeAchatRepository ligneCommandeAchatRepository;

    public List<LigneCommandeAchat> getAll() {
        return ligneCommandeAchatRepository.findAll();
    }

    public LigneCommandeAchat getById(Long id) {
        return ligneCommandeAchatRepository.findById(id).orElse(null);
    }

    public LigneCommandeAchat save(LigneCommandeAchat ligneCommandeAchat) {
        return ligneCommandeAchatRepository.save(ligneCommandeAchat);
    }

    public void delete(Long id) {
        ligneCommandeAchatRepository.deleteById(id);
    }
}
