import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0;i < n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (hm.containsKey(x)) {
                if (hm.get(x) > y) {
                    hm.put(x,y);
                }
            }
            else {
                hm.put(x,y);
            }
        }
        int total = 0;
        Set<Integer> keySet = hm.keySet();
        for (Integer key : keySet) {
            total += hm.get(key);
        }
        System.out.println(total);
    }
}