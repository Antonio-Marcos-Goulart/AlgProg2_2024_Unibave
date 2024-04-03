package avaliacao__02_04_2024;

import javax.swing.*;

public class Questao_02_categoriaAtleta {
    public static void main(String[] args) {

        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de atletas inscritos:  "));
        String[] nome = new String[n];
        int[] idade = new int[n];
        StringBuilder str = new StringBuilder();
        String categoria = null;


        for (int i = 0; i < n; i++) {
            nome[i] = JOptionPane.showInputDialog("Digite o nome do atleta " + (i + 1) + ": ");
            idade[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do atleta " + nome[i] + ": "));
        }

        for (int i = 0; i < n; i++) {
            if (idade[i] >= 5 && idade[i] <= 7) {
                categoria = "Infantil A";
            } else if (idade[i] >= 8 && idade[i] <= 10) {
                categoria = "Infantil B";
            } else if (idade[i] >= 11 && idade[i] <= 17) {
                categoria = "Juvenil";
            }else if (idade[i] >= 18) {
                categoria = "Adulto";
            }
            str.append(nome[i]).append(" - ").append(" idade ").append(idade[i])
                    .append(" anos\n").append("Categoria: ").append(categoria).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, str.toString());
    }
}
