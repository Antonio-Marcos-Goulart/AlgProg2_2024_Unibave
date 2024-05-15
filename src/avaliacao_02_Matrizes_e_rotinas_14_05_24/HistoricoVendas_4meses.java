package avaliacao_02_Matrizes_e_rotinas_14_05_24;

import javax.swing.*;
import java.util.Random;

public class HistoricoVendas_4meses {
    public static void main(String[] args) {

        int n = 100; // quantidade de produtos que podem ser cadastradas
        String[] nomeProduto = new String[n];
        int[] quantidade = new int[n];
        double[] precoProduto = new double[n];
        int[][] vendasProdutos = new int[n][4];
        int count = 0;

        int op;
        do {
            op = menu();
            if (op == 1) cadastrarProduto(nomeProduto, quantidade, precoProduto, vendasProdutos, count++);
            if (op == 2) buscarPorNome(nomeProduto, precoProduto, vendasProdutos, count);
            if (op == 3) totalDeVendas(nomeProduto, vendasProdutos, precoProduto, count);
            if (op == 4) estoque(nomeProduto, quantidade, count);
        } while (op != 5);
    }

    private static int menu() {
        String m = "1 - Cadastrar Produto \n"
                + "2 - Buscar por nome \n"
                + "3 - Exibir total de vendas do mês\n"
                + "4 - Mostrar estoque de todos os produtos cadastrados \n"
                + "5 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void cadastrarProduto(String[] nomeProduto, int[] quantidade, double[] precoProduto, int[][] vendasProdutos, int count) {
        if (count < nomeProduto.length) {

// NOME DO PRODUTO ========

            String nmProduto;
            do {
                nmProduto = JOptionPane.showInputDialog("Nome do produto:");
                if (nmProduto == null || nmProduto.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o nome do produto.");
                } else if (nmProduto.length() < 3) {
                    JOptionPane.showMessageDialog(null, "ERRO: O nome do produto deve ter no minimo três letras.");
                }
            } while (nmProduto == null || nmProduto.trim().isEmpty() || nmProduto.length() < 3);

            nomeProduto[count] = nmProduto;

// PREÇO DO PRODUTO ==============

            boolean precoDProduto = false;
            while (!precoDProduto) {
                try {
                    String inserePrecoProduto = JOptionPane.showInputDialog("Valor do produto em R$:");
                    if (inserePrecoProduto == null || inserePrecoProduto.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o valor do produto novamente.");
                    } else {
                        double preco = Double.parseDouble(inserePrecoProduto);
                        if (preco > 0.00) {
                            precoProduto[count] = preco;
                            precoDProduto = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "ERRO: Valor inválido. Insira um valor maior que R$ 0.00");
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Insira o valor do produto novamente.");
                }
            }

// ESTOQUE DO PRODUTO ===============

            int estoque = 0;
            boolean qtEstoque = false;
            do {
                try {
                    String quantEstoque = JOptionPane.showInputDialog("Quantidade em estoque:");
                    estoque = Integer.parseInt(quantEstoque);
                    if (estoque < 0) {
                        JOptionPane.showMessageDialog(null, "ERRO: A quantidade em estoque não pode ser negativa.");
                    } else {
                        qtEstoque = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Insira uma quantidade válida para o estoque.");
                }
            } while (!qtEstoque);
            quantidade[count] = estoque;

// VENDAS VL ALEATÓRIO ===================

            Random ranPreco = new Random();
            int[] vendas = new int[4];
            for (int i = 0; i < 4; i++) {
                vendas[i] = ranPreco.nextInt(501);
            }
            vendasProdutos[count] = vendas;
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO: Limite de produtos cadastrados .");
        }
    }

    private static void buscarPorNome(String[] nomeProduto, double[] precoProduto, int[][] vendasProdutos, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }
        String nomeBusca = JOptionPane.showInputDialog("Digite o nome do produto:");
        boolean produtoEncontrado = false;

        for (int i = 0; i < count; i++) {
            if (nomeProduto[i] != null && nomeProduto[i].equalsIgnoreCase(nomeBusca)) {
                produtoEncontrado = true;
                int mesDeVendas = 0;
                do {
                    String consultaMes = JOptionPane.showInputDialog("Digite o número do mês que deseja consultar: \n(1 a 4 - sendo 1 o mês anterior ao mês atual, e 4 mes anterior ao atual )");
                    if (consultaMes == null || consultaMes.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Insira um número de mês válido.");
                        continue;
                    }
                    mesDeVendas = Integer.parseInt(consultaMes);
                    if (mesDeVendas < 1 || mesDeVendas > 4) {
                        JOptionPane.showMessageDialog(null, "ERRO: Mês inválido. Insira um número de mês entre 1 e 4.");
                    }
                } while (mesDeVendas < 1 || mesDeVendas > 4);

                int vendasNoMes = vendasProdutos[i].length - mesDeVendas;
                int vendasMes = vendasProdutos[i][vendasNoMes];

                StringBuilder msg = new StringBuilder();
                msg.append("> Nome: ").append(nomeProduto[i]).append("\n");
                msg.append("> Preço: R$ ").append(String.format("%.2f",precoProduto[i])).append("\n");
                msg.append("> Vendas no mês ").append(mesDeVendas).append(": ").append(vendasMes).append(" unidades\n");
                JOptionPane.showMessageDialog(null, msg.toString());
                break;
            }
        }
        if (!produtoEncontrado) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado.");
        }
    }

    private static void totalDeVendas(String[] nomeProduto, int[][] vendasProdutos, double[] precoProduto, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }
        String mesStr;
        int mes = 0;
        do {
            mesStr = JOptionPane.showInputDialog("Digite o número do mês (1 a 4) que deseja consultar:");
            if (mesStr == null || mesStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Por favor, insira um número de mês válido.");
                continue;
            }
            mes = Integer.parseInt(mesStr);
            if (mes < 1 || mes > 4) {
                JOptionPane.showMessageDialog(null, "ERRO: Mês inválido. Por favor, insira um número de mês entre 1 e 4.");
            }
        } while (mes < 1 || mes > 4);

        StringBuilder msg = new StringBuilder();
        msg.append("Total de vendas no mês ").append(mes).append(":\n\n");

        double totalGeral = 0.0;
        boolean vendasNoMes = false;

        for (int i = 0; i < count; i++) {
            int vendasProduto = vendasProdutos[i][mes - 1];
            if (vendasProduto > 0) {
                vendasNoMes = true;
                double totalProduto = vendasProduto * precoProduto[i];
                msg.append("> Produto: ").append(nomeProduto[i]).append("\n");
                msg.append("> Valor por unidade: ").append(String.format("%.2f",precoProduto[i])).append("\n");
                msg.append("> Quantidade vendida: ").append(vendasProduto).append("\n");
                msg.append("> Valor total das vendas: R$ ").append(String.format("%.2f",totalProduto)).append("\n\n");
                totalGeral += totalProduto;
            }
        }

        if (!vendasNoMes) {
            msg.append("Não houve vendas para nenhum produto neste mês.");
        } else {
            msg.append("Valor total das vendas para o mês ").append(mes).append(": R$ ").append(String.format("%.2f",totalGeral));
        }
        JOptionPane.showMessageDialog(null, msg.toString());
    }

    private static void estoque(String[] nomeProduto, int[] quantidade, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }
        StringBuilder estoqueStr = new StringBuilder();
        estoqueStr.append("Estoque dos produtos cadastrados:\n");
        for (int i = 0; i < count; i++) {
            estoqueStr.append("Produto: ").append(nomeProduto[i]).append(" - ").append("Quantidade: ").append(quantidade[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, estoqueStr.toString());
    }
}

// nome, estoque, valor e  venda dos ultimos 4 meses