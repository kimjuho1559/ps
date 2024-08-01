import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0;
        int[] val = new int[2];
        int count = 0;
        int []check = new int [2];
        int total = 0;
        for (int i = 0; i < W; i++) {
            if (arr[i] >= max && arr[i] != 0) {
                val[count] = arr[i];
                max = arr[i];
                check[count] = i;
                count++;
            }
            if (count == 2) {
                count = 0;
                int minVal = Math.min(val[0], val[1]);
                for (int j = check[0]; j < check[1]; j++) {
                    total += (minVal - arr[j]);
                }
            }
        }
        System.out.println(total);
    }
}