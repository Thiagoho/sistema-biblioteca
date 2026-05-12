package app;

import exceptions.LivroInvalidoException;
import model.Livro;

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
	}
}