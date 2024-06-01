package heterogeneos;

import javax.swing.*;

public class indice_de_massa_corporal_IMC {
    public static void main(String[] args) {


        int n = 100;
        String[] nome = new String[n];
        double[] peso = new double[n];
        double[] altura = new double[n];
        double[] imc = new double[n];
        int count = 0;

        int op;
        do {
            op = menu();
            if (op == 1) cadastrar_pessoa(nome, peso, altura,imc, count++);
            if (op == 2) buscar_por_nome(nome, peso, altura, imc, count);
            if (op == 3) pessoas_cadastradas(nome, peso, altura,imc, count);
            if (op == 4) nome_pessoa_maior_imc(nome, peso, altura, imc, count);
            if (op == 5) nome_pessoa_menor_imc(nome, peso, altura, imc, count);
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

    private static void cadastrar_pessoa(String[] nome, double[] peso, double[] altura, double[] imc, int count) {
        if (count < nome.length) {

// NOME ========

            String nomePessoa;
            do {
                nomePessoa = JOptionPane.showInputDialog("Nome da pessoa:");
                if (nomePessoa == null || nomePessoa.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o nome da pessoa.");
                }
            } while (nomePessoa == null || nomePessoa.trim().isEmpty());

            nome[count] = nomePessoa; // ARMAZENA O NOME NO ARRAY NOME, NA POSIÇÃO COUNT

// PESO =======

            boolean pesoPessoa = false;
            while (!pesoPessoa){
                try {
                    String iserePeso = JOptionPane.showInputDialog("Peso da pessoa em Kg: ");
                    if (iserePeso == null || iserePeso.isEmpty()){
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira o peso da pessoa novamente.");

                    } else {
                        double pesoCad = Double.parseDouble(iserePeso);
                        if (pesoCad > 0.0) {
                            peso[count] = pesoCad; // ARMAZENA O PESO NO ARRAY PESO, NA POSIÇÃO COUNT
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

            boolean alturaPessoa = false;
            while (!alturaPessoa){
                try {
                    String insereAltura = JOptionPane.showInputDialog("Altura da pessoa em metros: ");
                    if (insereAltura == null || insereAltura.isEmpty()){
                        JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Insira a altura da pessoa novamente.");

                    } else {
                        double alturaCad = Double.parseDouble(insereAltura);
                        if (alturaCad > 0.00) {
                            altura[count] = alturaCad;  // ARMAZENA A ALTURA NO ARRAY ALTURA, NA POSIÇÃO COUNT
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
        return peso / (altura * altura); // CALCULO DO IMC, USANDO O PESO / ALTURA * ALTURA
    }

    private static void buscar_por_nome(String[] nome, double[] peso, double[] altura, double[] imc,  int count) {
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
                msg.append("Nome: ").append(nome[i]).append("\n");
                msg.append("Peso: ").append(String.format("%.2f",peso[i])).append(" Kg").append("\n");
                msg.append("Altura: ").append(String.format("%.2f",altura[i])).append(" m").append("\n");
                msg.append("IMC: ").append(String.format("%.2f",imc[i]));

                JOptionPane.showMessageDialog(null, msg.toString());
                break;
            }
        }
        if (!pessoa_Encontrada) {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada.");
        }
    }

    private static void pessoas_cadastradas(String[] nome, double[] peso, double[] altura, double[] imc, int count) {
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

    private static void nome_pessoa_maior_imc(String[] nome, double[] peso, double[] altura, double[] imc, int count) {
        if (count == 0 ){
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada");
            return;
        }
        double maiorIMC = Double.MIN_VALUE; // INICIALIZA O MENOR IMC COM O MAIOR VALOR, GARANTINDO QUE O QUE ESTA SENDO BUSCADO SEJA MAIOR
        int indiceMaiorIMC = -1;
        
        StringBuilder msgMaiorIMC = new StringBuilder();
        msgMaiorIMC.append("Pessoa com maior IMC:\n");
        for (int i = 0; i < count; i++ ){
            if (imc[i] > maiorIMC){
                maiorIMC = imc[i];
                indiceMaiorIMC = i;
            }
        }
        if (indiceMaiorIMC != -1){
            msgMaiorIMC.append("Nome: ").append(nome[indiceMaiorIMC]).append("\n");
            msgMaiorIMC.append("Peso: ").append(String.format("%.2f",peso[indiceMaiorIMC])).append(" Kg").append("\n");
            msgMaiorIMC.append("Altura: ").append(String.format("%.2f",altura[indiceMaiorIMC])).append(" m").append("\n");
            msgMaiorIMC.append("IMC: ").append(String.format("%.2f",imc[indiceMaiorIMC]));
            JOptionPane.showMessageDialog(null, msgMaiorIMC);
        }
    }

    private static void nome_pessoa_menor_imc(String[] nome, double[] peso, double[] altura, double[] imc, int count) {
        if (count == 0 ){
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada");
            return;
        }
        double menorIMC = Double.MAX_VALUE; // INICIALIZA O MAIOR IMC COM O MAIOR VALOR, GARANTINDO QUE O QUE ESTA SENDO BUSCADO SEJA MENOR
        int indiceMenorIMC = -1;

        StringBuilder msgMenorIMC = new StringBuilder();
        msgMenorIMC.append("Pessoa com menor IMC:\n");
        for (int i = 0; i < count; i++ ){
            if (imc[i] < menorIMC){
                menorIMC = imc[i];
                indiceMenorIMC = i;
            }
        }
        if (indiceMenorIMC != -1){
            msgMenorIMC.append("Nome: ").append(nome[indiceMenorIMC]).append("\n");
            msgMenorIMC.append("Peso: ").append(String.format("%.2f",peso[indiceMenorIMC])).append(" Kg").append("\n");
            msgMenorIMC.append("Altura: ").append(String.format("%.2f",altura[indiceMenorIMC])).append(" m").append("\n");
            msgMenorIMC.append("IMC: ").append(String.format("%.2f",imc[indiceMenorIMC]));
            JOptionPane.showMessageDialog(null,msgMenorIMC );
        }
    }
}