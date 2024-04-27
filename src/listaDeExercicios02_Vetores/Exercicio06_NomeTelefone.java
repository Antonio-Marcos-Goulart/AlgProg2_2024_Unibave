package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane; // REVISAR EM CASA ESSE CÓDIGO 

public class Exercicio06_NomeTelefone {

	public static void main(String[] args) {
		String menu = "1 - Cadastrar contato\n" 
				+ "2 - Buscar contato por nome\n" 
				+ "3 - Buscar contato por telefone\n"
				+ "4 - Sair";

		int n;
		int op = 0;
		String[] nome = new String[100];
		int[] numero = new int[100];
		int numDeContatos = 0; // Usada para manter o controle do número de contatos que foram cadastrados até o momento (nome e numero). Ela é incrementada sempre que um novo contato é adicionado


		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));

			if (op == 1) {

				String quantContatos = JOptionPane.showInputDialog("Digite a quantidade de contatos a serem cadastrados (máximo 100): ");
				n = Integer.parseInt(quantContatos);

				if (n <= 100) {
					for (int i = 0; i < n; i++) {

						nome[numDeContatos] = JOptionPane.showInputDialog("Nome do contato:"); 
						numero[numDeContatos] = Integer.parseInt(JOptionPane.showInputDialog("Número de telefone do contato " + nome[numDeContatos] + ": "));
						numDeContatos++;
					}
				} else {
                    JOptionPane.showMessageDialog(null, "A quantidade de contatos excede o limite maximo de 100 cadastros!");
				}
			} 
			
			if (op == 2) {
				String buscarPorNome = JOptionPane.showInputDialog("Insira o nome do contato que deseja buscar:");
				boolean encontrado= false; 
				for (int i = 0; i < numDeContatos; i++) {
					if(nome[i] != null && nome[i].equalsIgnoreCase(buscarPorNome)) {
						JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nNúmero: " + numero[i]);
						encontrado = true; 
						break;
					}
				}
				if(!encontrado) {
					JOptionPane.showMessageDialog(null, "Contato não encontrado!");
				}
			}
			
			if (op == 3) {
				String buscarNumTelefone = JOptionPane.showInputDialog("Insira o número de telefone do contato que deseja buscar:");
				boolean encontrado = false;
				for (int i = 0; i < numDeContatos; i++) {
					if (numero[i] != 0 && numero[i] == Integer.parseInt(buscarNumTelefone)) {
						JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nNúmero: " + numero[i]);
						encontrado = true; 
						break;
					}
				}
				if(!encontrado) {
					JOptionPane.showMessageDialog(null, "Número não encontrado!");
				}

			}

		} while (op != 4);
			JOptionPane.showMessageDialog(null, "Programa encerrado");
	}
}