package acwing.Vol1401to1500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing1455_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String param = buf.readLine();
        int t = Integer.parseInt(param);

        for (int i = 0; i < t; i++) {
            String[] params = buf.readLine().split(" ");
            int n = Integer.parseInt(params[0]);
            int m = Integer.parseInt(params[1]);
            int[] array = new int[m];
            for (int j = 0; j < m; j++) {
                array[j] = Integer.parseInt(params[j + 2]);
            }

            // 定义并初始化dp数组
            int[][] dp = new int[n+1][m];
            for (int j = 0; j < m; j++) {
                dp[1][j] = 0;
            }

            for (int j = 2; j <= n; j++) {
                for (int k = 0; k < m; k++) {
                    dp[j][k] = (dp[j-1][(k+1) % m] + array[k]) % j;
                }
            }

//            for (int j = 1; j <= n; j++) {
//                System.out.print("i = " + j + ": ");
//                for (int k = 0; k < m; k++) {
//                    System.out.print(dp[j][k] + " ");
//                }
//                System.out.println();
//            }

            System.out.println(dp[n][0]);
        }
    }
}
