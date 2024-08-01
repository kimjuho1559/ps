import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[1516][3];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[1][2] = 1;
        if (N == 1) {
            System.out.println(dp[N][0]);
            return;
        }
        for (int i = 1; i < N ; i++) {
            dp[i + 1][0] = (dp[i][1] + dp[i][2])%1000000007;
            dp[i + 1][1] = (dp[i][0] + dp[i][2])%1000000007;
            dp[i + 1][2] = (dp[i][0] + dp[i][1])%1000000007;
        }
        System.out.println(dp[N-1][1]%1000000007);
    }
}