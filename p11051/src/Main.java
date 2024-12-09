import java.util.*;
import java.io.*;

public class Main {
    static Long [][] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        num = new Long[N+1][N+1];
        System.out.println(combination(N, K)%10007);
    }
    // 5C2 == 4C1 + 4C2
    public static long combination(int n, int r) {
        if(n == r || r == 0)
            return 1;
        if (num[n][r] == null) {
            num[n][r] = (combination(n-1, r-1)%10007) + (combination(n-1, r)%10007);
        }
        return num[n][r];
    }
}