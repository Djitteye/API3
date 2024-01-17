package com.kalan.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {

    @Autowired
    private ProfilService professeurService;

    @Autowired
    private ClasseService classeService;

    // ... Autres méthodes ...

    @GetMapping("/create-classe")
    public String createClasseForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "professeur/create-classe";
    }

    @PostMapping("/create-classe")
    public String createClasse(@ModelAttribute("classe") Classe classe, Principal principal) {
        // Récupérer l'ID du professeur à partir de l'email
        String email = principal.getName();
        Professeur professeur = professeurService.getProfilByEmail(email);

        if (professeur != null) {
            // Créer la classe en associant au professeur
            classeService.createClasse(professeur.getId(), classe);
        }

        return "redirect:/professeur/dashboard";
    }

    // ... Autres méthodes ...
}
