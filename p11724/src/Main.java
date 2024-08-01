import java.io.IOException;
import java.util.Scanner;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int N, M;
    static int answer = 0;

    public static void dfs(int idx) {
        visited[idx] = true;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[idx][i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 및 초기화
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 그래프 정보 입력
        int x, y;
        for (int i = 0; i < M; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        for (int j = 1; j <= N; j++) {
            if (!visited[j]) {
                dfs(j);
                answer++;
            }
        }

        System.out.println(answer);

        sc.close();
    }
}