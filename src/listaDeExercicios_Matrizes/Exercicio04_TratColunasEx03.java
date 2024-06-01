package listaDeExercicios_Matrizes;

import javax.swing.*;
import java.util.Random;

public class Exercicio04_TratColunasEx03 {
    public static void main(String[] args) {

        Random rand = new Random();

        int[][] matriz = new int[20][10];
        int[] somas = new int[10];

        StringBuilder msg = new StringBuilder("==== SOMA DOS VALORES NAS LINHAS ==== \n");

        for (int i = 0; i < 20; i++) { // linhas
            for (int j = 0; j < 10; j++) { // colunas
                matriz[i][j] = rand.nextInt(100);
            }
        }

    }
}
