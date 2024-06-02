package metodos.procedimentos_e_funcoes;

import javax.swing.*;

public class Exercicio_02_AlunosDisciplina {
    public static void main(String[] args) {

        int n = 20;
        String[] nome = new String[n];
        int[] idade = new int[n]; //entre 17 e 99 > tres notas
        char[] sexo = new char[n];
        double[][] notas = new double[n][3]; //tres notas entre 0 e 10
        int count = 0;

        int op;
        do {
            op = menu();
            if (op == 1) cadastrarAluno(nome, idade, sexo, notas, count++);
            if (op == 2) calcularMediaAlunos(nome, notas, count);
            if (op == 3) situacaoAlunos(nome, notas, count);
            if (op == 4) percentualMulheresHomens_Reprovados(sexo, notas, count);
            if (op == 5) mediaDeIdades(idade, count);
            if (op == 6) ListarAlunosPorSexo(nome, sexo, count);
            if (op == 7) ListarAlunosPorIdade(nome, idade, count);
        } while (op != 8);
    }
    private static int menu() {
        String m = "1 - Cadastrar aluno \n"
                + "2 - Calcular a média de todos os alunos \n"
                + "3 - Exibir alunos e se estão aprovados, reprovaos ou em recuperação \n" //(critérios: acima de 7 aprovado, abaixo de 3 reprovado)
                + "4 - Percentual de mulheres e homens reprovados \n"
                + "5 - Média das idades da turma \n"
                + "6 - Listar alunos por sexo \n"
                + "7 - Listar alunos por idade \n\n"
                + "8 - SAIR DO PROGRAMA";
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }

    private static void cadastrarAluno(String[] nome, int[] idade, char[] sexo, double[][] notas, int count) {
        if (count < nome.length) {

    // CAD -- NOME ===========================================================================================================
            String nm;
            nm = JOptionPane.showInputDialog("Nome do aluno: ");

            while (nm == null || nm.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERRO: Entrada vazia. Por favor, insira o nome do aluno");
                nm = JOptionPane.showInputDialog("Nome do aluno:");
            }
            nome[count] = nm;

    // CAD -- IDADE ===========================================================================================================
            boolean entradaIdade = false;
            while (!entradaIdade) {
                try {
                    String inputIdade = JOptionPane.showInputDialog("Idade do aluno (entre 17 e 99):");
                    if (inputIdade == null || inputIdade.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "ERRO:\nEntrada vazia. Por favor, insira uma idade entre 17 e 99.");
                        return;
                    }
                    int idadeAluno = Integer.parseInt(inputIdade);
                    if (idadeAluno >= 17 && idadeAluno <= 99) {
                        idade[count] = idadeAluno;
                        entradaIdade = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "ERRO:\nIdade inválida. Insira um número entre 17 e 99.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "ERRO:\nEntrada inválida. Por favor, insira um número entre 17 e 99.");
                }
            }

    // CAD -- SEXO ============================================================================================================
            boolean entradaSexo = false;
            while (!entradaSexo) {
                try {
                    String inputSexo = JOptionPane.showInputDialog("Sexo (M/F): ");
                    char sexoChar = inputSexo.toUpperCase().charAt(0);

                    if (sexoChar == 'M' || sexoChar == 'F') {
                        sexo[count] = sexoChar;
                        entradaSexo = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrada inválida para sexo. Por favor, insira 'M' ou 'F'.");
                    }
                } catch (RuntimeException e) {
                    JOptionPane.showMessageDialog(null, "ERRO:\nEntrada inválida. Por favor, insira 'M' ou 'F'.");
                }
            }

    // CAD -- NOTAS ===========================================================================================================
            for (int i = 0; i < 3; i++) {
                boolean entradaValida = false;
                while (!entradaValida) {
                    try {
                        String inputNota = JOptionPane.showInputDialog("Digite a " + (i + 1) + "° nota do aluno (0 a 10):");
                        double nota = Double.parseDouble(inputNota);
                        if (nota < 0 || nota > 10) {
                            JOptionPane.showMessageDialog(null, "Nota inválida. Insira uma nota entre 0 e 10.");
                        } else {
                            notas[count][i] = nota;
                            entradaValida = true;
                        }
                    } catch (RuntimeException e) {
                        JOptionPane.showMessageDialog(null, "ERRO:\nEntrada inválida. Por favor, Insira uma nota entre 0 e 10.");
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Número maximo de pessoas cadastradas");
        }
    }

//======================================================================================================================

    private static void calcularMediaAlunos(String[] nome, double[][] notas, int count) {
        if (count == 0) {
            JOptionPane.showInputDialog(null, "Nenhum aluno cadastrado");
            return;
        }
        double[] mediaAluno = new double[count]; // Armazena médias
        double somaGeral = 0;

        for (int i = 0; i < count; i++){  // Loop para a quant de alunos cad
            double soma = 0;

            for (int j = 0; j < 3; j++){ // Percorre as notas de cada aluno
                soma += notas[i][j];
            }
            mediaAluno[i] = soma / 3; // 3 = qnt notas
            somaGeral += mediaAluno[i];
        }
        double mediaGeral = somaGeral / count; // media geral dos alunos na turma

        StringBuilder media = new StringBuilder();
        for (int i = 0; i < count; i++){
            media.append("Aluno: ").append(nome[i]).append("\n").append("Média: ").append(String.format("%.2f", mediaAluno[i])).append("\n\n");
        }
        media.append("Média geral: ").append(String.format("%.2f", mediaGeral));
        JOptionPane.showMessageDialog(null, media.toString());
    }

    private static void situacaoAlunos(String[] nome, double[][] notas, int count) {
        if (count == 0) {
            JOptionPane.showInputDialog(null, "Nenhum aluno cadastrado");
            return;
        }
        double[] mediaAluno = new double[count]; // Armazena médias

        for (int i = 0; i < count; i++){  // Loop para a quant de alunos cad
            double soma = 0;

            for (int j = 0; j < 3; j++){ // Percorre as notas de cada aluno
                soma += notas[i][j];
            }
            mediaAluno[i] = soma / 3; // 3 = qnt notas
        }

        StringBuilder situacaoDoAluno = new StringBuilder();
        situacaoDoAluno.append("Situação dos alunos: \n");

        for (int i = 0; i < count; i++) {
            String situacao;
            if (mediaAluno[i] >= 7){
                situacao = "Aprovado";
            } else if (mediaAluno[i] <= 3) {
                situacao = "Reprovado";
            } else {
                situacao = "Recuperação";
            }

            situacaoDoAluno.append("Aluno: ").append(nome[i])
                    .append(", Média: ").append(String.format("%.2f", mediaAluno[i]))
                    .append("\nSituação: ").append(situacao).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, situacaoDoAluno);
    }

    private static void percentualMulheresHomens_Reprovados(char[] sexo, double[][] notas, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
            return;
        }
        int masculino = 0;
        int feminino = 0;
        double reprovadMasculino = 0;
        double reprovadFeminino = 0;

        for (int i = 0; i < count; i++) {  // Loop para a quant de alunos cad
            double soma = 0;

            for (int j = 0; j < 3; j++) { // Percorre as notas de cada aluno
                soma += notas[i][j];
            }
            double mediaAluno = soma / 3; // 3 = qnt notas

            if (sexo[i] == 'M' || sexo[i] == 'm') {
                masculino++;
                if (mediaAluno <= 3) {
                    reprovadMasculino++;
                }
            } else if (sexo[i] == 'F' || sexo[i] == 'f') {
                feminino++;
                if (mediaAluno <= 3) {
                    reprovadFeminino++;
                }
            }
        }
        double percentReprovMasculino = reprovadMasculino / masculino * 100;
        double percentReprovFeminino = reprovadFeminino / feminino * 100;

        StringBuilder percentAlunoReprovado = new StringBuilder();
        percentAlunoReprovado.append("Porcentagem de alunos homens e mulheres reprovados:\n\n")
                .append("Porcentagem de alunos homens reprovados: ").append(String.format("%.2f", percentReprovMasculino)).append("\n")
                .append("Porcentagem de alunas mulheres reprovados: ").append(String.format("%.2f", percentReprovFeminino));
        JOptionPane.showMessageDialog(null, percentAlunoReprovado.toString());
    }

    private static void mediaDeIdades(int[] idade, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
            return;
        }
        double somaIdades = 0;
        double pessoas = 0;

        for (int i = 0; i < count; i++){ // Loop para a quant de alunos cad
            somaIdades += idade[i]; // Percorre as notas de cada aluno
            pessoas ++;
        }
        double media = somaIdades/pessoas;

        String mediasIdade = "Média de idades: " + String.format("%.2f", media);
        JOptionPane.showMessageDialog(null, mediasIdade);
    }

    private static void ListarAlunosPorSexo(String[] nome, char[] sexo, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
        }
        StringBuilder sexoMasculino = new StringBuilder("Alunos do Sexo Masculino:\n");
        StringBuilder sexoFeminino = new StringBuilder("Alunas do Sexo Feminino:\n");

        for (int i = 0; i < count; i++) {
            if (sexo[i] == 'M' || sexo[i] == 'm') {
                sexoMasculino.append(" ◉ ").append(nome[i]).append("\n");
            } else if (sexo[i] == 'F' || sexo[i] == 'f') {
                sexoFeminino.append(" ◉ ").append(nome[i]).append("\n");
            }
        }
        StringBuilder listaMascFemin = new StringBuilder();
        listaMascFemin.append(sexoMasculino).append("\n").append(sexoFeminino);
        JOptionPane.showMessageDialog(null, listaMascFemin);
    }

    private static void ListarAlunosPorIdade(String[] nome, int[] idade, int count) {
        if (count == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado!");
        }
        StringBuilder listaAlunosIdade = new StringBuilder("Lista de Alunos por Idade:\n\n");

        for (int i = 0; i < count; i++) {
            listaAlunosIdade.append(nome[i]).append(", ").append(idade[i]).append(" anos\n"); // nome - 00 anos
        }
        JOptionPane.showMessageDialog(null, listaAlunosIdade);
    }
}

/*
Faça um programa que cadastre os alunos da disciplina de Algoritmos II.
Cada aluno tem nome, idade, sexo, e tres notas.

O programa deve ter o seguinte menu:
1 - Cadastrar aluno
2 - Calcular a média de todos os alunos
3 - Exibir alunos que estão aprovados, reprovados ou em recuperação (critérios: acima de 7 aprovado, abaixo de 3 reprovado)
4 - Percentual de mulheres e homens reprovados
5 - Média das idades da turma
6 - Listar alunos por sexo
7 - Listar alunos por idade

Validações:
Nome obrigatório
Idade - entre 17 e 99
sexo - M ou F
Notas - double entre 0 e 10

**** UTILIZAR O MÁXIMO DE PROCEDIMENTOS E FUNÇÕES
 */