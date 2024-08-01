import javax.print.attribute.standard.OrientationRequested;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        long mid;
        long low = 1;
        long res = 0;
        long high = arr[K - 1];
        while (low <= high) {
            long count = 0;
            mid = (low + high) / 2;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }
            if (N > count) {
                high = mid - 1;
            } else {
                res = Math.max(res, mid);
                low = mid + 1;
            }
        }
        System.out.println(res);
    }
}