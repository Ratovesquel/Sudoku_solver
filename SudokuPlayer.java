import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuPlayer {
    int contUm = 0;
    int contDois = 0;
    int contTres = 0;
    int contQuatro = 0;
    int contCinco = 0;
    int contSeis = 0;
    int contSete = 0;
    int contOito = 0;
    int contNove = 0;

    public static void main(String[] args) {
        int[][] sudoku = lerSudoku("sudoku.txt");

        imprimirMatriz(sudoku);
    }

    //#region LENDO
    public static int[][] lerSudoku(String caminhoArquivo) {
        int[][] matriz = new int[9][9];

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {

            for (int i = 0; i < 9; i++) {
                String linha = br.readLine();

                if (linha == null || linha.length() != 9) {
                    throw new IllegalArgumentException(
                        "Cada linha deve possuir exatamente 9 caracteres."
                    );
                }

                for (int j = 0; j < 9; j++) {
                    char c = linha.charAt(j);

                    if (!Character.isDigit(c)) {
                        throw new IllegalArgumentException(
                            "Apenas números são permitidos."
                        );
                    }

                    matriz[i][j] = c - '0';
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
    //#endregion

}
