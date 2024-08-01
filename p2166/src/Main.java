import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long [][] arr = new long[N+1][2];
        for (int i = 0; i < N;i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        arr[N] = arr[0].clone();
        long sum1 = 0L;
        long sum2=0L;
        for (int n = 0; n < N; n++) {
            sum1 += arr[n][0] * arr[n + 1][1];
            sum2 += arr[n][1] * arr[n + 1][0];
        }
        System.out.println(String.format("%.1f",Math.abs(sum1-sum2)/2D));
    }
}