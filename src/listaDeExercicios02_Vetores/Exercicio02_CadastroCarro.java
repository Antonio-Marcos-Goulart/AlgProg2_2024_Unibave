package listaDeExercicios02_Vetores;

import javax.swing.JOptionPane;

public class Exercicio02_CadastroCarro {

	public static void main(String[] args) {
		
	    int n = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de carros a serem cadastrados: "));
        String[] marca = new String[20];
        int[] anoFabricacao = new int[20];
        String[] placa = new String[20];
        int quantidadeDeCarros = 0;

        String menu = "1 - Cadastrar carro\n"
                    + "2 - Verificar o carro mais novo\n"
                    + "3 - Buscar por placa\n"
                    +" \n"
                    + "4 - Sair";

        int op = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1:
                    cadastrarCarro(marca, anoFabricacao, placa, quantidadeDeCarros, n);
                    	quantidadeDeCarros++; 
                    break;
                case 2:
                    verificarCarroMaisNovoPorMarca(marca, anoFabricacao, placa, quantidadeDeCarros);
                    break;
                case 3:
                    buscarPorPlaca(marca, anoFabricacao, placa, quantidadeDeCarros);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Programa encerrado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (op != 4);
    }

    public static void cadastrarCarro(String[] marca, int[] anoFabricacao, String[] placa, int quantidadeCarros, int n) {
        if (quantidadeCarros < n && quantidadeCarros < marca.length) { 
            marca[quantidadeCarros] = JOptionPane.showInputDialog("Marca do Carro "+(quantidadeCarros+1)+" de "+n);
            anoFabricacao[quantidadeCarros] = Integer.parseInt(JOptionPane.showInputDialog("Ano de fabricação do carro "+(quantidadeCarros+1)+" de "+n));
            placa[quantidadeCarros] = JOptionPane.showInputDialog("Placa do carro "+(quantidadeCarros+1)+" de "+n);
            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Limite de carros cadastrados atingido.");
        }
    }
    
    public static void verificarCarroMaisNovoPorMarca(String[] marca, int[] anoFabricacao, String[] placa, int quantidadeCarros) {
        if (quantidadeCarros > 0) { 
            String marcaBusca = JOptionPane.showInputDialog("Digite a marca do carro:");
            int indiceCarroMaisNovo = buscarCarroMaisNovoPorMarca(marca, anoFabricacao, quantidadeCarros, marcaBusca);

            if (indiceCarroMaisNovo != -1) {
                JOptionPane.showMessageDialog(null, "Marca do carro mais novo: " + marca[indiceCarroMaisNovo]
                        + "\nAno de fabricação: " + anoFabricacao[indiceCarroMaisNovo]
                        + "\nPlaca: " + placa[indiceCarroMaisNovo]);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum carro da marca " + marcaBusca + " foi encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não há carros cadastrados.");
        }
    }

    public static int buscarCarroMaisNovoPorMarca(String[] marca, int[] anoFabricacao, int quantidadeCarros, String marcaBusca) {
        int indiceCarroMaisNovo = -1;
        int anoMaisNovo = Integer.MIN_VALUE;

        for (int i = 0; i < quantidadeCarros; i++) {
            if (marca[i] != null && marca[i].equalsIgnoreCase(marcaBusca) && anoFabricacao[i] > anoMaisNovo) {
                indiceCarroMaisNovo = i;
                anoMaisNovo = anoFabricacao[i];
            }
        }
        return indiceCarroMaisNovo;
    }

    public static void buscarPorPlaca(String[] marca, int[] anoFabricacao, String[] placa, int quantidadeCarros) {
        if (quantidadeCarros > 0) { 
            boolean encontrado = false;

            do {
                String placaBuscar = JOptionPane.showInputDialog("Digite a placa a ser buscada:");
                encontrado = false;

                for (int i = 0; i < quantidadeCarros; i++) {
                    if (placa[i] != null && placa[i].equalsIgnoreCase(placaBuscar)) {
                        JOptionPane.showMessageDialog(null, "Marca do carro: " + marca[i]
                                + "\nAno de fabricação: " + anoFabricacao[i]);
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(null, "Placa não encontrada.");
                }
            } while (!encontrado);
        } else {
            JOptionPane.showMessageDialog(null, "Não há carros cadastrados.");
        }
    }
}                        