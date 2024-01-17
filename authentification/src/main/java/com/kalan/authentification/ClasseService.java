package com.kalan.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;
    private final ProfesseurRepository professeurRepository;

    @Autowired
    public ClasseService(ClasseRepository classeRepository, ProfesseurRepository professeurRepository) {
        this.classeRepository = classeRepository;
        this.professeurRepository = professeurRepository;
    }

    public Classe createClasse(Long professeurId, Classe classe) {
        // Récupérer le professeur par son ID
        Optional<Professeur> professeurOptional = professeurRepository.findById(professeurId);

        if (professeurOptional.isPresent()) {
            Professeur professeur = professeurOptional.get();

            // Associer la classe au professeur
            classe.setProfesseur(professeur);

            // Sauvegarder la classe
            return classeRepository.save(classe);
        }

        return null; // Gestion des erreurs si le professeur n'est pas trouvé
    }

    // Autres méthodes...

}