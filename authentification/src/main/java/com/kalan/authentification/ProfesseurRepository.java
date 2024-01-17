package com.kalan.authentification;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

    // Trouver un professeur par email
    Professeur findByNom(String nom);

    // Trouver tous les professeurs par matière
    List<Professeur> findByMatieres(String matiere);

    // Trouver tous les professeurs dans une ville spécifique
    List<Professeur> findByVille(String ville);
    
 // Trouver tous les professeurs par Email
    List<Professeur> findByEmail(String email);

    
}
