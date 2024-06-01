package metodos.procedimentos_e_funcoes;

import javax.swing.*;
import java.text.DecimalFormat;

public class Exercicio_01_CadastroPessoa {
    public static void main(String[] args) {

        int n = 100;
        String[] nome = new String[n];
        int[] idade = new int[n];
        char[] sexo = new char[n];
        int count = 0;

        int op;
        do {
            op = menu();
            if (op == 1) cadastrarPessoa(nome, idade, sexo, count++);
            if (op == 2) buscarPorNome(nome, idade, sexo, count++);
            if (op == 3) mediaIdadeSexoMasculino(idade, sexo, count++); // NÃO É UMA BOA PRATICA, USEI O MESMO CÓDIGO PARA 2 FUNÇÕES >> if(op == 3) mediaIdades(idades, sexos, count, "M");
            if (op == 4) mediaIdadesSexoFeminino(idade, sexo, count++); // NÃO É UMA BOA PRATICA, USEI O MESMO CÓDIGO PARA 2 FUNÇÕES >> if(op == 4) mediaIdades(idades, sexos, count, "F");
            if (op == 5) quantidadeDeMulheresComMenos18(sexo, count++);
        } while (op != 6);;
    }


    private static int menu() {
        String m = "1 - Cadastrar pessoa\n"
                   +"2 - Buscar por nome\n"
                   +"3 - Média idade homens\n"
                   +"4 - Média idade mulheres\n"
                   +"5 - Quantidade de mulheres com menos de 18 anos\n\n"

                   +"6 - SAIR";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void cadastrarPessoa(String[] nome, int[] idade, char[] sexo, int count) {
        if (count < nome.length) {
            nome[count] = JOptionPane.showInputDialog("Nome: ");
            idade[count] = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
            String inputSexo = JOptionPane.showInputDialog("Sexo (M/F): "); //Converte para maiúscula para garantir 'M' ou 'F'
            sexo[count] = inputSexo.toUpperCase().charAt(0);
            if (sexo[count] != 'M' && sexo[count] != 'F') {
                JOptionPane.showMessageDialog(null, "Entrada inválida para sexo. Por favor, insira 'M' ou 'F'.");
                return;
            }
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "MEMÓRIA CHEIA");
        }
    }

    private static void buscarPorNome(String[] nome, int[] idade, char[] sexo, int count) {
        String busca = JOptionPane.showInputDialog("Digite o nome para buscar:");
        boolean encontrado = false;

        for (int i = 0; i < count; i++) {
            if (nome[i].equalsIgnoreCase(busca)) {
                String mensagem = "Nome: " + nome[i] + "\n" +
                                  "Idade: " + idade[i] + "\n" +
                                  "Sexo: " + sexo[i];
                JOptionPane.showMessageDialog(null, mensagem);
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            JOptionPane.showMessageDialog(null, "NENHUMA PESSOA ENCONTRADA COM O NOME\n" + busca);
        }
    }

    private static void mediaIdadeSexoMasculino (int[] idade, char[] sexo, int count) {
        int SomaIdadesMasc = 0;
        int homens = 0;

        for (int i = 0; i < count; i++){
            if (sexo[i] == 'M' || sexo[i] == 'm'){
                SomaIdadesMasc += idade[i]; // ARMAZENA INF.
                homens++;
            }
        }
        if (homens > 0){
            double mediaMasc = (double) SomaIdadesMasc/homens;
            DecimalFormat df = new DecimalFormat("0.00"); // Formato para duas casas decimais
            String mediaComValorFormatado = df.format(mediaMasc);
            JOptionPane.showMessageDialog(null, "Média de idade dos homens é de:\n" + mediaComValorFormatado + " anos");
        } else {
            JOptionPane.showMessageDialog(null, "Sem registros de idade para homens\n" + "Não foi possível calcular a média.");
        }
    }

    private static void mediaIdadesSexoFeminino(int[] idade, char[] sexo, int count) {

        int SomaIdadesFem = 0;
        int mulheres = 0;

        for (int i = 0; i < count; i++){
            if (sexo[i] == 'F' || sexo[i] == 'f'){
                SomaIdadesFem += idade[i]; // ARMAZENA A INF
                mulheres++;
            }
        }
        if (mulheres > 0){
            double mediaFem = (double) SomaIdadesFem/mulheres;
            DecimalFormat df = new DecimalFormat("0.00"); // Formato para duas casas decimais
            String mediaComValorFormatado = df.format(mediaFem);
            JOptionPane.showMessageDialog(null, "Média de idade das mulheres é de:\n" + mediaComValorFormatado + " anos");
        } else {
            JOptionPane.showMessageDialog(null, "Sem registros de idade para mulheres\n" + "Não foi possível calcular a média.");
        }
    }

    private static void quantidadeDeMulheresComMenos18(char[] sexo, int count) {

        int mulheresMenos18 = 0;

        for (int i = 0; i < count; i++) {
            if (sexo[i] == 'F' || sexo[i] == 'f') {
                mulheresMenos18++;
            }
        }
        JOptionPane.showMessageDialog(null, "Quantidade de mulheres com menos de 18 anos\n" + mulheresMenos18);
    }
}

/*
 Faça um programa que apresente o seguinte menu:
1 - Cadastrar pessoa (nome, idade e sexo)
2 - Buscar por nome
3 - Média das idades dos homens
4 - Média das idades das mulheres
5 - Quantidade de mulheres com menos de 18 anos
6 - Sair
Deve ser utilizado sub-rotinas.
 */

