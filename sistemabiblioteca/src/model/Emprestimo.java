package model;

import java.time.LocalDate;

public class Emprestimo {
	// Atriburos
	private Usuario usuario;
	private Livro livro;
	
	private LocalDate dataEmprestimo;
	private LocalDate dataPrevistaDevolucao;
	private LocalDate dataDevolucao;

	// Construtores
	public Emprestimo(
			Usuario usuario,
			Livro livro
			) {
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = LocalDate.now(); /*[LocalDate] -> Uso do LocalDate pega a data atual */
		
		this.dataPrevistaDevolucao = LocalDate.now().plusDays(7); /*[LocalDate.now().plusDays(7)] -> Regra Implementada 7 dias para devolução.*/
	}
	//Getters
	public Usuario getUsuario() {
		return usuario;
	}

	

	public Livro getLivro() {
		return livro;
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
	
	// Devolver Livro() 
	public void devolverLivro() {
		this.dataDevolucao = LocalDate.now();
	}

		


}
