package acwing.Vol3701to3800;

import java.util.Scanner;

public class AcWing3729 {

    private static final int MAX_N = 100000 + 7;

    private static int[] result = new int[MAX_N];

    private static void changeRange(int l, int r) {
        result[l]++;
        result[r+1]--;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                result[i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                int a = scanner.nextInt();
                if (a >= i) {
                    changeRange(1, i);
                } else if (a > 0){
                    changeRange(i - a + 1, i);
                }
            }
            int answer = 0;
            for (int i = 1; i <= n; i++) {
                answer += result[i];
                if (answer >= 1) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println();
        }
    }
}
