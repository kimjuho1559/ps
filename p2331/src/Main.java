import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        int P = Integer.parseInt(st.nextToken());
        int num = 0;
        arrayList.add(Integer.parseInt(A));
        for (int i = 0; i < A.length();i++) {
            int a = Integer.parseInt(String.valueOf(A.charAt(i)));
            /*
            if (arrayList.contains((int)Math.pow(a,P))) {

            }*/
            num += (int) Math.pow(a, P);
        }
        arrayList.add(num);
        while (true) {
            num = 0;
            A = String.valueOf(arrayList.get(arrayList.size()-1));
            //System.out.println(A);
            for (int i = 0; i < A.length();i++) {
                int a = Integer.parseInt(String.valueOf(A.charAt(i)));
                num += (int) Math.pow(a, P);
            }
            if (arrayList.contains(num)) {
                break;
            }
            arrayList.add(num);
        }
        for (int i = 0; i < arrayList.size();i++) {
            if (arrayList.get(i) == num) {
                /*
                if (i == 0) {
                    System.out.println(0);
                    return;
                }*/
                //else {
                    System.out.println(i);
                    return;
                //}
            }
        }
    }
}