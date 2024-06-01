package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane;

public class Exercicio05_precoEstoque {
	public static void main(String[] args) {
		
		String menu = "Escolha uma opção:\n" 
               + "1 - Cadastrar mercadorias\n" 
                +"2 - Verificar mercadorias com menos de 10 unidades no estoque\n" 
               + "3 - Verificar mercadorias com preço acima de R$100 e mais de 10 unidades em estoque\n" 
               + "4 - Verificar preço da mercadoria com menor estoque\n" 
               + "5 - Verificar estoque da mercadoria com maior preço\n" 
               + "6 - Verificar percentual de mercadorias com estoque zerado\n" 
               + "7 - Sair";
		
		int n;
		int op = 0;

		double[] preco = new double[50];
		String[] nomeMercadoria = new String[50];
		int[] estoqueMercadoria = new int[50];

		int mercadoria = 0;

		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));

			if (op == 1) {
				String quantMercadorias = JOptionPane.showInputDialog("Digite a quantidade de mercadorias a serem cadastrados (máximo 50): ");
				n = Integer.parseInt(quantMercadorias);

				if (n <= 50) {
					for (int i = 0; i < n; i++) {
						nomeMercadoria[mercadoria] = JOptionPane.showInputDialog("Nome da mercadoria n° " + (i + 1) + ": ");
						preco[mercadoria] = Double.parseDouble(JOptionPane.showInputDialog("Preço da mercadoria " + nomeMercadoria[mercadoria] + ": "));
						estoqueMercadoria[mercadoria] = Integer.parseInt(JOptionPane.showInputDialog("Estoque da mercadoria " + nomeMercadoria[mercadoria] + ": "));
						mercadoria++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "A quantidade de mercadorias exede o limite maximo de 50 cadastros!");
				}
			}

			if (op == 2) {
				StringBuilder mercadoriasComMenosDeDez = new StringBuilder("Mercadorias com menos de 10 un em  estoque:\n");
				for (int i = 0; i < mercadoria; i++) {
					if (estoqueMercadoria[i] < 10) {
						mercadoriasComMenosDeDez.append(nomeMercadoria[i]).append(": ").append(estoqueMercadoria[i]).append(" unidades\n");
					}
				}
				JOptionPane.showMessageDialog(null, mercadoriasComMenosDeDez.toString());
			}

			if (op == 3) {
				StringBuilder mercadoriaValorMais100_Mais10Estoque = new StringBuilder("Mercadorias com preço acima de R$ 100.00 e mais de 10 un em estoque:\n");
				for (int i = 0; i < mercadoria; i++) {
					if (preco[i] > 100 && estoqueMercadoria[i] > 10) {
						mercadoriaValorMais100_Mais10Estoque.append(nomeMercadoria[i]).append(": ").append(estoqueMercadoria[i]).append(" unidades\n");
					}
				}
				JOptionPane.showMessageDialog(null, mercadoriaValorMais100_Mais10Estoque.toString());
			}

			if (op == 4) {
				int menorEstoque = Integer.MAX_VALUE;
				int menorEstoqueIndex = -1;
				for (int i = 0; i < mercadoria; i++) {
					if (estoqueMercadoria[i] < menorEstoque) {
						menorEstoque = estoqueMercadoria[i];
						menorEstoqueIndex = i;
					}
				}
				if (menorEstoqueIndex != -1) {
					JOptionPane.showMessageDialog(null, "A mercadoria com menor estoque é " + nomeMercadoria[menorEstoqueIndex] 
							+ " com estoque de " + menorEstoque + " unidades.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há mercadorias cadastradas.");
				}
			}

			if (op == 5) {
				double maiorPreco = Double.MIN_VALUE;
				int indiceMaiorPreco = -1;

				for (int i = 0; i < mercadoria; i++) {
					if (preco[i] > maiorPreco) {
						maiorPreco = preco[i];
						indiceMaiorPreco = 1;
					}
				}
				if (indiceMaiorPreco != -1) {
					JOptionPane.showMessageDialog(null, "A mercadoria com maior preço é " + nomeMercadoria[indiceMaiorPreco] 
							+ " com preço de R$" + maiorPreco + " e estoque de " + estoqueMercadoria[indiceMaiorPreco] + " unidades.");
				} else {
					JOptionPane.showMessageDialog(null, "Não há mercadorias cadastradas.");
				}
			}

			if (op == 6) {
				int mercadoriasEstoqueZerado = 0;

				for (int i = 0; i < mercadoria; i++) {
					if (estoqueMercadoria[i] == 0) {
						mercadoriasEstoqueZerado++;
					}
				}
				double percentualEstoqueZerado = (double) mercadoriasEstoqueZerado / mercadoria * 100;
				
				String msg = String.format("Percentual de mercadorias com estoque zerado: %.2f%%", percentualEstoqueZerado);
				JOptionPane.showMessageDialog(null, msg);
			}
		} while (op != 7);
		JOptionPane.showMessageDialog(null, "Programa encerrado");
	}
}