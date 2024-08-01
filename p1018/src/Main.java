import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int counta = 64;
    static boolean [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];
        for (int i = 0;i<N;i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length();j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;
                }
                else arr[i][j] = false;
            }
        }
        int nN = N - 7;
        int nM = M - 7;
        for (int i = 0; i < nN; i++) {
            for (int j = 0; j < nM; j++) {
                search(i,j);
            }
        }
        System.out.println(counta);
    }
    public static void search(int i, int j) {
        int count = 0;
        int N = i +8;
        int M = j+8;
        boolean color = arr[i][j];
        for (int k = i; k < N; k++) {
            for (int l = j; l < M; l++) {
                if (arr[k][l] != color)
                    count++;
                color = !color;
            }
            color = !color;
        }
        counta = Math.min(Math.min(count, 64-count),counta);
    }
}