import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int []arr;
    static boolean []check;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        check = new boolean[N];
        dfs(0,0);
    }
    public static void dfs(int st, int depth) {
        if (depth == M) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        for (int i = st; i <N;i++) {
            if(!check[i]) {
                check[i] = true;
                arr[depth] = i+1;
                dfs(st+1,depth+1);
                check[i] = false;
            }
        }
    }
}