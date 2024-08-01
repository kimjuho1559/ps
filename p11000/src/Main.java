import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Study {
    int S;
    int N;
    public Study(int S, int N) {
        this.S = S;
        this.N = N;
    }
    public String toString() {
        return "S = " + S + " N = " + N;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(N);
        Study [] study = new Study[N];
        for (int i = 0;i < N;i++) {
            String s = bf.readLine();
            StringTokenizer st = new StringTokenizer(s," ");
            study[i] = new Study(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(study, (s1,s2) -> {
            return Integer.compare(s1.S,s2.S);
        });
        /*
        for (int i = 0; i < N;i++) {
            System.out.println(study[i].toString());
        }*/
        int cnt = 1;
        pq.offer(study[0].N);
        for (int i = 1;i < study.length;i++) {
            if (study[i].S < pq.peek()) {
                cnt++;
                pq.offer(study[i].N);
            } else {
                pq.poll();
                pq.offer(study[i].N);
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}