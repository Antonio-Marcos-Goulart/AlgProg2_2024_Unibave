package avaliacao_3.questao_1;

import javax.swing.*;
import java.util.ArrayList;

public class CadLivros {
    public static void main(String[] args) {
        ArrayList<Livros> livros = new ArrayList<Livros>();

        int op = 0;

        do{
            op = menu();
            if(op==1) livros.add(cadLivro());

        }while (op!=6);
    }

    private static int menu() {
        String m = "1 - Cadastrar livro\n"
                + "2 - Localizar livro pelo ISBN e mostrar pessoas que ja pegaram o livro emprestado\n"
                + "3 - Buscar por livros pegos por um usuário\n"
                + "4 - Dados de todos os livros publicados em 2020\n"
                + "5 - Lista de livros de um determinado gênero \n\n"
                + "6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(null, m));
    }

    //exibir mensagem
    public static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }
    //cadastro de dados do livro
    public static String lerString(String txt) {
        String recString = JOptionPane.showInputDialog(txt);
        if(recString.trim().isEmpty()||recString.length()<=3) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerString(txt);
        } else {
            return recString;
        }
    }

    public static int lerInt(String txt) {
        int recInt = Integer.parseInt(JOptionPane.showInputDialog(txt));
        if(recInt <= 0 ) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerInt(txt);
        }else {
            return recInt;
        }
    }

    public static long lerLong(String txt) {
        long recLong = Long.parseLong(JOptionPane.showInputDialog(txt));
        if (Long.toString(recLong).length() != 13) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerLong(txt);
        } else {
            return recLong;
        }
    }

// CADASTRO DO LIVRO
    public static Livros cadLivro() {
        Livros lv = new Livros();
        int emp = 0;
        lv.titulos = lerString("Título:");
        lv.autores = lerString("Autores:");
        lv.anoDePublicacao = lerInt("Ano de publicação");
        lv.generos = lerString("Gênero:");
        lv.ISBNs = lerLong("ISBN:");

        do {
            emp = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Cadastrar novo empréstimo
                    2 - Sair
                    """));
            if (emp == 1) {
                lv.nomeEmprestimos.add(lerString("Nome de quem pegou emprestado:"));
            }
        } while (emp != 2);
        return lv;
    }
}