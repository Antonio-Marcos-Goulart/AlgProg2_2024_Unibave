package matriz;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class Exercicio01_MediaDeNotasAlunos {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#.##");
        Random rand = new Random();

        String alunosInput = JOptionPane.showInputDialog(null, "Digite a quantidade de Alunos:");
        int alunosCount = Integer.parseInt(alunosInput);

        String[] nomesAlunos = new String[alunosCount];

        for (int i = 0; i < alunosCount; i++) {
            nomesAlunos[i] = JOptionPane.showInputDialog(null, "Digite o nome do aluno " + (i + 1) + ":");
        }

        String quntNotasInput = JOptionPane.showInputDialog(null, "Digite a quantidade de notas:");
        int quntNotas = Integer.parseInt(quntNotasInput);

        double[][] notas = new double[alunosCount][quntNotas];

        for (int i = 0; i < alunosCount; i++) {
            for(int j = 0; j < quntNotas; j++) {
                double nota = rand.nextDouble() * 10.00; // rand para gerar uma nota aleatória entre 0.00 - 10.00
                notas[i][j] = nota;
            }
        }

        StringBuilder mensagem = new StringBuilder();
        for(int i = 0; i < alunosCount; i++) {
            double soma = 0;
            for (int j = 0; j < quntNotas; j++) {
                soma += notas[i][j];
            }
            double mediaNotas = soma / quntNotas;
            mensagem.append("\nAluno ").append(nomesAlunos[i]).append(". Média do aluno: ").append(df.format(mediaNotas));
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }
}


/*
UMA TURMA COM N ALUNOS REALIZOU N PROVAS.
FAÇA UM PROGRAMA QUE LEIA TODAS AS NOTAS E NO FINAL MOSTRE A MÉDIA DE CADA ALUNO
(TRATAR ALUNO COMO 1,2,3...)
 */