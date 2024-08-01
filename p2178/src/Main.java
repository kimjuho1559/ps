import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static boolean [][] visited;
    static int[][] matrix;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int N;
    static int M;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt(); // 정점의 개수
        M = scanner.nextInt(); // 간선의 개수
        matrix = new int[N][M];
        visited = new boolean[N][M]; // 정점 방문 확인
        for (int i = 0; i< N;i++) {
            String str = scanner.next();
            for (int j = 0; j < str.length();j++) {
                matrix[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0,0);
        System.out.println(matrix[N-1][M-1]);
    }
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()) {
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;
                if (visited[nextX][nextY] || matrix[nextX][nextY] == 0)
                    continue;

                q.add(new int[] {nextX, nextY});
                matrix[nextX][nextY] = matrix[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }
    }
}