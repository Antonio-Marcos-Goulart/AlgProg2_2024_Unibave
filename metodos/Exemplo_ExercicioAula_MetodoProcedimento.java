package metodos;

public class Exemplo_ExercicioAula_MetodoProcedimento {
    public static void main(String[] args) {

        somarDoisNumeros(3, 5);
        somarDoisNumeros(5.4, 4.6);
        multiplicaDoisNumeros(2, 5.2);

    }

    private static void somarDoisNumeros (int n1, int n2){ // METODO
        int soma = n1 + n2;
        System.out.println("SOMAR DOIS NUMEROS INT " + soma);
    }
    private static void somarDoisNumeros (double n1, double n2){ // METODO
        double soma = n1 + n2;
        System.out.printf("SOMAR DOIS NUMEROS DOUBLE %.2f ",soma);
        System.out.println();
    }

    private static void multiplicaDoisNumeros (double n1, double n2){ // METODO
        double multiplica = n1 * n2;
        System.out.printf("MULTIPLICAR DOIS NUMEROS %.2f ", multiplica);
    }
}

// EXEMPLO USADO PELO PROFESSOR PARA DEMONSTRAR O FUNCIONAMENTO