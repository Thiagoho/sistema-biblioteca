<h2>Sistema de Biblicoteca em JAVA PURO</h2>
Este projeto foi desenvolvido em ´JAVA PUTO´ com o objeto de praticar Programação Orientada a Objetos listas, datas, validações e regas de negócio.<br>
A aplicação simula um sistema simples de biblioteca via terminal, permite cadastrar livros, cadastrar usuários, realizar empréstimo, realizar devoluções e listar empréstimo ativos.
<h4>Objetivo</h4>
O objetivo principal deste projeto é treinar fundamentais da `linguagens java`, sem utilizar ´frameworks´.

---

O sistema foi desenvolvido com foco em:
- Classes e objetos
- Organização em pacotes
- Listas com ArrayList
- Datas com LocalDate
- Validações
- Regras de negócio
- Tratamento de exceções
- Menu interativo via terminal
---
<h4>Funcionalidades</h4>

- Cadastrar livro<br>
- Listar livros<br>
- Cadastrar usuário<br>
- Listar usuários<br>
- Realizar empréstimo<br>
- Realizar devolução<br>
- Listar empréstimos ativos<br>
- Encerrar o sistema<br>

---

<h4>Estrututura do Projeto</h4>
src/<br>
 ├── app/<br>
 │    └── Main.java<br>
 │<br>
 ├── model/<br>
 │    ├── Livro.java<br>
 │    ├── Usuario.java<br>
 │    └── Emprestimo.java<br>
 │<br>
 ├── service/<br>
 │    └── BibliotecaService.java<br>
 │<br>
 └── exceptions/<br>
      ├── LivroInvalidoException.java<br>
      ├── UsuarioInvalidoException.java<br>
      ├── EmprestimoInvalidoException.java<br>
      └── LivroIndisponivelException.java<br>
