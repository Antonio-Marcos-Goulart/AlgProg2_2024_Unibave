package exercicios_Correcoes_EmSala;

import java.util.Scanner;

public class Exercicio02_Vetor {

	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);
		
		System.out.print("Digite o número de alunos: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] nome = new String[n];
		double[] altura = new double[n];
		char[] sexo = new char[n]; // M = mulher e H = homem 
		
		
		for (int i = 0; i < n; i++) {
			
			System.out.print("Nome do aluno: ");
			nome[i] = sc.nextLine();
			System.out.print("Altura do aluno em cm: ");
			altura[i] = sc.nextDouble();
			System.out.print("Sexo (F = feminino e M = masculino): ");
			sexo[i] = sc.next().charAt(0);
			sc.nextLine();
		}
		
		System.out.println("================================================");
		
		double maiorAltura = altura[0]; // INICIA COM A ALTURA DO PRIMEIRO ALUNO SENDO A MAIOR 
	    String alunoComMaiorAltura = nome [0]; // INICIA COM O NOME DO PRIMERO ALUNO 

		for (int i = 0; i < n; i++) {
			if (altura[i] > maiorAltura) { // Verifica se a altura do aluno atual é maior que a maior altura registrada até agora
				// Se a altura do aluno atual for maior que a maior altura registrada até agora, atualiza a maior altura e o nome do aluno correspondente
				maiorAltura = altura[i]; // Atualiza a maior altura com a altura do aluno atual
				alunoComMaiorAltura = nome[i]; // Atualiza o nome do aluno com o nome do aluno atual
			}
		}
		
		System.out.println("Nome do aluno com maior altura: " + alunoComMaiorAltura + " , tendo " + maiorAltura + " cm");
		
		double somaAlturaMulheres = 0;
		int quantMulheres = 0;
	
		for (int i = 0; i < n; i++) { //ALTURA MÉDIA MULHERES
			if (sexo[i] == 'F') { // sexo feminino 
				somaAlturaMulheres += altura[i];
				quantMulheres++;
			}
		}
		
		double altMediaMulher = somaAlturaMulheres/quantMulheres;
		
		System.out.println("Mulheres com altura maior que a média: ");
		for (int i = 0; i < n; i++) {
		    if (sexo[i] == 'F' && altura[i] > altMediaMulher) { // Seleciona mulheres com altura acima da média
		        System.out.println(nome[i]);
		    }
		}
		
		double somaAltura = 0;
		for (double alturas : altura) {
			somaAltura += alturas;
		}
		double mediaAlturaTotal = somaAltura / n;
		
		System.out.printf("Pessoas com altura abaixo da média: %.2f " , mediaAlturaTotal);
		for (int i = 0; i < n; i++) { 
			if (altura[i] < mediaAlturaTotal) {
				System.out.println(nome[i] + " ");
			}
		}
		sc.close();
	}

}

