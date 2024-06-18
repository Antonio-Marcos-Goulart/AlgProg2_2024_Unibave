package avaliacao_3.questao_3;

import javax.swing.*;
import java.util.ArrayList;

public class CadJogosVideoGame {
    public static void main(String[] args) {
        ArrayList<Jogos> jg = new ArrayList<>();

        int op = 0;

        do {
            op = menu();
            if (op == 1) jg.add(cadJogo());
            if (op == 2) listaJogos(jg);
            if (op == 3) buscarPorPlataforma(jg);
            if (op == 4) buscarPorNota(jg);
            if (op == 5) jogoMaiorNota(jg);
        } while (op != 6);
    }

    public static int menu() {
        String op = """
                1 - Cadastrar jogo
                2 - Lista de todos os jogos 
                3 - Buscar por plataforma
                4 - Buscar por nota 
                5 - Jogo para uma plataforma, lançado em um determinado ano possui a maior nota
                6 - SAIR
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(null, op));
    }

    // MENSAGEM
    public static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    public static String exibirJogo(Jogos jg) {
        StringBuilder sb = new StringBuilder();
        sb.append("Título: ").append(jg.titulo).append("\n");
        sb.append("Plataforma: ").append(jg.plataforma).append("\n")
                .append("Ano de lançamento: ").append(jg.anoDeLancamento).append("\n")
                .append("Nota: ").append(jg.nota).append("\n");
        return sb.toString();
    }

    public static String lerString(String txt) {
        String recString = JOptionPane.showInputDialog(txt);
        if (recString == null || recString.trim().isEmpty() || recString.length() <= 3) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerString(txt);
        } else {
            return recString;
        }
    }

    public static int lerInt(String txt) {
        int recInt = Integer.parseInt(JOptionPane.showInputDialog(txt));
        return recInt;
    }

    public static Jogos cadJogo() {
        Jogos jogo = new Jogos();
        jogo.titulo = lerString("Título:");
        jogo.plataforma = lerString("Plataforma:");
        jogo.anoDeLancamento = lerInt("Ano de lançamento:");
        jogo.nota = lerInt("Nota (entre 0 e 5):");

        return jogo;
    }

    public static void listaJogos(ArrayList<Jogos> jg) {
        StringBuilder sb = new StringBuilder("Lista de todos os jogos:\n");
        for (Jogos jogo : jg) {
            sb.append(exibirJogo(jogo)).append("\n");
        }
        msg(sb.toString());
    }

    public static void buscarPorPlataforma(ArrayList<Jogos> jg) {
        String plataforma = lerString("Digite a plataforma:");
        StringBuilder sb = new StringBuilder("Jogos da plataforma " + plataforma + ":\n");
        boolean encontrou = false;
        for (Jogos jogo : jg) {
            if (jogo.plataforma.equalsIgnoreCase(plataforma)) {
                sb.append(exibirJogo(jogo)).append("\n");
                encontrou = true;
            }
        }
        if (!encontrou) {
            sb.append("Nenhum jogo encontrado para a plataforma " + plataforma);
        }
        msg(sb.toString());
    }

    public static void buscarPorNota(ArrayList<Jogos> jg) {
        int nota = lerInt("Digite a nota:");
        StringBuilder sb = new StringBuilder("Jogos com nota " + nota + ":\n");
        boolean encontrou = false;
        for (Jogos jogo : jg) {
            if (jogo.nota == nota) {
                sb.append(exibirJogo(jogo)).append("\n");
                encontrou = true;
            }
        }
        if (!encontrou) {
            sb.append("Nenhum jogo encontrado com a nota " + nota);
        }
        msg(sb.toString());
    }

    public static void jogoMaiorNota(ArrayList<Jogos> jg) {
        int ano = lerInt("Digite o ano:");
        String plataforma = lerString("Digite a plataforma:");
        Jogos jogoMaiorNota = null;
        for (Jogos jogo : jg) {
            if (jogo.anoDeLancamento == ano && jogo.plataforma.equalsIgnoreCase(plataforma)) {
                if (jogoMaiorNota == null || jogo.nota > jogoMaiorNota.nota) {
                    jogoMaiorNota = jogo;
                }
            }
        }
        if (jogoMaiorNota != null) {
            msg("O jogo com a maior nota lançado em " + ano + " para a plataforma " + plataforma + " é:\n" + exibirJogo(jogoMaiorNota));
        } else {
            msg("Nenhum jogo encontrado com as características especificadas.");
        }
    }
}