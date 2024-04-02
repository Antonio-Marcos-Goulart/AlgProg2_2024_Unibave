package listaDeExercicios01;

import java.util.Scanner;

public class Exercicio05_Carro {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantidade de carros: ");
        int quantidadeCarros = sc.nextInt();
        
        int azuis = 0; 
        int pretos2021 = 0; 
        int entre2010_2020 = 0; 
        
        for (int i = 0; i < quantidadeCarros; i++) {
            System.out.println("Carro " + (i + 1) + ":");
            
            System.out.print("Ano de fabricação: ");
            int anoFabricacao = sc.nextInt();
            
            System.out.print("Cor: ");
            String cor = sc.next();
            
            if (cor.equalsIgnoreCase("azul")) {
                azuis++;
            }
            
            if (anoFabricacao == 2021 && cor.equalsIgnoreCase("preto")) {
                pretos2021++;
            }
            
            if (anoFabricacao >= 2010 && anoFabricacao <= 2020) {
                entre2010_2020++;
            }
        }
        System.out.println("\n");
        
        System.out.println("Quantidade de carros azuis: " + azuis);
        System.out.println("Quantidade de carros pretos fabricados em 2021: " + pretos2021);
        System.out.println("Quantidade de carros fabricados entre 2010 e 2020: " + entre2010_2020);
        
        sc.close();
    }
}
		
		
		
		
		


