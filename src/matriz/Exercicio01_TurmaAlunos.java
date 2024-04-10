package matriz;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class Exercicio01_TurmaAlunos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("##.00"); // formato decimal da nota
        Random rand = new Random();

        System.out.print("Digite a quantidade de Alunos: ");
        int alunos = sc.nextInt();
        System.out.print("Digite a quantidade de notas: ");
        int quntNotas = sc.nextInt();

        double[][] notas = new double[alunos][quntNotas];

        for (int i = 0; i < alunos; i++){
            for(int j = 0; j < quntNotas; j++){
                double nota = rand.nextDouble(10.00) + 0.00; // nota min 0.00 e maxima 10.00
                notas[i][j] = nota;
            }
        }

        for(int i = 0; i < alunos; i++ ){
            double soma = 0;
            for (int j = 0; j < quntNotas; j++){
                soma += notas[i][j];
            }
            double mediaNotas = soma / quntNotas;
            System.out.println("\nAluno " + (i + 1) + ". Nota média: " + df.format(mediaNotas));
        }
        sc.close();
    }
}



/*
UMA TURMA COM N ALUNOS REALIZOU N PROVAS.
FAÇA UM PROGRAMA QUE LEIA TODAS AS NOTAS E NO FINAL MOSTRE A MÉDIA DE CADA ALUNO
(TRATAR ALUNO COMO 1,2,3...)
 */