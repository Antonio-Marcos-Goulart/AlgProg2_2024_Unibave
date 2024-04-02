package listaDeExercicios01;

import javax.swing.JOptionPane;

public class Exercicio02_SalarioVendedor {

	public static void main(String[] args) {

		double salario = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor do salário: R$ "));
		double vendas = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor das vendas no mês atual: R$ "));

		double salarioComissaoMenos50mil = salario + vendas*0.015;
		String salarioFinal1 = String.format("Valor das vendas no mês R$ " + vendas + " SALÁRIO + COMISSÃO \n"
		        + "R$ %.2f", salarioComissaoMenos50mil);

		double salarioComissaoMais50mil = salario + vendas*0.03;
		String salarioFinal = String.format("PARABÉNS!!! \nVocê bateu a meta R$ 50000 e vendeu: R$" + vendas + "\n"
		        + "SALÁRIO + COMISSÃO DE META BATIDA \n"
		        + "R$ %.2f", salarioComissaoMais50mil);
		
		if (vendas > 50000) {
			JOptionPane.showMessageDialog(null, salarioFinal);
		}
		else {
			JOptionPane.showMessageDialog(null, salarioFinal1);

		}
		
	}

}
