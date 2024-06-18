package avaliacao_3.questao_4;

import avaliacao_3.questao_3.Jogos;

import javax.swing.*;
import java.util.ArrayList;

public class CadastroDeCarros {
    public static void main(String[] args) {
        ArrayList<Carros> carro = new ArrayList<>();

        int op = 0;

        do {
            op = menu();
            if (op == 1) carro.add(cadCarro());
            if (op == 2) localizarPorPlaca(carro);
            if (op == 3) carrosCondutor(carro);
            if (op == 4) fab2024(carro);
            if (op == 5) carPorCor(carro);

        } while (op != 6);

    }

    public static int menu() {
        String op = """
                1 - Cadastrar carro
                2 - Localizar carro pela placa  
                3 - Carros que o condutor pode dirigir 
                4 - Carros fabricados em 2024 
                5 - Exibir carros por cor
                6 - SAIR
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(null, op));
    }

    public static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    public static String exibirCarro(Carros carro) {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca do carro: ").append(carro.marca).append("\n")
                .append("Modelo: ").append(carro.modelo).append("\n")
                .append("Ano de fabricação: ").append(carro.anoDeFabricacao).append("\n")
                .append("Cor: ").append(carro.cor).append("\n")
                .append("Placa ").append(carro.placa).append("\n")
                .append("Carros que o condutor pode dirigir ");

        if (carro.nm_condutores == null || carro.nm_condutores.length == 0) {
            sb.append("Nenhum condutor registrado.");
        } else {
            for (String cr : carro.nm_condutores) {
                sb.append(" ").append(cr).append(",");
            }
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String lerString(String txt) {
        String recString = JOptionPane.showInputDialog(txt);
        if (recString == null || recString.trim().isEmpty() || recString.length() <= 3) {
            msg("Dados informados inválidos, verifique os dados e tente novamente!");
            return lerString(txt);
        } else {
            return recString;
        }
    }

    public static int lerInt(String txt) {
        int recInt = Integer.parseInt(JOptionPane.showInputDialog(txt));
        return recInt;
    }

    public static Carros cadCarro() {
        Carros carro = new Carros();

        carro.marca = lerString("Marca: ");
        carro.modelo = lerString("Modelo: ");
        carro.anoDeFabricacao = lerInt("Ano: ");
        carro.cor = lerString("Cor: ");
        carro.placa = lerString("Placa: ");
        int qnt = lerInt("Quantos condutores o carro tem:");
        carro.nm_condutores = new String[qnt];
        for (int i = 0; i < qnt; i++) {
            carro.nm_condutores[i] = lerString("Nome do condutor:");
        }
        return carro;
    }

    public static void localizarPorPlaca(ArrayList<Carros> carro) {
        String placa = lerString("Placa do carro: ");
        StringBuilder sb = new StringBuilder("Placa do carro: ");
        boolean encontrado = false;
        for (Carros carros : carro) {
            if (carros.placa.equalsIgnoreCase(placa)) {
                sb.append(exibirCarro(carros)).append("\n");
                encontrado = true;
            }
        }
        if (!encontrado) {
            sb
                    .append("Nenhuma placa encontrada!");
        }
        msg(sb.toString());
    }

    public static void carPorCor(ArrayList<Carros> car) {
        String cor = lerString("Cor que deseja: ");
        StringBuilder sb = new StringBuilder("Carros da cor " + cor + ":\n");
        boolean encontrado = false;
        for (Carros c : car) {
            if (c.cor.equalsIgnoreCase(cor)) {
                sb.append(exibirCarro(c)).append("\n");
                encontrado = true;
            }
        }
        if (!encontrado) {
            msg("Nenhum carro encontrado com essa cor");
        }
        msg(sb.toString());
    }

    public static void fab2024(ArrayList<Carros> car) {
        StringBuilder sb = new StringBuilder();
        for (Carros c : car) {
            if (c.anoDeFabricacao == 2024) {
                sb.append(exibirCarro(c));
                sb.append("\n");
            }
        }
        msg(sb.toString());
    }

    public static void carrosCondutor(ArrayList<Carros> car) {
        String nome = lerString("Nome do condutor: ");
        StringBuilder sb = new StringBuilder("Carros que o motorista " + nome + " pode conduzir:\n");
        boolean encontrou = false;
        for (Carros carro : car) {
            for (String condutor : carro.nm_condutores) {
                if (nome.equalsIgnoreCase(condutor)) {
                    sb.append(exibirCarro(carro)).append("\n");
                    encontrou = true;
                }
                if (!encontrou) {
                    sb.append("Nenhum carro encontrado para o motorista " + nome);
                }
                msg(sb.toString());
            }
        }
    }
}