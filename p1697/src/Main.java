import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (N == M) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[1000000];
        boolean[] visited = new boolean[1000000];
        bfs(N, arr, visited, M);
        //if ()
        System.out.println(arr[M]-1);
        /*for (int i = 0; i < M; i++) {
            System.out.print(arr[i] + " ");
        }*/
    }
    static Queue<Integer> q = new LinkedList<>();
    public static void bfs(int N, int [] arr, boolean[]visited, int M) {

        arr[N] = 1;
        visited[N] = true;
        q.add(N);

        while (!q.isEmpty()) {
            int n = q.poll();
            if (n == M) {
                break;
            }
            if (n - 1 >= 0 && !visited[n - 1]) {
                q.add(n - 1);
                visited[n - 1] = true;
                arr[n - 1] = arr[n] + 1;
            }
            if (n + 1 <= 100000 &&!visited[n + 1]) {
                q.add(n + 1);
                visited[n + 1] = true;
                arr[n + 1] = arr[n] + 1;
            }
            if (n * 2 <= 100000 && !visited[2 * n]) {
                q.add(2 * n);
                visited[2 * n] = true;
                arr[2 * n] = arr[n] + 1;
            }
        }
    }
}