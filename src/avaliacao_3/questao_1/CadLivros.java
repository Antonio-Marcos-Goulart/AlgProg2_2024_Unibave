package avaliacao_3.questao_1;


import javax.swing.*;
import java.util.ArrayList;

public class CadLivros {
    public static void main(String[] args) {

        int op = 0;
        ArrayList<Livros> livros = new ArrayList<Livros>();

        do {
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
                + "2 - Localizar livro pelo ISBN e mostrar pessoas que ja pegaram o livro emprestado\n"
                + "3 - Buscar por livros pegos por um usuário\n"
                + "4 - Dados de todos os livros publicados em 2020\n"
                + "5 - Lista de livros de um determinado gênero \n\n"
                + "6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static Livros cadastroLivro() {
        Livros livro = new Livros();

// TITULO DO LIVRO

        String titulo;
        do {
            titulo = JOptionPane.showInputDialog("Digite o titulo do livro:");
            if (titulo == null || titulo.trim().isEmpty()) {
                JOptionPane.showInputDialog("Digite o titulo do livro:");
            }
        } while (titulo == null || titulo.trim().isEmpty());
        livro.setTitulo(titulo);

// AUTOR

        String autor;
        do {
            autor = JOptionPane.showInputDialog("Digite o nome do autor:");
            if (autor == null || autor.trim().isEmpty()) {
                JOptionPane.showInputDialog("Digite o nome do autor:");
            }
        } while (autor == null || titulo.trim().isEmpty());
        livro.setAutor(autor);

// ANO DE PUBLICAÇÃO

        int anoDePublicacao = 0;
        boolean anoPublicacaoValido = false;
        do {
            try {
                String ano = JOptionPane.showInputDialog("Digite o ano de publicação do livro " + livro.getTitulo());
                if (ano == null) {
                    JOptionPane.showInputDialog("Digite o ano de publicação do livro " + livro.getTitulo());
                }
                anoDePublicacao = Integer.parseInt(ano);
                anoPublicacaoValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showInputDialog(null, "Insira um ano valido!");
            }
        } while (!anoPublicacaoValido);
        livro.setAnoDePublicacao(anoDePublicacao);

// GENERO

        String genero;
        do {
            genero = JOptionPane.showInputDialog("Digite o genêro do livro:" + livro.getTitulo());
            if (genero == null || genero.trim().isEmpty()) {
                JOptionPane.showInputDialog("Digite o genêro do livro:" + livro.getTitulo());
            }
        } while (genero == null || titulo.trim().isEmpty());
        livro.setGenero(genero);

// ISBN

        long isbn = 0; // LONG POIS INT NÃO FUNCIONOU CORRETAMENTE PELA QUANTIDADE DE NUMEROS
        boolean isbnNum = false;
        do {
            try {
                String numIsbn = JOptionPane.showInputDialog("Digite o ISBN do livro\nSérie de 13 números inteiros: " + livro.getNumeroDeLivroPadraoInternacional_ISBN());
                if (numIsbn == null) {
                    JOptionPane.showInputDialog("Digite o ISBN do livro\nSérie de 13 números inteiros: " + livro.getNumeroDeLivroPadraoInternacional_ISBN());
                }
                if (numIsbn.length() != 13) {
                    throw new NumberFormatException(); // ISBN deve ter 13 dígitos
                }

                isbn = Long.parseLong(numIsbn); // usa long para ISBN
                isbnNum = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um ISBN válido de 13 dígitos!");
            }
        } while (!isbnNum);

        livro.setNumeroDeLivroPadraoInternacional_ISBN(isbn);

// PESSOAS QUE PEGARAM O LIVRO

        int n = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de pessoas que pegaram o livro emprestado: "));
        String[] pessoasQuePegaramLivroEmprestado = new String[n];

        for (int i = 0; i < n; i++) {
            pessoasQuePegaramLivroEmprestado[i] = JOptionPane.showInputDialog("Digite o nome da pessoa n° " + (i + 1) + ": ");

        }
        livro.setPessoasQuePegaramLivroEmprestado(pessoasQuePegaramLivroEmprestado);
        return livro;
    }

//================================================

    private static void localizarLivroISBN_mostrarPessoas(ArrayList<Livros> livros) { // mostra as pessoas que ja pegaram os livros - usar um array
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!");
            return;
        }

    }

    private static void usuario_livros(ArrayList<Livros> livros) { // mostra os livros que fulano pegou
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!");
            return;
        }

        String nomeUsuarioLivro = JOptionPane.showInputDialog("Digite o nome do usuário:");

        if (nomeUsuarioLivro == null || nomeUsuarioLivro.trim().isEmpty()){

        }

    }

    private static void livrosPublicadosEm2020(ArrayList<Livros> livros) { // livros publicados no ano de 2020
        if (livros.isEmpty()){
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado!");
            return;
        }
        ArrayList<Livros>livro2020 = new ArrayList<>();
        for (Livros livro : livros){
            if (livro.getAnoDePublicacao() == 2020){
                livro2020.add(livro);
            }
        }
        if (livro2020.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro do ano de 2020 cadastrado!");
            return;
        }

        StringBuilder livro2020msg = new StringBuilder("Livros publicados em 2020:\n");
        for (Livros livro : livro2020){
            livro2020msg.append(livro.toString2020()).append("\n");
        }
        JOptionPane.showMessageDialog(null, livro2020msg.toString());
    }

    private static void livrosPorGenero(ArrayList<Livros> livros) { // filtra os livros por generos



    }
}
