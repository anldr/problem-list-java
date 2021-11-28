package acwing;

import java.util.Scanner;

public class AcWing3790 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int pre = scanner.nextInt();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            int t = scanner.nextInt();
            if (t - pre > c) {
                cnt = 0;
            } else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
