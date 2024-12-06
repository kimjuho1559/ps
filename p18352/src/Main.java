import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<Integer>q[];
    static List<Integer>answer;
    static int []dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        q = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            q[i] = new ArrayList<>();
        }
        answer = new ArrayList<>();
        dist = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            q[a].add(b);
        }
        Arrays.fill(dist, -1);
        bfs(k, x, n);
        Collections.sort(answer);
        for (int cur : answer) {
            sb.append(cur).append("\n");
        }
        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
    public static void bfs(int k, int x, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        dist[x] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (dist[cur] > k)
                break;
            if (dist[cur] == k)
                answer.add(cur);
            for (int next : q[cur]) {
                if (dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                queue.add(next);
            }
        }
    }
}