import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Point {
    int num;
    boolean flag;
    Point(int num, boolean flag) {
        this.num = num;
        this.flag = flag;
    }
}
public class Main {
    static LinkedList<Point> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            /*
            if (M == 1) {
                System.out.println(1);
                continue;
            }*/
            int anw = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Point p;
                if (anw == j) {
                    p = new Point(Integer.parseInt(st.nextToken()), true);
                }
                else {
                    p = new Point(Integer.parseInt(st.nextToken()), false);
                }
                q.offer(p);
            }
            int count = 0;
            boolean bool;
            while (!q.isEmpty()) {
                bool = false;
                Point p = q.poll();
                for (int r = 0; r < q.size(); r++) {
                    if (q.get(r).num > p.num) {
                        bool = true;
                        break;
                    }
                }
                if (!bool) {
                    if (p.flag) {
                        System.out.println(count+1);
                        break;
                    }
                    else {
                        count++;
                    }
                }
                else {
                    q.offer(p);
                }
            }
        }
    }
}