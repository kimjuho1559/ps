import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int[] check = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            arr[N - st.countTokens()] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 1;
        check[0] = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            if (arr[i] >= arr[i - 1]) {
                check[i] = check[i - 1] + 1;
            } else {
                check[i] = 1;
            }
            max = Math.max(max, Math.max(check[i], dp[i]));
        }
            System.out.println(max);
    }
}