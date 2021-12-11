package acwing.Vol3701to3800;

import java.util.Scanner;

public class AcWing3732 {
    private static final int MAX_N = 503;
    public static int[][] nums = new int[MAX_N][MAX_N];
    public static int findNum (int x, int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums[i][j] == x) {
                    return i;
                }
            }
        }
        return  -1;
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T > 0) {
            T--;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    nums[i][j] = scanner.nextInt();
                }
            }
            int[] rows = new int[MAX_N];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int x = scanner.nextInt();
                    if (i == 1) {
                        rows[j] = findNum(x, n, m);
                    }
                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    System.out.print(nums[rows[i]][j] + " ");
                }
                System.out.println("");
            }
        }
    }
}
