import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrayList);
        int count = 0; //gcd(arrayList.get(i),j) == 1 ||
        for (int i = 0; i < arrayList.size()-1; i++) {
            boolean flag = false;
            if (gcd(arrayList.get(i), arrayList.get(i + 1)) != 1) {
                for (int j = arrayList.get(i) + 1; j < arrayList.get(i + 1); j++) {
                    if (gcd(arrayList.get(i), j) == 1 && gcd(arrayList.get(i+1),j) == 1) {
                        count++;
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    count += 2;
                }
            }
        }
        System.out.println(count);
    }
    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}