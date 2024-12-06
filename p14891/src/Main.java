import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] array = new int[4][8];
        int[] pointer = new int[4]; // 12시 방향이 0 시계방향 +1 반시계 -1
        Arrays.fill(pointer, 2);
        String[] s;
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                array[i][j] = Integer.parseInt(s[j]);
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            try {
                if (array[a-1][pointer[a-1]] != array[a][(pointer[a]+4)%8]) {
                    if (array[a-1][(pointer[a-1]+4)%8] != array[a-2][pointer[a-2]]) {
                        if (b == -1) {
                            pointer[a - 1] = (pointer[a - 1] + 9) % 8;
                            pointer[a-2] = (pointer[a-2] + 7) % 8;
                            pointer[a] = (pointer[a] +7) % 8;
                        }
                        else {
                            pointer[a - 1] = (pointer[a - 1] +7) % 8;
                            pointer[a-2] = (pointer[a-2] + 9) % 8;
                            pointer[a] = (pointer[a] + 9) % 8;
                        }
                    }
                    else {
                        if (b == -1) {
                            pointer[a - 1] = (pointer[a - 1] + 9) % 8;
                            pointer[a] = (pointer[a] +7) % 8;
                        }
                        else {
                            pointer[a - 1] = (pointer[a - 1] +7) % 8;
                            pointer[a] = (pointer[a] + 9) % 8;
                        }
                    }
                }
                else {
                    if (array[a-1][pointer[a-1]+4] != array[a-2][pointer[a-2]]) {
                        if (b == -1) {
                            pointer[a - 1] = (pointer[a - 1] + 9) % 8;
                            pointer[a - 2] = (pointer[a - 2] +7) % 8;
                        }
                        else {
                            pointer[a - 1] = (pointer[a - 1] +7) % 8;
                            pointer[a] = (pointer[a] + 9) % 8;
                        }
                    }
                    else {
                        if (b == -1) {
                            pointer[a - 1] = (pointer[a - 1] + 9) % 8;
                        }
                        else {
                            pointer[a - 1] = (pointer[a - 1] +7) % 8;
                        }
                    }
                }
            }
            catch (IndexOutOfBoundsException e) {
                if (a == 0) {
                    a = 3;
                }
            }
        }
        int total = 0;
        if (array[0][(pointer[0] + 6)%8] == 1) {
            total += 1;
        }
        if (array[1][(pointer[1] + 6)%8] == 1) {
            total += 2;
        }
        if (array[2][(pointer[2] + 6)%8] == 1) {
            total += 4;
        }
        if (array[3][(pointer[3] + 6)%8] == 1) {
            total += 8;
        }
        System.out.println(total);
    }
    static void turn(int a) {
        if (a == 4) {

        }
        else {
            
        }
    }
}