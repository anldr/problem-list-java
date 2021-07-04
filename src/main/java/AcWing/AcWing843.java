package AcWing;

import java.util.Scanner;

public class AcWing843 {
    private static int n;
    private static final int MAX_N = 13;
    private static boolean[] column = new boolean[MAX_N];
    private static boolean[] diagonal = new boolean[MAX_N * 2];
    private static boolean[] undiagonal = new boolean[MAX_N * 2];
    private static char[][] chessMap = new char[MAX_N][MAX_N];
    public static void printChessMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chessMap[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void dfs(int deep) {
        if (deep == n) {
            printChessMap();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column[i] || diagonal[deep + i] || undiagonal[n - deep + i]) {
                continue;
            }
            chessMap[deep][i] = 'Q';
            column[i] = true;
            diagonal[deep + i] = true;
            undiagonal[n - deep + i] = true;
            dfs(deep + 1);
            chessMap[deep][i] = '.';
            column[i] = false;
            diagonal[deep + i] = false;
            undiagonal[n - deep + i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessMap[i][j] = '.';
            }
        }
        dfs(0);
    }
}