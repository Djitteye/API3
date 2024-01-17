package com.kalan.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class ProfilService {

    private final ProfesseurRepository professeurRepository;

    @Autowired
    public ProfilService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public Professeur getProfilByEmail(String email) {
        // Récupérer un professeur par son email
        Optional<Professeur> professeurOptional = professeurRepository.findByEmail(email);
        return professeurOptional.orElse(null);
    }
}
