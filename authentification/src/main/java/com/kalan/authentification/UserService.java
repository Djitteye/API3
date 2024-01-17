package com.kalan.authentification;

public interface UserService {
	User registerUser(String nom, String email, String password, String role);

	User seConnecter(String email, String password);

}
