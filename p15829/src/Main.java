import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int L = Integer.parseInt(br.readLine());
        String strings = br.readLine();
        char [] chars = strings.toCharArray();
        BigInteger total = new BigInteger("0");
        for (int i = 0; i < chars.length; i++) {
            total = total.add(BigInteger.valueOf(chars[i] - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
        }
        sb.append(total.remainder(BigInteger.valueOf(1234567891)));
        System.out.println(sb);
    }
}