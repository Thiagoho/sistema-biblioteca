package service;

import java.util.ArrayList;
import java.util.List;

import exceptions.EmprestimoInvalidoException;
import exceptions.LivroIndisponivelException;
import model.Emprestimo;
import model.Livro;
import model.Usuario;

public class BibliotecaService {

    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public BibliotecaService() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void listarLivros() {

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        System.out.println("\n===== LIVROS CADASTRADOS =====");

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);

            System.out.println("ID: " + i);
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("Disponível: " + livro.getQuantidadeDisponivel());
            System.out.println("-----------------------------");
        }
    }

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n===== USUÁRIOS CADASTRADOS =====");

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            System.out.println("ID: " + i);
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("E-mail: " + usuario.getEmail());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("-----------------------------");
        }
    }

    public void realizarEmprestimo(int idUsuario, int idLivro)
            throws LivroIndisponivelException, EmprestimoInvalidoException {

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Livro livro = buscarLivroPorId(idLivro);

        if (livro.getQuantidadeDisponivel() <= 0) {
            throw new LivroIndisponivelException(
                    "Livro indisponível para empréstimo."
            );
        }

        if (usuarioJaPossuiLivro(usuario, livro)) {
            throw new EmprestimoInvalidoException(
                    "Este usuário já possui um empréstimo ativo desse livro."
            );
        }

        livro.diminuirQuantidade();

        Emprestimo emprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(emprestimo);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void realizarDevolucao(int idUsuario, int idLivro)
            throws EmprestimoInvalidoException {

        Usuario usuario = buscarUsuarioPorId(idUsuario);
        Livro livro = buscarLivroPorId(idLivro);

        Emprestimo emprestimo = buscarEmprestimoAtivo(usuario, livro);

        emprestimo.devolverLivro();
        livro.aumentarQuantidade();

        System.out.println("Devolução realizada com sucesso!");
    }

    public void listarEmprestimosAtivos() {

        boolean encontrou = false;

        System.out.println("\n===== EMPRÉSTIMOS ATIVOS =====");

        for (Emprestimo emprestimo : emprestimos) {

            if (emprestimo.getDataDevolucao() == null) {

                encontrou = true;

                System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
                System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                System.out.println("Data empréstimo: " + emprestimo.getDataEmprestimo());
                System.out.println("Previsão devolução: " + emprestimo.getDataPrevistaDevolucao());
                System.out.println("-----------------------------");
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum empréstimo ativo.");
        }
    }

    private Livro buscarLivroPorId(int idLivro)
            throws EmprestimoInvalidoException {

        if (idLivro < 0 || idLivro >= livros.size()) {
            throw new EmprestimoInvalidoException(
                    "Livro não encontrado."
            );
        }

        return livros.get(idLivro);
    }

    private Usuario buscarUsuarioPorId(int idUsuario)
            throws EmprestimoInvalidoException {

        if (idUsuario < 0 || idUsuario >= usuarios.size()) {
            throw new EmprestimoInvalidoException(
                    "Usuário não encontrado."
            );
        }

        return usuarios.get(idUsuario);
    }

    private boolean usuarioJaPossuiLivro(Usuario usuario, Livro livro) {

        for (Emprestimo emprestimo : emprestimos) {

            boolean mesmoUsuario =
                    emprestimo.getUsuario() == usuario;

            boolean mesmoLivro =
                    emprestimo.getLivro() == livro;

            boolean emprestimoAtivo =
                    emprestimo.getDataDevolucao() == null;

            if (mesmoUsuario && mesmoLivro && emprestimoAtivo) {
                return true;
            }
        }

        return false;
    }

    private Emprestimo buscarEmprestimoAtivo(Usuario usuario, Livro livro)
            throws EmprestimoInvalidoException {

        for (Emprestimo emprestimo : emprestimos) {

            boolean mesmoUsuario =
                    emprestimo.getUsuario() == usuario;

            boolean mesmoLivro =
                    emprestimo.getLivro() == livro;

            boolean emprestimoAtivo =
                    emprestimo.getDataDevolucao() == null;

            if (mesmoUsuario && mesmoLivro && emprestimoAtivo) {
                return emprestimo;
            }
        }

        throw new EmprestimoInvalidoException(
                "Não existe empréstimo ativo para esse usuário e livro."
        );
    }
}