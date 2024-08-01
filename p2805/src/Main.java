import java.io.*;
import java.util.Arrays;

public class Main {
    static int bs(int key, int low, int high, int [] arr, int N) {
        int mid;
        while (low <= high) {
            long num = 0;
            mid = (low + high) / 2;
            for (int i = 0;i<N;i++) {
                int check = arr[i]-mid;
                if (check > 0) {
                    num += check;
                }
            }
            if (key >= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // 탐색 실패
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String [] sp = s.split(" ");
        int N = Integer.parseInt(sp[0]);
        int M = Integer.parseInt(sp[1]);
        String s1 = br.readLine();
        String [] sp1 = s1.split(" ");
        int []array = new int [N];
        for (int i =0; i < N;i++) {
            array[i] = Integer.parseInt(sp1[i]);
        }
        Arrays.sort(array);
        int low = 0;
        int high = array[N-1];
        int mid;
        while (low <= high) {
            long num = 0;
            mid = (low + high) / 2;
            //System.out.println(mid);
            for (int i = 0;i<N;i++) {
                int check = array[i]-mid;
                if (check > 0) {
                    num += check;
                }
            }
            if (M <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        bw.write(high+"\n");
        bw.flush();
        bw.close();
    }
}
