package gestionachatfournisseur.gestionachatfournisseu.Services;

import gestionachatfournisseur.gestionachatfournisseu.models.CommandeAchat;
import gestionachatfournisseur.gestionachatfournisseu.repositories.CommandeAchatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeAchatService {

    @Autowired
    private CommandeAchatRepository commandeAchatRepository;

    public List<CommandeAchat> getAll() {
        return commandeAchatRepository.findAll();
    }

    public CommandeAchat getById(Long id) {
        return commandeAchatRepository.findById(id).orElse(null);
    }

    public CommandeAchat save(CommandeAchat commandeAchat) {
        return commandeAchatRepository.save(commandeAchat);
    }

    public void delete(Long id) {
        commandeAchatRepository.deleteById(id);
    }
}