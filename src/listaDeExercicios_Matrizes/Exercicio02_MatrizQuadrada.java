package listaDeExercicios_Matrizes;

import javax.swing.*;

public class Exercicio02_MatrizQuadrada {
    public static void main(String[] args) {

        int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho:"));

        String[][] matriz = new String[tamanho][tamanho];

        JOptionPane.showMessageDialog(null, "Digite as palavras:");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matriz[i][j] = JOptionPane.showInputDialog("Digite a palavra na posição [" + i + "][" + j + "]:");
            }
        }

        StringBuilder matrizString = new StringBuilder("Matriz armazenada:\n");
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                matrizString.append(matriz[i][j]).append(" ");
            }
            matrizString.append("\n");
        }

        JOptionPane.showMessageDialog(null, matrizString.toString());
    }
}