package app;

import java.util.Scanner;

import exceptions.EmprestimoInvalidoException;
import exceptions.LivroIndisponivelException;
import exceptions.LivroInvalidoException;
import exceptions.UsuarioInvalidoException;
import model.Livro;
import model.Usuario;
import service.BibliotecaService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Esta na Página de Cadastro Bibliotecário.");
		Scanner scanner = new Scanner(System.in);
		
		BibliotecaService biblioteca = new BibliotecaService();
		int opcao = 0;
		System.out.println("=================================");
		System.out.println("\tSISTEMA DE BIBLIOTECA");
		System.out.println("=================================");
		do {
			try {
				System.out.println("\n========= MENU =========");
				System.out.println("1 - CADASTRAR LIVRO");
				System.out.println("2 - LISTAR LIVROS");
				System.out.println("3 - CADASTRAR USUÁRIO");
				System.out.println("4 - LISTAR USUÁRIOS");
				System.out.println("5 - REALIZAR EMPRÉSTIMO");
				System.out.println("6 - REALIZAR DEVOLUÇÃO");
				System.out.println("7 - LISTAR EMPÉSTIMO ATIVOS");
				System.out.println("8 - ENCERRAR SISTEMA");
				System.out.print("Escolha uma opção: ");
				opcao = Integer.parseInt(scanner.nextLine());
				switch (opcao) {
				// CADASTRAR LIVRO
				case 1:
					System.out.println("\n===== CADASTRO DE LIVRO =====");
					System.out.println("Titulo: ");
					String titulo = scanner.nextLine();

					System.out.println("Autor: ");
					String autor = scanner.nextLine();

					System.out.println("Ano publicação: ");
					int ano = Integer.parseInt(scanner.nextLine());

					System.out.println("Quantidade disponível: ");
					int quantidade = Integer.parseInt(scanner.nextLine());

					Livro livro = new Livro(titulo, autor, ano, quantidade);

					biblioteca.cadastrarLivro(livro);

					break;
				// Listar Livros
				case 2:
					biblioteca.listarLivros();
					break;
				// Cadastrar Usuário
				case 3:
					System.out.println("\\n===== CADASTRO DE USUÁRIO =====\"");
					System.out.println("Nome: ");
					String nome = scanner.nextLine();

					System.out.println("E-mail: ");
					String email = scanner.nextLine();

					System.out.println("Telefone: ");
					String telefone = scanner.nextLine();

					Usuario usuario = new Usuario(nome, email, telefone);
					biblioteca.cadastrarUsuario(usuario);
					break;
				// Listar Usuários
				case 4:
					biblioteca.listarUsuarios();
					break;

				// Realizar Empréstimo
				case 5:
					biblioteca.listarUsuarios();
					System.out.println("ID do Usuário: ");
					int idUsuarioEmprestimo = Integer.parseInt(scanner.nextLine());
					biblioteca.listarLivros();
					System.out.println("ID do Livro: ");
					int idLivroEmprestimo = Integer.parseInt(scanner.nextLine());

					biblioteca.realizarEmprestimo(idUsuarioEmprestimo, idLivroEmprestimo);

					break;
				// Realizar Devolução
				case 6:
					biblioteca.listarUsuarios();
					System.out.println("ID do usuário: ");
					int idUsuarioDevolucao = Integer.parseInt(scanner.nextLine());

					biblioteca.listarLivros();
					System.out.println("ID do livro");
					int idLivroDevolucao = Integer.parseInt(scanner.nextLine());
					biblioteca.realizarDevolucao(idUsuarioDevolucao, idLivroDevolucao);
					break;
				// Listar Empréstimos
				case 7:
					biblioteca.listarEmprestimosAtivos();
					break;
				// sair
				case 8:
					System.out.println("Sistema encerrado.");
					break;

				default:
					System.out.println("Opção Inválida.");
				}

			} catch (LivroInvalidoException e) {

				System.out.println("Erro no livro " + e.getMessage());

			} catch (UsuarioInvalidoException e) {
				System.out.println("Erro no Usuário:" + e.getMessage());
			} catch (LivroIndisponivelException e) {
				System.out.println("Livro indisponível:" + e.getMessage());
			} catch (EmprestimoInvalidoException e) {
				System.out.println("Erro no empréstimo: " + e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Digite apenas números válidos.");
			} catch (Exception e) {
				System.out.println("Erro Insperado: " + e.getMessage());
			} finally {
				System.out.println("\nOperção finalizada.");
			}

		} while (opcao != 8);
		System.out.println("Seu programa encerrou!");
		scanner.close();
	}

}