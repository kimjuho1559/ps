import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[100001];	// 생성자 존재 표시할 배열

        for(int i=1; i<=10000; i++) {	// 1부터 10000까지
            int n = d(i);	// 현재 제어변수 값을 전달하고 생성자로 생성한 숫자 받아오기
            num[n]++;	// 배열의 인덱스를 생성자가 존재하는 숫자로 지정하고 표시
        }

        for(int i=1; i<=10000; i++) {
            if(num[i]==0) {	// 셀프 넘버인 경우(생성자가 없는 숫자인 경우)
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }

        bw.flush();
        bw.close();
    }

    public static int d(int n) {
        int sum = n;
        String str = String.valueOf(n);	// 각 자리를 추출

        for(int i=0; i<str.length(); i++)
            sum += Character.getNumericValue(str.charAt(i));

        return sum;
    }
}