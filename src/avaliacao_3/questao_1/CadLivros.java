package avaliacao_3.questao_1;


import metodos.procedimentos_e_funcoes.jogador.JogadorFut;

import javax.swing.*;
import java.util.ArrayList;

public class CadLivros {
    public static void main(String[] args) {

        int op = 0;
        ArrayList<Livros> livros = new ArrayList<Livros>();


        do{
            op = menu();
            if (op == 1) livros.add(cadastroLivro());
            if (op == 2) localizarLivroISBN_mostrarPessoas(livros);
            if (op == 3) usuario_livros(livros);
            if (op == 4) livrosPublicadosEm2020(livros);
            if (op == 5) livrosPorGenero(livros);
        } while (op != 6);

    }

    private static int menu() {
        String m = "1 - Cadastrar livro\n"
                +"2 - Localizar livro pelo ISBN\nMostrar pessoas que ja pegaram o livro emprestado\n"
                +"3 - Buscar por libros pegos por um usuário\n"
                +"4 - Dados de todos os livros publicados em 2020\n"
                +"5 - Lista de livros de um determinado gênero \n\n"
                +"6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static Livros cadastroLivro() {
        Livros livro = new Livros();

// TITULO DO LIVRO

        String titulo;
        do {
            titulo = JOptionPane.showInputDialog("Digite o titulo do livro:");
            if (titulo == null || titulo.trim().isEmpty()){
                JOptionPane.showInputDialog("Digite o titulo do livro:");
            }
        }while (titulo == null || titulo.trim().isEmpty());
        livro.setTituo(titulo);

// AUTOR

        String autor;
        do {
            autor = JOptionPane.showInputDialog("Digite o nome do autor:");
            if (autor == null || autor.trim().isEmpty()){
                JOptionPane.showInputDialog("Digite o nome do autor:");
            }
        }while (autor == null || titulo.trim().isEmpty());
        livro.setAutor(autor);



        return null;
    }

    private static void localizarLivroISBN_mostrarPessoas(ArrayList<Livros> livros) {

    }

    private static void usuario_livros(ArrayList<Livros> livros) {

    }

    private static void livrosPublicadosEm2020(ArrayList<Livros> livros) {

    }

    private static void livrosPorGenero(ArrayList<Livros> livros) {

    }
}
