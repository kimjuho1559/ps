import java.io.*;
import java.util.*;
class Birth {
    int d;
    int m;
    int y;
    Birth(int d, int m, int y) {
        this.d = d;
        this.m = m;
        this.y = y;
    }

    public int compareTo(Birth birth) {
        if (y > birth.y) {
            return 1;
        }
        else if (y == birth.y) {
            if (m > birth.m) {
                return 1;
            }
            else if (m == birth.m) {
                if (d > birth.d) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }
}

public class Main {
    static Map<String, Birth> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            hm.put(name, new Birth(d, m, y));
        }

        List<String> keySet = new ArrayList<>(hm.keySet());
        // Value 값으로 오름차순 정렬
        keySet.sort((o1, o2) -> hm.get(o1).compareTo(hm.get(o2)));
        System.out.println(keySet.get(n - 1));
        System.out.println(keySet.get(0));
    }
}