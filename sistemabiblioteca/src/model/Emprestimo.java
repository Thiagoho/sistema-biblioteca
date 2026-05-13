package model;

import java.time.LocalDate;

public class Emprestimo {
	// Atriburos
	private Usuario user;
	private Livro book;
	
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaDevolucao;
	private LocalDate dataDevolucao;

	// Construtores
	public Emprestimo(
			Usuario user,
			Livro book
			) {
		this.user = user;
		this.book = book;
		this.dataEmprestimo = LocalDate.now(); /*[LocalDate] -> Uso do LocalDate pega a data atual */
		
		this.dataPrevistaDevolucao = LocalDate.now().plusDays(7); /*[LocalDate.now().plusDays(7)] -> Regra Implementada 7 dias para devolução.*/
	}
	
	//Getters
	public Usuario getUser() {
		return user;
	}
	public Livro getBook() {
		return book;
	}
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
}
	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	// Devolver Livro 
	public void devolverLivro() {
		this.dataDevolucao = LocalDate.now();
	}
}
