import java.io.*;
import java.math.BigInteger;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num; //원판 갯수
        num = Integer.parseInt(br.readLine());
        BigInteger num1 = new BigInteger("2");
        System.out.println((num1.pow(num).subtract(new BigInteger("1"))));

        if (num <= 20) {
            hanoi(1, 2, 3, num);
        }
        bw.flush();
        bw.close();
    }
    static int count = 0;
    public static void hanoi(int from, int m, int to, int num) throws IOException {//from -> to 로 원판num이 이동
        if (num == 0)
            return;
        hanoi(from, to, m, num - 1); // 원판num-1은 from -> m으로 이동
        bw.write(from+" "+to + "\n");
        count++;
        //System.out.println(from +" "+ to);//원판num이 from -> to 이동
        hanoi(m, from, to, num - 1); // 원판num-1이 m -> to로 이동
    }
}