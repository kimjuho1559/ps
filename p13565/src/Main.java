import java.util.*;
import java.io.*;

public class Main {
    static int []dx = {1, 0, -1 ,0};
    static int []dy = {0, -1, 0 ,1};
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int [][] graph = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j <N ; j++) {
                graph[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            bfs(graph, new Point(0, i));
        }
        for (int i = 0; i < N; i++) {
            if (visited[M - 1][i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    static void bfs(int [][] graph, Point point) {
        Queue<Point> q = new LinkedList<>();
        q.add(point);
        visited[point.x][point.y] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                //check(graph,cur.x + dx[i],cur.y+dy[i]) &&
                try {
                    if (graph[cur.x + dx[i]][cur.y + dy[i]] == 0 && !visited[cur.x + dx[i]][cur.y + dy[i]]) {
                        q.offer(new Point(cur.x + dx[i], cur.y + dy[i]));
                        visited[cur.x + dx[i]][cur.y + dy[i]] = true;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }
    static boolean check(int [][] graph, int x, int y) {
        return x >= 0 && x < graph.length && y >= 0 && y < graph.length;
    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}