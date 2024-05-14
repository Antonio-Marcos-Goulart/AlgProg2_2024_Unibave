package avaliacao_01_Vetor_02_04_2024;

import javax.swing.*;

public class Questao_01_mesComMaisAcidentes {
    public static void main(String[] args) {

        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        int[] acidentes = new int[12];
        int acidentesNoAno = 0;
        int indiceMesMaisAcidentes = -1;
        int indiceMesMenosAcidentes = -1;

        for (int i = 0; i < meses.length; i++) {
            acidentes[i] = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de acidentes no mês de " + meses[i] + ": "));
            acidentesNoAno += acidentes[i];

            if (indiceMesMaisAcidentes == -1 || acidentes[i] > acidentes[indiceMesMaisAcidentes]) {
                indiceMesMaisAcidentes = i;
            }

            if (indiceMesMenosAcidentes == -1 || acidentes[i] < acidentes[indiceMesMenosAcidentes]) {
                indiceMesMenosAcidentes = i;
            }
        }

        int fevereiro = acidentes[1];
        var percFevereiro = (double) fevereiro / acidentesNoAno * 100;

        String msgSaida = "Mês com mais acidentes: " + meses[indiceMesMaisAcidentes] + "\n"
                + "Mês com menos acidentes: " + meses[indiceMesMenosAcidentes] + "\n"
                + "Total de acidentes no ano: " + acidentesNoAno + "\n"
                + "Percentual de acidentes no mês de fevereiro: " + percFevereiro + "%";
        JOptionPane.showMessageDialog(null, msgSaida);
    }
}