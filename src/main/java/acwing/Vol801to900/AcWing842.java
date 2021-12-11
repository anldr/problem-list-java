package acwing.Vol801to900;

import java.util.Scanner;

public class AcWing842 {
    private static final int MAX_N = 10;
    private static boolean[] used = new boolean[MAX_N];
    public static void dfs(int deep, int n, StringBuffer output) {
        if (deep == n) {
            System.out.println(output);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(deep + 1, n, output.append(i + " "));
                used[i] = false;
                output.delete(output.length() - 2, output.length());
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer output = new StringBuffer("");
        dfs(0, n, output);
    }
}
