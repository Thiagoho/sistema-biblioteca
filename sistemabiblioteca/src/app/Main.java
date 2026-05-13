package app;

import exceptions.LivroInvalidoException;
import exceptions.UsuarioInvalidoException;
import model.Livro;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		try {
			Livro livro = new Livro("Java Poo", "Thiago Sales", 2020, 2);
			System.out.println("Livro Criado!");
		} catch (LivroInvalidoException e) {
			System.out.println("Erro ao criar livro:" + e.getMessage());
		}
	 try {
		 Usuario user = new Usuario("Thiago Sales", "thiagoSales@gmail.com", "3299948244");
		 System.out.println("Nome Criado!");
	 }catch (UsuarioInvalidoException e) {
	 System.out.println("Erro ao criar nome: " + e.getMessage());
	 }
	}
}