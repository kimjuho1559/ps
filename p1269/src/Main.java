import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer>hmA = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N;i++) {
            hmA.put(Integer.parseInt(st.nextToken()),i);
        }
        HashMap<Integer,Integer>hmB = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int j = 0;j<M;j++) {
            hmB.put(Integer.parseInt(st.nextToken()),j);
        }
        int count = 0 ;
        Set<Integer>set = hmA.keySet();
        for (Integer key : set) {
            if (!hmB.containsKey(key))
                count++;
        }
        set = hmB.keySet();
        for (Integer key : set) {
            if(!hmA.containsKey(key))
                count++;
        }
        System.out.println(count);
    }
}