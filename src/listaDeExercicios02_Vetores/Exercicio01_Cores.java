package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane;

public class Exercicio01_Cores {

	public static void main(String[] args) {
		
		String[] cores = new String[5];

		for(int i = 0; i < cores.length; i++) {
			cores [i] = JOptionPane.showInputDialog("Informe a " + (i + 1) + "° cor: ");
		}
		
        StringBuilder corSentidoInverso = new StringBuilder("As cores na ordem inversa são:\n");
		for(int i = 4; i >= 0; i--) {
			corSentidoInverso.append(cores[i]).append("\n");
		}
		JOptionPane.showMessageDialog(null, corSentidoInverso.toString());
	}

}
