import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        Fazer um programa para ler dois números inteiros M e N, e dpois ler uma matriz
        de M linhas por N colunas contendo números inteiros, podendo haver repetições.
        Em seguida, ler um número inteiro X que pertence à matriz. Para cada ocorrência
        de X, mostrar os valores à esquerda, acima, à direita e abaixo de X, quando houver.
         */


        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int m, n, x;

        System.out.print("Insira a quantidade de linhas: ");
        m = sc.nextInt();
        System.out.print("Insisra a quantidade de colunas: ");
        n = sc.nextInt();

        int[][] mat = new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.print("Digite um número para saber as posições: ");
        x = sc.nextInt();

        System.out.println();


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == x) {
                    System.out.println();
                    System.out.println("Posição " + i + "," + j + ":");
                    if (j > 0) {
                        System.out.println("Esquerda: " + mat[i ][j - 1]);

                    }
                    if (i > 0) {
                        System.out.println("Cima: " + mat[i - 1][j]);

                    }
                    if (j < mat[i].length - 1) {
                        System.out.println("Direita: " + mat[i][j + 1]);

                    }
                    if (i < mat.length - 1) {
                        System.out.println("Baixo: " + mat[i + 1][j]);

                    }
                }
            }
        }

        sc.close();


    }
}