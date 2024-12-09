import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double round = n * 0.15;
        int cut =(int) Math.round(round);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int total = 0;
        for (int i = cut; i < list.size()-cut; i++) {
            total += list.get(i);
        }
        System.out.println(Math.round((float) total / (list.size()-(cut*2))));
    }
}