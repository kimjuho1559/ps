import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String []string = str.split(" ");
        int N = Integer.parseInt(string[0]);
        int M = Integer.parseInt(string[1]);
        int [] arr = new int[N];
        for (int i = 0; i < N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (end < N) {
            int num = arr[end]- arr[start];
            if (num == M) {
                System.out.println(M);
                return;
            }
            else if (num > M) {
                min = Math.min(min,num);
                start++;
            }
            else {
                //System.out.println(start +", " +end);
                end++;
            }
        }
        System.out.println(min);
        /*
        for (int i = 0; i < N;i++) {
            for (int j = i; j < N;j++) {
                if (arr[j] - arr[i] == M) {
                    System.out.println(M);
                    return;
                }
                else if (arr[j] - arr[i] > M) {
                    if (min > arr[j]-arr[i]) {
                        min = arr[j] - arr[i];
                    }
                }
            }
        }*/
    }
}