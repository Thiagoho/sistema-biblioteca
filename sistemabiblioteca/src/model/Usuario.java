package model;

import exceptions.UsuarioInvalidoException;

public class Usuario {
	//Atributos
	private String nome;
	private String email;
	private String telefone;

	// CONSTRUTORES
	public Usuario(String nome, String email, String telefone) throws UsuarioInvalidoException {
		if (nome == null || nome.trim().isEmpty()) {
			throw new UsuarioInvalidoException("\t O nome do usuário não ser vázio.");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new UsuarioInvalidoException("\t O email não pode ser vázio");
		}
		if (telefone == null || telefone.trim().isEmpty()) {
			throw new UsuarioInvalidoException("\t O telefone não pode ser vázio");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	// Getters
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;

	}

	public String getTelefone() {
		return telefone;
	}


}
