import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
 
public class MatrixSum {
 
    // COMPLETA SOLO ESTA FUNCIÓN
    static int resolver(int N, int M, int[][] matriz) {
 
        return 0; // sustituye esta línea por tu solución
    }
 
    public static void main(String[] args) throws IOException {
        // Lectura rápida de la entrada (Scanner es demasiado lento para matrices grandes)
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
 
        in.nextToken(); int N = (int) in.nval;
        in.nextToken(); int M = (int) in.nval;
 
        int[][] matriz = new int[N][M];
 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                in.nextToken();
                matriz[i][j] = (int) in.nval;
            }
        }
 
        System.out.println(resolver(N, M, matriz));
    }
}
 