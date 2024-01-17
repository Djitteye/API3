package com.kalan.authentification;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("professeur")
public class Professeur extends User {

    private String matieres;
    private String ville;
    
    
    public String getMatieres() {
		return matieres;
	}


	public void setMatieres(String matieres) {
		this.matieres = matieres;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public List<Classe> getClasses() {
		return classes;
	}


	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}


	@OneToMany(mappedBy = "professeur")
    private List<Classe> classes;

    // Getter and Setter methods
}
