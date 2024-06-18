package avaliacao_3.questao_2;

import javax.swing.*;
import java.util.ArrayList;

public class Clinica {
    public static void main(String[] args) {
        ArrayList<Paciente> pc = new ArrayList<>();

        int op = 0;

        do {
            op = menu();
            if (op == 1) pc.add(cadPaciente());
            if (op == 2) locPaciente(pc);
            if (op == 3) verDiagnostico(pc);
            if (op == 4) paciNasc2000(pc);
            if (op == 5) pacienteGenero(pc);
        } while (op != 6);
    }

    public static int menu() {
        String opcoes = """
                1 - Cadastrar paciente
                2 - Localizar paciente pelo cartão do SUS
                3 - Verificar diagnósticos do paciente
                4 - Pacientes nascidos no ano 2000
                5 - Listar pacientes de um gênero
                6 - SAIR
                """;
        return Integer.parseInt(JOptionPane.showInputDialog(null, opcoes));
    }

    public static void msg(String txt) {
        JOptionPane.showMessageDialog(null, txt);
    }

    public static String exibirPaciente(Paciente pc) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(pc.nome).append("\n")
                .append("Ano de nascimento: ").append(pc.anoNascimento).append("\n")
                .append("Gênero: ").append(pc.genero).append("\n")
                .append("Número cartão do SUS: ").append(pc.numSus).append("\n")
                .append("Lista de diagnósticos:");

        if (pc.diagnosticos == null || pc.diagnosticos.length == 0) {
            sb.append(" Nenhum diagnóstico registrado.");
        } else {
            for (String diag : pc.diagnosticos) {
                sb.append(" ").append(diag).append(",");
            }
            sb.setLength(sb.length() - 1); // Remove a vírgula extra no final
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
        int recInt;
        try {
            recInt = Integer.parseInt(JOptionPane.showInputDialog(txt));
            if (recInt <= 0) {
                msg("Dados informados inválidos, verifique os dados e tente novamente!");
                return lerInt(txt);
            }
        } catch (NumberFormatException e) {
            msg("Número inválido! Insira um número válido.");
            return lerInt(txt);
        }
        return recInt;
    }

    public static long lerLong(String txt) {
        long recLong;
        try {
            recLong = Long.parseLong(JOptionPane.showInputDialog(txt));
            if (Long.toString(recLong).length() != 15) {
                msg("Número do cartão do SUS inválido! Insira um número válido.");
                return lerLong(txt);
            }
        } catch (NumberFormatException e) {
            msg("Número inválido! Insira um número válido.");
            return lerLong(txt);
        }
        return recLong;
    }

    public static char lerGenero(String txt) {
        String recChar = JOptionPane.showInputDialog(txt);
        char genero = recChar.toUpperCase().charAt(0);
        if (genero != 'H' && genero != 'M') {
            msg("Valor inválido, tente novamente");
            return lerGenero(txt);
        }
        return genero;
    }

    public static Paciente cadPaciente() {
        Paciente pc = new Paciente();
        pc.nome = lerString("Nome do paciente:");
        pc.genero = lerGenero("Gênero - H para Homem, M para Mulher:");
        pc.anoNascimento = lerInt("Ano de Nascimento:");
        pc.numSus = lerLong("Número do cartão do SUS:");

        int qnt = lerInt("Quantos diagnósticos o paciente teve?");
        pc.diagnosticos = new String[qnt];
        for (int i = 0; i < qnt; i++) {
            pc.diagnosticos[i] = lerString("Diagnóstico:");
        }

        return pc;
    }

    public static void locPaciente(ArrayList<Paciente> pc) {
        long numSus = lerLong("Número do cartão do SUS:");
        boolean encontrado = false;
        for (Paciente p : pc) {
            if (p.numSus == numSus) {
                msg(exibirPaciente(p));
                encontrado = true;
                break; // Parar de procurar assim que encontrar o paciente
            }
        }
        if (!encontrado) {
            msg("Paciente não encontrado!");
        }
    }

    public static void verDiagnostico(ArrayList<Paciente> pc) {
        String nome = lerString("Nome do paciente:");
        boolean encontrado = false;
        for (Paciente p : pc) {
            if (p.nome.equalsIgnoreCase(nome)) {
                msg(exibirPaciente(p));
                encontrado = true;
                break; // Parar de procurar assim que encontrar o paciente
            }
        }
        if (!encontrado) {
            msg("Paciente não encontrado!");
        }
    }

    public static void paciNasc2000(ArrayList<Paciente> pc) {
        boolean encontrado = false;
        StringBuilder sb = new StringBuilder("Pacientes nascidos no ano 2000:\n");
        for (Paciente p : pc) {
            if (p.anoNascimento == 2000) {
                sb.append(exibirPaciente(p)).append("\n\n");
                encontrado = true;
            }
        }
        if (!encontrado) {
            msg("Não há pacientes nascidos no ano 2000!");
        } else {
            msg(sb.toString());
        }
    }

    public static void pacienteGenero(ArrayList<Paciente> pc) {
        char genero = lerGenero("Gênero - H para Homem, M para Mulher:");
        StringBuilder sb = new StringBuilder("Nome dos pacientes do gênero ").append(genero).append(":\n");

        boolean encontrado = false;
        for (Paciente p : pc) {
            if (p.genero == genero) {
                sb.append(p.nome).append(", ");
                encontrado = true;
            }
        }

        if (encontrado) {
            sb.setLength(sb.length() - 2);
            msg(sb.toString());
        } else {
            msg("Não há pacientes do gênero " + genero);
        }
    }
}