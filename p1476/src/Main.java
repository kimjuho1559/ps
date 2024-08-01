import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        if (E == S && S == M) {
            System.out.println(E);
        }
        else if (S == M) {
            System.out.println(S);
        }
        else {
            getLCM(E+15,S+28,M+19);
        }

    }
    public static void getLCM(int E, int S, int M) {
        int gcd = getGCD(E, S);
        int lcm = (E * S) / gcd;

            gcd = getGCD(lcm, M);
            lcm = (lcm *M) / gcd;

        System.out.println(lcm);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
}