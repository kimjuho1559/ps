import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringBuilder result = new StringBuilder();
            Deque<Integer> list = new ArrayDeque<>();
            String s = br.readLine();
            char[] ch = s.toCharArray();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            if (n > 0) {
                String[] numbers = str.substring(1, str.length() - 1).split(",");
                for (String num : numbers) {
                    list.add(Integer.parseInt(num));
                }
            }
            try {
                boolean flag = false;
                for (int j = 0; j < ch.length; j++) {
                    if (ch[j] == 'R') {
                        flag = !flag;
                    } else if (ch[j] == 'D') {
                        if (list.isEmpty()) {
                            throw new Exception();
                        }
                        if (!flag) {
                            list.pollFirst();
                        }
                        else {
                            list.pollLast();
                        }
                    }
                }
                result.append("[");
                if (!flag) {
                    while (!list.isEmpty()) {
                        result.append(list.pollFirst());
                        if (!list.isEmpty()) {
                            result.append(",");
                        }
                    }
                }
                else {
                    while (!list.isEmpty()) {
                        result.append(list.pollLast());
                        if (!list.isEmpty()) {
                            result.append(",");
                        }
                    }
                }
                result.append("]");
                System.out.println(result);
            }
            catch (Exception e) {
                System.out.println("error");
            }
        }
    }
}