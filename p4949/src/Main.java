import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            Stack<Character> s = new Stack<>();
            String string = br.readLine();
            if (string.equals(".")) {
                break;
            }
            String [] strings = string.split(" ");
            boolean flag = false;
            for (int i = 0; i < strings.length; i++) {
                for (int j = 0; j < strings[i].length(); j++) {
                    if (strings[i].charAt(j) == '(') {
                        s.add(strings[i].charAt(j));
                    }
                    else if (strings[i].charAt(j) == '[') {
                        s.add(strings[i].charAt(j));
                    }
                    else if (strings[i].charAt(j) == ')') {
                        if (!s.isEmpty()) {
                            if (s.peek() == '(') {
                                s.pop();
                            }
                            else {
                                flag = true;
                                sb.append("no\n");
                                break;
                            }
                        }
                        else {
                            flag = true;
                            sb.append("no\n");
                            break;
                        }
                    }
                    else if (strings[i].charAt(j) == ']') {
                        if (!s.isEmpty()) {
                            if (s.peek() == '[') {
                                s.pop();
                            }
                            else {
                                flag = true;
                                sb.append("no\n");
                                break;
                            }
                        }
                        else {
                            flag = true;
                            sb.append("no\n");
                            break;
                        }
                    }
                }
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                if (!s.isEmpty()) {
                    sb.append("no\n");
                } else {
                    sb.append("yes\n");
                }
            }
        }
        System.out.println(sb);
    }
}