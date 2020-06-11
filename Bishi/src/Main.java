import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println(0);
            return;
        }
        if (n % 50 == 0) {
            System.out.println(0);
            return;
        }
        if (n % 50 == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(f(n));
    }

    public static long f(int n) {
        long smaller = 0;
        long bigger = 1;
        for (int i = 2; i <= n; i++) {
            long tmp;
            if (i % 50 == 0) {
                tmp = 0;
            } else if (i % 50 == 1) {
                tmp = 1;
            } else {
                tmp = bigger + smaller * 2;
            }
            smaller = bigger;
            bigger = tmp;
        }
        return bigger;
    }
}