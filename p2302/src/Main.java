import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int []fixSit = new int [M];
        for (int i = 0;i < M;i++) {
            fixSit[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0 ; i < N;i++) {

        }
        bw.flush();
        bw.close();
    }
}