package heterogeneos;

import javax.swing.*;

public class indice_de_massa_corporal {
    public static void main(String[] args) {


        int n = 100;
        String[] nome = new String[n];
        double[] peso = new double[n];
        double[] altura = new double[n];
        double[] imc = new double[n];
        String[] classificacao = new String[n];
        int count = 0;

        int op;
        do {
            op = menu();
            if (op == 1) cadastrar_pessoa(nome, peso, altura,imc, classificacao, count++);
            if (op == 2) buscar_por_nome(nome, peso, altura, imc, classificacao, count);
            if (op == 3) pessoas_cadastradas(nome, peso, altura,imc, classificacao, count);
            if (op == 4) nome_pessoa_maior_imc(nome, peso, altura, imc,classificacao, count);
            if (op == 5) nome_pessoa_menor_imc(nome, peso, altura, imc, classificacao, count);
        } while (op != 6);
    }



    private static int menu() {
        String m = "1 - Cadastrar pessoa \n"
                + "2 - Buscar por nome \n"
                + "3 - Exibir todas as pessoas cadastradas\n"
                + "4 - Nome da pessoa com o maior ICM \n"
                + "5 - Nome da pessoa com o menor ICM \n"
                + "6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void cadastrar_pessoa(String[] nome, double[] peso, double[] altura, double[] imc, String[] classificacao, int count) {
        if (count < nome.length) {

// NOME ========

            String nomePessoa;
            do {
                nomePessoa = JOptionPane.showInputDialog("Nome da pessoa:");
                if (nomePessoa == null || nomePessoa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o nome da pessoa.");
                }
            } while (nomePessoa == null || nomePessoa.trim().isEmpty());

            nome[count] = nomePessoa;

// PESO =======

            Boolean pesoPessoa = false;
            while (!pesoPessoa){
                try {
                    String iserePeso = JOptionPane.showInputDialog("Peso da pessoa em Kg: ");
                    if (iserePeso == null || iserePeso.isEmpty()){
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o peso da pessoa novamente.");

                    } else {
                        double pesoCad = Double.parseDouble(iserePeso);
                        if (pesoCad > 0.0) {
                            peso[count] = pesoCad;
                            pesoPessoa = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "ERRO: Valor inválido. Insira um peso maior que 0.0 kg");
                        }
                    }
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Insira o peso da pessoa novamente.");
                }
            }

// ALTURA =====

            Boolean alturaPessoa = false;
            while (!alturaPessoa){
                try {
                    String insereAltura = JOptionPane.showInputDialog("Altura da pessoa em metros: ");
                    if (insereAltura == null || insereAltura.isEmpty()){
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira a altura da pessoa novamente.");

                    } else {
                        double alturaCad = Double.parseDouble(insereAltura);
                        if (alturaCad > 0.00) {
                            altura[count] = alturaCad;
                            alturaPessoa = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "ERRO: Valor inválido. Insira uma altura maior que 0.0 m ");
                        }
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada inválida. Insira a altura novamente.");
                }
            }
            imc[count] = calcularIMC(peso[count], altura[count]);
        }
    }

    private static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    private static void buscar_por_nome(String[] nome, double[] peso, double[] altura, double[] imc, String[] classificacao, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.");
            return;
        }
        String nomeBusca = JOptionPane.showInputDialog("Digite o nome da pessoa:");
        boolean pessoa_Encontrada = false;

        for (int i = 0; i < count; i++) {
            if (nome[i] != null && nome[i].equalsIgnoreCase(nomeBusca)) {
                pessoa_Encontrada = true;

                StringBuilder msg = new StringBuilder();
                msg.append("> Nome: ").append(nome[i]).append("\n");
                msg.append("> Peso: ").append(String.format("%.2f",peso[i])).append(" Kg").append("\n");
                msg.append("> Altura: ").append(String.format("%.2f",altura[i])).append(" m").append("\n");
                msg.append("> IMC: ").append(String.format("%.2f",imc[i]));

                JOptionPane.showMessageDialog(null, msg.toString());
                break;
            }
        }
        if (!pessoa_Encontrada) {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
        }
    }

    private static void pessoas_cadastradas(String[] nome, double[] peso, double[] altura, double[] imc, String[] classificacao, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado.");
            return;
        }
        StringBuilder estoqueStr = new StringBuilder();
        estoqueStr.append("Pessoas cadastradas:\n");
        for (int i = 0; i < count; i++) {
            estoqueStr.append("Nome: ").append(nome[i]).append(" - ").append("Altura: ").append(altura[i]).append(" m - ").append("Peso: ").append(peso[i]).append(" kg - ").append("IMC: ").append(String.format("%.2f", imc[i])).append("\n");
        }
        JOptionPane.showMessageDialog(null, estoqueStr.toString());
    }

    private static void nome_pessoa_maior_imc(String[] nome, double[] peso, double[] altura, double[] imc, String[] classificacao, int count) {

    }

    private static void nome_pessoa_menor_imc(String[] nome, double[] peso, double[] altura, double[] imc, String[] classificacao, int count) {

    }
}






