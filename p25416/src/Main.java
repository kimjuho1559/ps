import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[][] graph = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Point point = new Point(x, y);
        System.out.println(bfs(point));
    }

    public static int bfs(Point p) {
        visited[p.x][p.y] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(p);

        while (!q.isEmpty()) {
            Point point = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (check(nx, ny) && !visited[nx][ny]) {
                    if (arr[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = true;
                        graph[nx][ny] = graph[point.x][point.y] + 1;
                    } else if (arr[nx][ny] == 1) {
                        return graph[point.x][point.y] + 1;
                    }
                }
            }
        }

        return -1;
    }

    public static boolean check(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
