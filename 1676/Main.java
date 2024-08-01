import java.util.Scanner;

public class Main {
    static public void main(String argv[]) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int num1 = N/5;
        int num2 = N/25;
        int count = num1+num2;
        System.out.print(count);
    }
}