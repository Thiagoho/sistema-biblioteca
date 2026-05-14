package model;

import exceptions.LivroInvalidoException;

public class Livro {

    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadeDisponivel;

    // CONSTRUTOR
    public Livro(
            String titulo,
            String autor,
            int anoPublicacao,
            int quantidadeDisponivel
    ) throws LivroInvalidoException {

        if (titulo == null || titulo.trim().isEmpty()) {

            throw new LivroInvalidoException (
                    "O título do livro não pode ser vazio."
            );
        }

        if (autor == null || autor.trim().isEmpty()) {

            throw new LivroInvalidoException (
                    "O autor do livro não pode ser vazio."
            );
        }

        if (anoPublicacao <= 0) {

            throw new LivroInvalidoException (
                    "Ano de publicação inválido."
            );
        }

        if (quantidadeDisponivel < 0) {

            throw new LivroInvalidoException (
                    "A quantidade não pode ser negativa."
            );
        }

        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // GETTERS

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    // MÉTODOS

    public void diminuirQuantidade() {
        quantidadeDisponivel--;
    }

    public void aumentarQuantidade() {
        quantidadeDisponivel++;
    }
}