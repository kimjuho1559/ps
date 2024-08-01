import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x = 0;
    int y = 0;
    Point(int x, int y) {
        this.x = x;
        this.y =y;
    }
}

public class Main {
    static int []dx = {1,-1,0,0};
    static int []dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x=0;
        int y= 0;
        int [][]arr = new int [n][m];
        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }
        int [][]graph = new int[n][m];
        boolean [][]visited = new boolean[n][m];
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m;j++) {
                visited[i][j] = false;
            }
        }
        bfs_array(x,y,arr, visited, graph);
        for (int i = 0; i < n;i++) {
            for (int j = 0; j < m;j++) {
                if (arr[i][j] == 0) {
                    System.out.print("0 ");
                }
                else if (!visited[i][j]) {
                    System.out.print("-1 ");
                }
                else {
                    System.out.print(graph[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void bfs_array(int x, int y, int[][] adjArray, boolean[][] visited, int [][]graph) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x,y));
        visited[x][y] = true;
        graph[x][y] = 0;
        while (!q.isEmpty()) {
            Point v = q.poll();

            for (int i = 0; i < 4; i++) {
                try {
                    if (adjArray[v.x + dx[i]][v.y + dy[i]] == 1 && !visited[v.x+dx[i]][v.y+dy[i]]) {
                        graph[v.x + dx[i]][v.y + dy[i]] = graph[v.x][v.y] + 1;
                        q.add(new Point(v.x + dx[i], v.y + dy[i]));
                        visited[v.x + dx[i]][v.y + dy[i]] = true;
                    }
                    else if (adjArray[v.x + dx[i]][v.y + dy[i]] == 0) {
                        graph[v.x + dx[i]][v.y + dy[i]] = 0;
                        visited[v.x + dx[i]][v.y + dy[i]] = true;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    }
}