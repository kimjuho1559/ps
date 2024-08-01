import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        long[][] dp = new long[N][21];
        while (st.hasMoreTokens()) {
            arr[N - st.countTokens()] = Integer.parseInt(st.nextToken());
        }
        dp[0][arr[0]] = 1;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j - arr[i] >= 0)
                        dp[i][j - arr[i]] += dp[i - 1][j];
                    if (j + arr[i] <= 20)
                        dp[i][j + arr[i]] += dp[i - 1][j];
                }
            }
        }/*
        System.out.print("0 ");
        for (int i = 0; i < 21; i++) {
            System.out.printf("%2d\t", i);
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 21; j++) {
                System.out.printf("%2d\t", dp[i][j]);
            }
            System.out.println();
        }*/
        System.out.println(dp[N - 2][arr[N - 1]]);
    }
}