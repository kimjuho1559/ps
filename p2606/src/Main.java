import java.io.*;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] edges = new int[M][2];

        int[][] matrix = new int[N + 1][N + 1];
        boolean [] visited = new boolean[N+1];
        for (int i = 0; i< M;i++) {
            for (int j = 0;j < 2;j++) {
                edges[i][j] = scanner.nextInt();
            }
        }
        for (int[] edge : edges) {
            matrix[edge[0]][edge[1]] = 1;
            matrix[edge[1]][edge[0]] = 1;
        }
        bfs_array(1,matrix,visited);
        System.out.println(count-1);
    }
    public static void bfs_array(int v, int[][] adjArray, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int n = adjArray.length - 1;

        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            v = q.poll();
            count++;

            for (int i = 1; i <= n; i++) {
                if (adjArray[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}