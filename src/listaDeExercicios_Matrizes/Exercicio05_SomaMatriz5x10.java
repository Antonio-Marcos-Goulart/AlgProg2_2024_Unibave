package listaDeExercicios_Matrizes;

import javax.print.DocFlavor;
import javax.swing.*;
import java.util.Random;

public class Exercicio05_SomaMatriz5x10 {
    public static void main(String[] args) {

        Random numRand = new Random();

        int[][] matriz1 = new int[5][10];
        int[][] matriz2 = new int[5][10];

        int soma = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                matriz1[i][j] = numRand.nextInt(100) - 1;
                matriz2[i][j] = numRand.nextInt(100) - 1;
                soma += matriz1[i][j] + matriz2 [i][j];
            }
        }
        JOptionPane.showMessageDialog(null, "Soma das matrizes:\n" + soma);

    }
}
