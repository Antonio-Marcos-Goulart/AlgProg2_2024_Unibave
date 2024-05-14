package avaliacao_Vetor_02_04_2024;

import javax.swing.*;
public class Questao_03_operacoesMatematicas {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho dos vetores:"));

        int[] vetorA = new int[n];
        int[] vetorB = new int[n];

        JOptionPane.showMessageDialog(null, "Digite os elementos do vetor A:");
        for (int i = 0; i < n; i++) {
            vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog("Elemento " + (i + 1) + " do vetor A:"));
        }

        JOptionPane.showMessageDialog(null, "Digite os elementos do vetor B:");
        for (int i = 0; i < n; i++) {
            vetorB[i] = Integer.parseInt(JOptionPane.showInputDialog("Elemento " + (i + 1) + " do vetor B:"));
        }

        StringBuilder saidaResultados = new StringBuilder();
        saidaResultados.append("Operações:\n\n");
        for (int i = 0; i < n; i++) {
            saidaResultados.append("Elementos: ");
            saidaResultados.append(vetorA[i]).append(" e ").append(vetorB[i]).append("\n");

            saidaResultados.append("Soma: ").append(vetorA[i] + vetorB[i]).append("\n");
            saidaResultados.append("Subtração: ").append(vetorA[i] - vetorB[i]).append("\n");
            saidaResultados.append("Multiplicação: ").append(vetorA[i] * vetorB[i]).append("\n");
            if (vetorB[i] != 0) {
                saidaResultados.append("Divisão: ").append((double) vetorA[i] / vetorB[i]).append("\n\n");
            } else {
                saidaResultados.append("DIVISÃO POR ZERO É COMPLICADO \n(╯°□°）╯︵ ┻━┻\n");
            }
            saidaResultados.append("\n");
        }
        JOptionPane.showMessageDialog(null, saidaResultados.toString());
    }
}