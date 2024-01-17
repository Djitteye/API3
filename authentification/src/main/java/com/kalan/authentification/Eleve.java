package com.kalan.authentification;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Eleve")
public class Eleve extends User {

    // Ajoutez des attributs spécifiques aux élèves si nécessaire

    // Getter and Setter methods
}