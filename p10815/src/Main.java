import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[N];
        HashMap<Integer, Boolean> hm = new HashMap<>();
        while (st.hasMoreTokens()) {
            //arr[N-st.countTokens()] = Integer.parseInt(st.nextToken());
            hm.put(Integer.parseInt(st.nextToken()), Boolean.TRUE);
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int low = 0;
            int high = arr.length-1;
            int num = Integer.parseInt(st.nextToken());
            try {
                if (hm.get(num)) {
                    sb.append("1 ");
                }
            }
            catch (Exception e) {
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }
}