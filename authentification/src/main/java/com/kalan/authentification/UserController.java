package com.kalan.authentification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilisateur")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/inscription")
    public ResponseEntity<User> registerUser(
            @RequestParam String nom,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String role) {
        User newUser = userService.registerUser(nom, email, password, role);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
     
    //la partie connexion
    
    @PostMapping("/connexion")
    public ResponseEntity<User> connexionUtilisateur(@RequestParam String email, @RequestParam String password) {
        User userConnecte = userService.seConnecter(email, password);
        if (userConnecte != null) {
            return new ResponseEntity<>(userConnecte, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    
}
