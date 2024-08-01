import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[][] dp = new int[20][20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[20][20];
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                arr[i][20-st.countTokens()] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (arr[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        check(i,j,k,arr);
                    }
                }
                else if (arr[i][j] == 2) {
                    for (int k = 0; k < 8; k++) {

                    }
                }
            }
        }
    }
    static void check(int i, int j, int k,int [][]arr) {
        for (int l = 0; l < 5; l++) {
            if (l == 0) {
                dp[i + dx[k]][j + dy[k]] = 1;
            }
            else {
                dp[i + dx[k]][j + dy[k]] +=
            }
        }
    }

}