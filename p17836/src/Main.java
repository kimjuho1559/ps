import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sword = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], -1);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(graph, visited, new Point(0, 0), arr);
        int result = arr[n - 1][m - 1];
        if (sword < result || result == -1) {
            result = sword;
        }
        if (result == -1 || result > t) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    static void bfs(int[][] graph, boolean[][] visited, Point point, int[][] arr) {
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        visited[point.x][point.y] = true;
        arr[point.x][point.y] = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y]) continue;
                if (graph[x][y] == 2) {
                    int distance = arr[p.x][p.y] + 1;
                    int end = distance + (n - 1 - x) + (m - 1 - y);
                    sword = Math.min(sword, end);
                }
                if (graph[x][y] == 0) {
                    visited[x][y] = true;
                    arr[x][y] = arr[p.x][p.y] + 1;
                    q.offer(new Point(x, y));
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
