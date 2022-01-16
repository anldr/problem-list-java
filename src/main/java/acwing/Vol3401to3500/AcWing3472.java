package acwing.Vol3401to3500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing3472 {
    private static final int MAX_R = 8;

    private static final int MAX_N = 103;

    private static int total = 0;

    private static int[] ans = new int[MAX_N];

    private static int[] columns = new int[MAX_R + 3];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buf.readLine());

        // init
        findAnsByDfs(1);

        while (T-- > 0) {
            int n = Integer.parseInt(buf.readLine());

            System.out.println(ans[n]);
        }
    }

    public static void findAnsByDfs(int row) {
        if (row == (MAX_R + 1)) {
            total++;
            ans[total] = getNumOfAns();
            return ;
        }

        for (int col = 1; col <= MAX_R; col++) {
            if (isVaild(row, col)) {
                columns[row] = col;
                findAnsByDfs(row + 1);
            }
        }
    }

    public static boolean isVaild(int row, int col) {
        for (int i = 1; i < row; i++) {
            if (columns[i] == col || Math.abs(i - row) == Math.abs(columns[i] - col)) {
                return false;
            }
        }

        return true;
    }

    public static int getNumOfAns() {
        int result = 0;
        for (int i = 1; i <= MAX_R; i++) {
            result = result * 10 + columns[i];
        }

        return result;
    }
}
