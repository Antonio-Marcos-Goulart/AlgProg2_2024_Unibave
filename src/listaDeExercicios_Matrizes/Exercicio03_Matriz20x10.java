package listaDeExercicios_Matrizes;

import javax.swing.*;
import java.util.Random;

public class Exercicio03_Matriz20x10 {
    public static void main(String[] args) {

        Random rand = new Random();

        int[][] matriz = new int[20][10];
        int[] somas = new int[20];

       StringBuilder msg = new StringBuilder("==== SOMA DOS VALORES NAS LINHAS ==== \n");

        for (int i = 0; i < 20; i++) { // linhas
            int soma = 0;
            for (int j = 0; j < 10; j++) { // colunas
                matriz[i][j] = rand.nextInt(100) ;
                soma += matriz[i][j]; // soma os valores da linha
            }
            somas[i] = soma;
            msg.append("Linha ").append(i + 1).append(": ").append(soma).append("\n");
        }
        JOptionPane.showMessageDialog(null, msg.toString(), "Somas das Linhas", JOptionPane.INFORMATION_MESSAGE);
    }
}

