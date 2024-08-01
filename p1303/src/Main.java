import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x = 0;
    int y = 0;
    String color;
    public Point(int x, int y, String color) {
        this.x = x;
        this.y =y;
        this.color = color;
    }
}
public class Main {
    static Queue<Point> q = new LinkedList<>();
    static int []dx = {0,1,0,-1};
    static int []dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] graph = new String[N][M];
        boolean [][] visited = new boolean [N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                graph[i][M - st.countTokens()] = (st.nextToken());
            }
        }
    }
    static void dfs(String [][]graph, int i,int j,String color, boolean [][] visited) {
        //visited[i][j] = true;
        q.offer(new Point(i, j, color));
        while (q.isEmpty()) {
            Point point = q.remove();
            visited[point.x][point.y] = true;
            for (int k = 0; k < 4; k++) {
                if (graph[point.x + dx[k]][point.y + dy[k]].equals(point.color)) {

                }
            }
        }
    }
}