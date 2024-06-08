package metodos.procedimentos_e_funcoes;

import metodos.procedimentos_e_funcoes.jogador.JogadorFut;

import javax.swing.*;
import java.util.ArrayList;

public class JogadorFutebol {
    public static void main(String[] args) {

        int op =0;
        ArrayList<JogadorFut> jogador = new ArrayList<JogadorFut>();

        do{
            op = menu();
            if (op == 1) jogador.add(cadastroJogador()); // .add É USANDO SOMENTE PARA ADICIONAR ITENS A LISTA
            if (op == 2) jogadorComMaisGols(jogador);
            if (op == 3) JogadorComMenosGols(jogador);
            if (op == 4) goleirosQueFizeramGol(jogador);
            if (op == 5) camisas10(jogador);
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

    private static JogadorFut cadastroJogador() {
        JogadorFut j = new JogadorFut();

// CAD NOME ====
        String nome;
        do {
            nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
            if (nome == null || nome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira o nome do jogador");
            }
        } while (nome == null || nome.trim().isEmpty());
        j.setNome(nome);

// CAD NUM CAMISA ====
        int numCamisa = 0;
        boolean numValido = false;
        do {
            try {
                numCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa:"));
                if (numCamisa < 0) {
                    JOptionPane.showMessageDialog(null, "Número da camisa inválido\nÉ permitido somente números positivos maiores ou iguais a 0");
                } else {
                    numValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número válido");
            }
        } while (!numValido);
        j.setNumCamisa(numCamisa);

// CAD TIME ====
        String time;
        do {
            time = JOptionPane.showInputDialog("Digite o time do jogador:");
            if (time == null || time.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira o time do jogador");
            }
        } while (time == null || time.trim().isEmpty());
        j.setTime(time);

// CAD POSIÇÃO =====
        String posicao;
        do {
            posicao = JOptionPane.showInputDialog("Digite a posição do jogador:\n(atacante, zagueiro, goleiro)");
            if (posicao == null || posicao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Insira uma posição valida \n(atacante, zagueiro, goleiro).");
            }
        } while (posicao == null || posicao.trim().isEmpty());
        j.setPosicao(posicao);

// CAD QNT GOLS ====
        int qntGols = 0;
        boolean gols = false;
        do {
            try {
                qntGols = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols do jogador:"));
                if (qntGols < 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade de gols inválida\nÉ permitido somente números inteiros maiores ou iguais a 0");
                } else {
                    gols = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Insira um número válido para a quantidade de gols\nQuantidade de gols tem que ser um número maior ou igual a zero");
            }
        } while (!gols);
        j.setQntGols(qntGols);
        return j;
    }

    private static JogadorFut jogadorComMaisGols(ArrayList<JogadorFut> jogadores) {
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado!");
            return null;
        }

        JogadorFut jogadorComMaisGols = jogadores.get(0);
        for (JogadorFut jogador : jogadores) {
            if (jogador.getQntGols() > jogadorComMaisGols.getQntGols()) {
                jogadorComMaisGols = jogador;
            }
        }

        JOptionPane.showMessageDialog(null, "Jogador com mais gols\n" + jogadorComMaisGols.toString());
        return jogadorComMaisGols;
    }

    private static JogadorFut JogadorComMenosGols(ArrayList<JogadorFut> jogadores) {
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado!");
            return null;
        }

        JogadorFut jogadorComMenosGols = jogadores.get(0);
        for (JogadorFut jogador : jogadores) {
            if (jogador.getQntGols() < jogadorComMenosGols.getQntGols()) {
                jogadorComMenosGols = jogador;
            }
        }
        JOptionPane.showMessageDialog(null,"Jogador com menos gols\n" + jogadorComMenosGols.toString());
        return jogadorComMenosGols;
    }

    private static JogadorFut goleirosQueFizeramGol(ArrayList<JogadorFut> jogadores) {
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado!");
            return null;
        }

        ArrayList<JogadorFut> goleiro = new ArrayList<>();
        for (JogadorFut jogador : jogadores){
            if (jogador.getPosicao().equalsIgnoreCase("goleiro") && jogador.getQntGols() >= 0){
                goleiro.add(jogador);
            }
        }
        if (goleiro.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum goleiro cadastrado!");
            return null;
        }
       StringBuilder goleiroMsg = new StringBuilder("Goleiros que marcaram gols:\n");
        for (JogadorFut goleiros : goleiro){
            goleiroMsg.append(goleiros.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, goleiroMsg.toString());
        return null;
    }

    private static JogadorFut camisas10(ArrayList<JogadorFut> jogadores) {
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado!");
            return null;
        }
        ArrayList<JogadorFut>camisa10 = new ArrayList<>();
        for (JogadorFut jogador : jogadores){
            if (jogador.getNumCamisa() == 10){
                camisa10.add(jogador);
            }
        }
        if (camisa10.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador com a camisa 10!");
            return null;
        }
        StringBuilder camisas10Str = new StringBuilder("Jogadores com a camisa 10:\n");
        for (JogadorFut jogador : camisa10) {
            camisas10Str.append(jogador.toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, camisas10Str.toString());
        return null;
    }

}


/*


- Nome

- Número da camisa

- Posição (atacante, zagueiro, goleiro)

- Time

- Quantidade de gols marcados no campeonato


Faça um programa, utilizando registros, que tenha as seguintes opções de menu:

1 - Cadastrar Jogador

2 - Mostrar os dados do jogador que teve o maior número de gols

3 - Mostrar os dados do jogador com menor número de gols

4 - Mostrar os dados de todos os goleiros que fizeram algum gol no campeonato

5 - mostrar todos os jogadores que utilizaram a camisa número 10
 */