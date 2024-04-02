package listaDeExercicios01;

import javax.swing.JOptionPane;

public class Exercicio01_poupanca {

	public static void main(String[] args) {

		double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Insira um valor para depositar: R$ "));
		double juros = 70;
		double contasDoMes = Double.parseDouble(JOptionPane.showInputDialog("Insira o valor das contas do mês R$ "));
		
		double saldoComRendimento = valorDeposito + juros /100;
		
		double diferenca = saldoComRendimento - contasDoMes;
		
		String saldoRestante = String.format("Saldo suficiente para as contas do mês\n" +
                "Saldo restante na conta R$ %.2f", diferenca);
		
		String emprestimo = String.format("Saldo não suficiente para as contas do mês\n" +
                "Saldo restante na conta R$ %.2f.", diferenca, diferenca);

		if (saldoComRendimento > contasDoMes) {
		JOptionPane.showMessageDialog(null, saldoRestante);
		}
		else {
			JOptionPane.showMessageDialog(null, emprestimo);

		}
		
	}

}
