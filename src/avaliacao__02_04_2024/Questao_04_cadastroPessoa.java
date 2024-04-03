package avaliacao__02_04_2024;

import javax.swing.*;

public class Questao_04_cadastroPessoa {
    public static void main(String[] args) {

        String menu = "1 - Cadastrar pessoa\n"
                + "2 - Buscar pessoa por nome\n"
                + "3 - Buscar pessoa por CPF\n"
                + "4 - Sair";

        int op = 0;
        String[] nome = new String[100];
        String[] cpf = new String[100];
        int pessoas = 0;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (op == 1) {
                String quantPessoas = JOptionPane.showInputDialog("Digite a quantidade de pessoas a serem cadastradas (máximo 100): ");
                int n = Integer.parseInt(quantPessoas);

                if (pessoas + n <= 100) {
                    for (int i = 0; i < n; i++) {
                        nome[pessoas] = JOptionPane.showInputDialog("Nome:");
                        cpf[pessoas] = JOptionPane.showInputDialog("Número de CPF " + nome[pessoas] + ": ");
                        pessoas++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "A quantidade de cadastros excede o limite máximo de 100 cadastros!");
                }
            }

            if (op == 2) {
                String buscarPorNome = JOptionPane.showInputDialog("Insira o nome da pessoa que deseja buscar:");
                boolean encontrado = false;
                for (int i = 0; i < pessoas; i++) {
                    if (nome[i] != null && nome[i].equalsIgnoreCase(buscarPorNome)) {
                        JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nCPF: " + cpf[i]);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Pessoa não encontrada!");
                }
            }

            if (op == 3) {
                String buscarCPF = JOptionPane.showInputDialog("Insira o CPF da pessoa que deseja buscar:");
                boolean encontrado = false;
                for (int i = 0; i < pessoas; i++) {
                    if (cpf[i] != null && cpf[i].equals(buscarCPF)) {
                        JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nCPF: " + cpf[i]);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "CPF não encontrado!");
                }
            }
        } while (op != 4);
        JOptionPane.showMessageDialog(null, "Programa encerrado");
    }
}