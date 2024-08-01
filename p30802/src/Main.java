import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (arr[i]%T == 0)
                count += (arr[i]/T);
            else
                count += (arr[i] / T) + 1;
        }
        int count1 = N / P;
        int count2 = N %P;
        System.out.println(count);
        System.out.println(count1 +" " +count2);
    }
}