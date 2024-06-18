package avaliacao_3.questao_1;

import avaliacao_3.questao_1.Livros;

import javax.swing.*;
import java.util.ArrayList;

public class CadLivros {
    public static void main(String[] args) {
        ArrayList<Livros> lv = new ArrayList<>();

        int op = 0;

        do {
            op = menu();
            if (op == 1) lv.add(cadLivro());
            if (op == 2) procISBN(lv);
            if (op == 3) lvsPegosPessoa(lv);
            if (op == 4) lvsPublicados2020(lv);
            if (op == 5) lvsPorGenero(lv);
        } while (op != 6);
    }

    public static int menu() {
        String op = """
                1 - Cadastrar livro
                2 - Localizar livro pelo ISBN e mostrar pessoas que já pegaram o livro emprestado
                3 - Buscar por livros pegos por um usuário
                4 - Dados de todos os livros publicados em 2020
                5 - Lista de livros de um determinado gênero
                6 - SAIR
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(null, op));
    }

    // exibir mensagem
    public static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    public static String exibirLivro(Livros lv) {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(lv.titulos).append("\n")
                .append("Gênero: ").append(lv.generos).append("\n")
                .append("Autor: ").append(lv.autores).append("\n")
                .append("Ano de publicação: ").append(lv.anoDePublicacao).append("\n")
                .append("ISBN: ").append(lv.ISBNs).append("\n")
                .append("Nome de quem pegou emprestado: ");
        if (lv.emprestimo.isEmpty()) {
            sb.append("Nenhum empréstimo registrado.");
        } else {
            for (String nome : lv.emprestimo) {
                sb.append(nome).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    //receber string e verificar se está nos padrões
    public static String lerString(String txt) {
        String recString = JOptionPane.showInputDialog(txt);
        if (recString.trim().isEmpty() || recString.length() <= 3) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerString(txt);
        } else {
            return recString;
        }
    }
    //recebe valores inteiros e verifica se são positivos
    public static int lerInt(String txt) {
        int recInt = Integer.parseInt(JOptionPane.showInputDialog(txt));
        if (recInt <= 0) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerInt(txt);
        } else {
            return recInt;
        }
    }
    // recebe long pois int não é suficiente para 13 digitos
    public static long lerLong(String txt) {
        long recLong = Long.parseLong(JOptionPane.showInputDialog(txt));
        if (Long.toString(recLong).length() != 13) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerLong(txt);
        } else {
            return recLong;
        }
    }

    public static Livros cadLivro() {
        Livros livro = new Livros();
        livro.titulos = lerString("Título:");
        livro.autores = lerString("Autores:");
        livro.anoDePublicacao = lerInt("Ano de publicação:");
        livro.generos = lerString("Gênero:");
        livro.ISBNs = lerLong("ISBN:");

        int emp;
        do {
            emp = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Cadastrar novo empréstimo
                    2 - Sair
                    """));
            if (emp == 1) {
                livro.emprestimo.add(lerString("Nome de quem pegou emprestado:"));
            }
        } while (emp != 2);
        return livro;
    }

    public static void procISBN(ArrayList<Livros> lv) {
        long recLong = lerLong("Código ISBN: ");
        for (Livros l : lv) {
            if (l.ISBNs == recLong) {
                msg(exibirLivro(l));
                return;  // Retornar após encontrar o livro
            }
        }
        msg("Livro não encontrado!");
    }

    public static void lvsPegosPessoa(ArrayList<Livros> lv) {
        String nome = lerString("Nome de quem deseja buscar: ");
        StringBuilder sb = new StringBuilder("Livros pegos por " + nome + ":\n");

        boolean encontrou = false;
        for (Livros l : lv) {
            if (l.emprestimo.contains(nome)) {
                sb.append(l.titulos).append("\n");
                encontrou = true;
            }
        }

        if (!encontrou) {
            sb.append("Nenhum livro encontrado para ").append(nome);
        }

        msg(sb.toString());
    }

    public static void lvsPublicados2020(ArrayList<Livros> lv) {
        StringBuilder sb = new StringBuilder("Livros publicados em 2020\n");
        boolean cad2020 = false;

        for(Livros l : lv) {
            if(l.anoDePublicacao == 2020) {
                sb.append(l.titulos + "\n");
                cad2020 = true;
            }
        }

        if(!cad2020) {
            sb.append("Nenhum livro cadastrado com ano de publicação de 2020");
        }
        msg(sb.toString());

    }

    public static void lvsPorGenero(ArrayList<Livros> lv) {
        String recGenero = lerString("Genero que deseja pessquisar: ");
        StringBuilder sb = new StringBuilder("Livros do gênero " + recGenero + "\n");
        boolean isGenero = false;
        for(Livros l : lv) {
            if(l.generos.equalsIgnoreCase(recGenero)) {
                sb.append(l.titulos + "\n");
                isGenero = true;
            }
        }
        if (!isGenero) {
            sb.append("Nenhum livro cadastrado com o gênero " + recGenero);
        }
        msg(sb.toString());

    }
}