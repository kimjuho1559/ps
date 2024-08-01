import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int []switchNum = new int [N];
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        for (int i = 0; i < switchNum.length; i++) {
            switchNum[i] = Integer.parseInt(st.nextToken());
        }
        int A = Integer.parseInt(br.readLine());
        for (int i = 0; i < A;i++) {
            s = br.readLine();
            st = new StringTokenizer(s, " ");
            if (st.nextToken().equals("1")) {
               int num = Integer.parseInt(st.nextToken());
               int count = 1;
               while (true) {
                   int num1 = (num * count)-1;
                   if (num1 >= switchNum.length)
                       break;
                   if (switchNum[num1] == 0) {
                       switchNum[num1] = 1;
                   }
                   else {
                       switchNum[num1] = 0;
                   }
                   count++;
               }
            }
            else {
                int num = Integer.parseInt(st.nextToken())-1;
                if (switchNum[num] == 0) {
                    switchNum[num] = 1;
                }
                else {
                    switchNum[num] = 0;
                }
                int temp = num;
                while (true) {
                    int num1 = --num;
                    int num2 = ++temp;
                    if (num2 >= switchNum.length || num1 < 0)
                        break;
                    if (switchNum[num1]==switchNum[num2]) {
                        if (switchNum[num1] == 0) {
                            switchNum[num1] = 1;
                            switchNum[num2] = 1;
                        }
                        else {
                            switchNum[num1] = 0;
                            switchNum[num2] = 0;
                        }
                    }
                    else {
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < switchNum.length;i++) {
            if (i % 20 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(switchNum[i] + " ");
        }
    }
}