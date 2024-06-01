
package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane;

public class Exercicio04_NumerosReais {

	public static void main(String[] args) {
		
		int n;
		
		do {
			String quantNum =  JOptionPane.showInputDialog(null, "Digite a quantidade de números que deseja inserir (máximo 20):");
			n = Integer.parseInt(quantNum);
		
			if (n > 20) {
				JOptionPane.showMessageDialog(null, "Quantidade maxima de números permitida é 20. Tente novamente");
			}
			
		} while ( n > 20);
		
		
		double[] numeros = new double[n];
		double soma = 0;
		
	   for (int i = 0; i < numeros.length; i++) {
            String input = JOptionPane.showInputDialog(null, "Digite o " + (i + 1) + "° numero real:");
            numeros[i] = Double.parseDouble(input);
            soma += numeros[i];
        }
	   
	   double media = soma / numeros.length;
	   
	   for(int i = 0; i < numeros.length; i++) {
		   if (numeros[i]< media) {
			   numeros[i] = media;
		   }
	   }
	   
	   StringBuilder m = new StringBuilder("Resultado\n");
	   for (int i = 0; i < numeros.length; i++) {
           m.append("Número #").append(i + 1).append(": ").append(numeros[i]).append("\n");
       }

       JOptionPane.showMessageDialog(null, m.toString()); 
   }	
}

