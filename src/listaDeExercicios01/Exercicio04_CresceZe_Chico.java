package listaDeExercicios01;

public class Exercicio04_CresceZe_Chico {

	public static void main(String[] args) {
		
		double alturaChico = 150; 
        double alturaZe = 110; 
        int anos = 0; 
        
       
        while (alturaZe <= alturaChico) {
            alturaChico += 2; 
            alturaZe += 3; 
            anos++; 
        }
        System.out.println("Em " + anos + " anos Zé será maior que Chico.");
    }
}

