import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            Integer[] arr = new Integer[N];
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[j] = Integer.parseInt(st.nextToken());
                j++;
            }
            Arrays.sort(arr, Collections.reverseOrder());
            Integer[] dp = new Integer[N];
            dp[0] = 0;
            for (int k = 1; k < N; k++) {
                dp[k] = Math.abs(arr[k] - arr[k - 1]);
                if (dp[k] < dp[k-1]) {
                    dp[k] = dp[k - 1];
                }
            }
            System.out.println("Class " + (i+1));
            System.out.println("Max " + arr[0] + ", Min " + arr[N - 1] + ", Largest gap " + dp[N - 1]);
        }
    }
}