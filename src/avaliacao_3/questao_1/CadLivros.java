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
        String m = "1 - Cadastrar jogador\n"
                +"2 - Jogador com maior numero de Gols\n"
                +"3 - Jogador com menor numero de Gols\n"
                +"4 - Goleiros que dizeram gol\n"
                +"5 - Camisas 10 \n\n"
                +"6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static Livros cadastroLivro() {
        Livros livro = new Livros();

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
