package matriz;

import java.util.Random;

public class GastosExercicioSala01 {
    public static void main(String[] args) {

        double[][] gastos = new double[12][4]; //meses, semanas
        Random r = new Random();

        for (int i = 0; i < gastos.length; i++) {
            for (int j = 0; j < gastos[0].length; j++) {
                gastos[i][j] = r.nextDouble() * 500;
            }
        }

        for (int i = 0; i < gastos.length; i++) {
            for (int j = 0; j < gastos[0].length; j++) {
                System.out.printf("%.2f \n", gastos[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < gastos.length; i++) {
            double totalMes = 0;
            for (int j = 0; j < gastos[0].length; j++) {
                totalMes += gastos[i][j];
            }
            System.out.printf("Mês %d: %.2f\n", (i+1), totalMes);
        }
    }
}