import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] intList = new int[N];
        String[] stringList = new String[N];
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(br.readLine());
            stringList[i] = st.nextToken();
            intList[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(br.readLine());
            int low = 0;
            int high = intList.length - 1;
            while (low <= high) {
                int mid = (low+ high)/2;
                if (intList[mid] < num) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
            sb.append(stringList[low]+"\n");
        }
        System.out.println(sb);
    }
}