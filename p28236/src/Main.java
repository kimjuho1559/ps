import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int minClass = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x = m - d;
            if (min > x + f) {
                minClass = i + 1;
                min = x + f;
            }
        }
        System.out.println(minClass);
    }
}