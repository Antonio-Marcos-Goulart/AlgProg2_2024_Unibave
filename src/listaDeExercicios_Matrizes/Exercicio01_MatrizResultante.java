package listaDeExercicios_Matrizes;

public class Exercicio01_MatrizResultante {
    public static void main(String[] args) {

        double[][] m = new double[5][4];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = i + (j / 2.0);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
