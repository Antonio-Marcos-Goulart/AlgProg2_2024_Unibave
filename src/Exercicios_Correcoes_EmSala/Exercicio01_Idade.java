package Exercicios_Correcoes_EmSala;

import javax.swing.JOptionPane;

public class Exercicio01_Idade {

	public static void main(String[] args) {

		String coloca = JOptionPane.showInputDialog(null, "Insira sua idade:");
		
		
			int idade = Integer.parseInt(coloca);
			
			String classificacao;
			
			if (idade >= 0 && idade <= 12) {
				classificacao = "Criança";
			}
			else if (idade >= 13 && idade <= 17) {
				classificacao = "Adolescente";
			}
			else if (idade >= 18 && idade <= 60) {
				classificacao = "Adulto";
				
			}else if (idade >= 61 && idade <= 110){
				classificacao = "Idoso";
			} else {
				classificacao = "Ta vivendo bastante";
			}
			JOptionPane.showInternalMessageDialog(null, "Em relação com a idade fornecida, que é de " + idade + " anos" + "\n"
					+ "você é classificado(a) como: " + classificacao);
	}

}
