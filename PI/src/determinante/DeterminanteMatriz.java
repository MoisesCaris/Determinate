package determinante;

import java.util.Scanner;

public class DeterminanteMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho da matriz quadrada: ");
        int tamanho = scanner.nextInt();

        int[][] matriz = new int[tamanho][tamanho];
        System.out.println("Digite os elementos da matriz:");

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        int determinante = calcularDeterminante(matriz);
        System.out.println("Determinante: " + determinante);

        scanner.close();
    }
    
    // calcula o determinante da matriz
    public static int calcularDeterminante(int[][] matriz) {
        int ordem = matriz.length;

        if (ordem == 2) { // Caso seja matriz de ordem 2
            int a = matriz[0][0];
            int b = matriz[0][1];
            int c = matriz[1][0];
            int d = matriz[1][1];
            return a * d - b * c;
        }

        int determinante = 0;
        for (int coluna = 0; coluna < ordem; coluna++) {
            int[][] submatriz = new int[ordem - 1][ordem - 1]; // constroi a matriz do detB
            for (int i = 1; i < ordem; i++) {
                int colunaDestino = 0;
                for (int j = 0; j < ordem; j++) {
                    if (j != coluna) {
                        submatriz[i - 1][colunaDestino] = matriz[i][j];
                        colunaDestino++;
                    }
                }
            }
            int elemento = matriz[0][coluna];
            determinante += elemento * Math.pow(-1, coluna) * calcularDeterminante(submatriz);
        }

        return determinante;
    }
}