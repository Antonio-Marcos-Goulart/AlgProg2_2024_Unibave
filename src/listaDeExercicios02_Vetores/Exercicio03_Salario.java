package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane;

public class Exercicio03_Salario {

	public static void main(String[] args) {

		 int n = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de funcionários:  "));
		 String[] nome = new String[n];
		 double[] salario = new double[n];
		 
		 for(int i = 0; i < n; i++) {
			 nome[i] = JOptionPane.showInputDialog("Digite o nome do funcionário" + (i + 1) + ": ");
			 salario[i] = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário(a) " + nome[i] + ": "));
		 }
		 for(int i = 0; i < n; i++) {
			 if (salario[i] <= 400) {
				salario[i]*= 1.25;
			}
			 else if (salario[i] <= 600) {
				salario[i] *= 1.20;
			}
			 else if (salario[i] <= 800) {
				 salario[i] *= 1.15;
			 } else {
				 salario[i] *= 1.10;
			 }
		 } 
		 StringBuilder salarioFuncio = new StringBuilder("Salaríos dos funcionarios alterados após o ajuste: \n ");
	
		 for(int i = 0; i < n; i++) {
			 salarioFuncio.append("Funcionário: ").append(nome[i]).append(", salario após a alteração: R$ ");
			 salarioFuncio.append(String.format("%.2f", salario[i])).append("\n");
		 }
		 JOptionPane.showMessageDialog(null, salarioFuncio.toString());
	}

}
