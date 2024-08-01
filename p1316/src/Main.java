import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //static char [] arr = new char[100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N;i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                if (j == 0) {
                    sb.append(str.charAt(j));
                } else {
                    if (sb.charAt(sb.length() - 1) == str.charAt(j)) {
                        continue;
                    } else {
                        sb.append(str.charAt(j));
                    }
                }
            }
            String tmp = String.valueOf(sb);
            for (int j = 0; j < sb.length(); j++) {
                for (int k = 0; k < sb.length();k++) {
                    if (j == k) {
                        continue;
                    }
                    if (sb.charAt(j)==sb.charAt(k)) {
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}