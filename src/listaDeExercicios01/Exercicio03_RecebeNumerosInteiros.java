package listaDeExercicios01;

import java.util.Scanner;

public class Exercicio03_RecebeNumerosInteiros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Insira a quantidade de números a serem analisados: ");
        int quantidadeDeNumeros = sc.nextInt();
		
        int somaPares = 0;
        int quantidadePares = 0;
        int somaImpares = 0;
        int quantidadeImpares = 0;
		
        for (int i = 0; i < quantidadeDeNumeros; i++) {
			System.out.print("Digite o número " + (i+1) + ": ");
			int numero = sc.nextInt();
			
			if (numero % 2 == 0) {
				somaPares += numero;
				quantidadePares ++;
			}else {
				somaImpares += numero;
				quantidadeImpares++;
			}
		}
        
        System.out.println("\n");
        
        System.out.println("Números pares digitados: " + quantidadePares);
        System.out.println("Soma dos números pares digitados: " + somaPares);
        System.out.println("Numeros impares digitados: " + quantidadeImpares);

        double mediaImpares = quantidadeImpares > 0 ? (double) somaImpares / quantidadeImpares : 0.0;
        System.out.println("Média dos números ímpares digitados: " + mediaImpares);

        
		sc.close();
	}

}

/*
 i) Os números pares digitados;
  
ii) A soma dos números pares digitados;
 
iii) Os números ímpares digitados; 

iv) A média dos números ímpares digitados;/
*/