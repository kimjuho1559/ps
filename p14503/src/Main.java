import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
    int x, y, d;

    Point(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[N][M];
        bfs_array(r, c, d, arr, visited);
        System.out.println(count);
    }

    public static void bfs_array(int x, int y, int d, int[][] adjArray, boolean[][] visited) {
        Point robot = new Point(x, y, d);

        while (true) {
            // 1. 현재 위치를 청소한다.
            if (!visited[robot.x][robot.y]) {
                visited[robot.x][robot.y] = true;
                count++;
            }

            boolean canMove = false;

            // 2. 현재 방향을 기준으로 왼쪽 방향부터 탐색을 시작한다.
            for (int i = 0; i < 4; i++) {
                int nd = (robot.d + 3 - i) % 4; // 현재 방향 기준으로 왼쪽 방향
                int nx = robot.x + dx[nd];
                int ny = robot.y + dy[nd];

                // 왼쪽 방향이 청소하지 않은 공간이라면 이동한다.
                if (adjArray[nx][ny] == 0 && !visited[nx][ny]) {
                    robot.x = nx;
                    robot.y = ny;
                    robot.d = nd;
                    canMove = true;
                    break;
                }
            }

            // 네 방향 모두 청소가 되어있거나 벽인 경우
            if (!canMove) {
                // 후진할 좌표 계산
                int bx = robot.x - dx[robot.d];
                int by = robot.y - dy[robot.d];

                // 후진할 곳이 벽이 아니라면 후진
                if (adjArray[bx][by] == 0) {
                    robot.x = bx;
                    robot.y = by;
                } else {
                    // 후진할 곳이 벽이면서 뒤쪽도 벽인 경우에는 작동을 멈춤
                    break;
                }
            }
        }
    }
}
