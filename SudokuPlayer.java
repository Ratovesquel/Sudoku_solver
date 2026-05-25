import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuPlayer {
    //#region INICIALIZAÇÃO

    static int contUm = 0;
    static int contDois = 0;
    static int contTres = 0;
    static int contQuatro = 0;
    static int contCinco = 0;
    static int contSeis = 0;
    static int contSete = 0;
    static int contOito = 0;
    static int contNove = 0;

    //#endregion
    
    //#region MAIN
    public static void main(String[] args) {
        int[][] sudoku = lerSudoku("Casos/caso6.txt");

        imprimirMatriz(sudoku);
    }

    //#endregion

    //#region VERIFICAÇÃO
    
    //#endregion

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
                    if(c == '.')
                        matriz[i][j] = 0;
                    else
                        matriz[i][j] = c - '0';
                        switch (matriz[i][j]) {
                            case 1:
                                contUm++;
                                break;
                            case 2:
                                contDois++;
                                break;
                            case 3:
                                contTres++;
                                break;
                            case 4:
                                contQuatro++;
                                break;
                            case 5:
                                contCinco++;
                                break;
                            case 6:
                                contSeis++;
                                break;
                            case 7:
                                contSete++;
                                break;
                            case 8:
                                contOito++;
                                break;
                            case 9:
                                contNove++;
                                break;
                            default:
                                break;
                        }
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
                // System.out.println("i:"+i+" j:"+j+" valor:"+matriz[i][j]);
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("1: " + contUm + " 2: " + contDois + " 3: " + contTres + " 4: " + contQuatro + " 5: " + contCinco + " 6: " + contSeis + " 7: " + contSete + " 8: " + contOito + " 9: " + contNove);
    }
    //#endregion

}
