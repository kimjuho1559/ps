import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            long x = Long.parseLong(br.readLine());
            if (x > 0) {
                pq.offer(x);
            }
            else {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.remove());
                }
            }
        }
    }
}