package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.HistoriqueAchats;
import gestionachatfournisseur.gestionachatfournisseu.repositories.HistoriqueAchatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueAchatsService {

    @Autowired
    private HistoriqueAchatsRepository historiqueAchatsRepository;

    public List<HistoriqueAchats> getAll() {
        return historiqueAchatsRepository.findAll();
    }

    public HistoriqueAchats getById(Long id) {
        return historiqueAchatsRepository.findById(id).orElse(null);
    }

    public HistoriqueAchats save(HistoriqueAchats historiqueAchats) {
        return historiqueAchatsRepository.save(historiqueAchats);
    }

    public void delete(Long id) {
        historiqueAchatsRepository.deleteById(id);
    }
}
