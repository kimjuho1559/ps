import java.util.ArrayList;
import java.util.Scanner;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y =y;
    }
}

public class Main {
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int ans;
    static int N,M;
    static boolean[] open;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        int [][]arr = new int [N][N];
        for (int i = 0; i < N;i++) {
            for (int j = 0;j < N ;j++) {
                arr[i][j] = scanner.nextInt();
                if (arr[i][j] == 1)
                    house.add(new Point(i,j));
                else if (arr[i][j] == 2)
                    chicken.add(new Point(i,j));
            }
        }
        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];
        dfs(0);
        System.out.println(ans);
    }
    public static void dfs(int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int temp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            ans = Math.min(ans, res);
            return;
        }
        for (int i = 0; i < chicken.size(); i++) {
            open[i] = true;
            dfs(cnt + 1);
            open[i] = false;
        }
    }
}