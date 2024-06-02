package metodos.procedimentos_e_funcoes;

import metododos_e_procedimentos.procedimentos_e_funcoes.jogador.JogadorFut;

import javax.swing.*;
import java.util.ArrayList;

public class JogadorFutebol {
    public static void main(String[] args) {

        ArrayList<JogadorFut> jogador = new ArrayList<JogadorFut>();

        int op =0;
        do{
            op = menu();
            if (op == 1) jogador.add(cadastroJogador());
            if (op == 2) jogador.add(jogadorComMaisGols());
            if (op == 3) jogador.add(JogadorComMenosGols());
            if (op == 4) jogador.add(GoleirosQueFizeramGol());
            if (op == 5) jogador.add(camisas10());
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
        JogadorFut jogador = new JogadorFut();


        return null;
    }

    private static JogadorFut jogadorComMaisGols(){
        return null;
    }

    private static JogadorFut JogadorComMenosGols() {
        return null;
    }

    private static JogadorFut GoleirosQueFizeramGol() {
        return null;
    }

    private static JogadorFut camisas10() {
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