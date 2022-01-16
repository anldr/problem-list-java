package poj.Vol2500to2599;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class POJ2531 {
    private static final int MAX_N = 20;

    private static int n = 0;

    private static int result = Integer.MIN_VALUE;

    private static boolean[] setArr = new boolean[MAX_N + 3];

    private static int[][] martix = new int[MAX_N + 3][MAX_N + 3];

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buf.readLine());

        for (int i = 1; i <= n; i++) {
            String[] params = buf.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                martix[i][j] = Integer.parseInt(params[j - 1]);
            }
        }

        // init
        for (int i = 0; i <= MAX_N; i++) {
            setArr[i] = false;
        }

        DFS(1, 0);

        System.out.println(result);
    }

    public static void DFS(int dep, int tmpSum) {
        // cacl ans
        if (dep == (n + 1)) {
            result = Math.max(result, tmpSum);
            return ;
        }

        // two strategies
        int sum = 0;

        DFS(dep + 1, tmpSum + sum);

        setArr[dep] = true;
        for (int i = 1; i <= n; i++) {
            if (setArr[dep] != setArr[i]) {
                sum += martix[dep][i];
            } else {
                sum -= martix[dep][i];
            }
        }
        DFS(dep + 1, tmpSum + sum);

        setArr[dep] = false;
    }
}
