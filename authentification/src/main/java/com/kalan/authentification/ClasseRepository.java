package com.kalan.authentification;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    // Trouver toutes les classes associées à un professeur
    List<Classe> findByProfesseur(Professeur professeur);

    // Trouver toutes les classes avec un nom spécifique
    List<Classe> findByNom(String nom);

    
}
