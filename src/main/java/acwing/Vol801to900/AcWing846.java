package acwing.Vol801to900;

import java.util.Scanner;

public class AcWing846 {
    private static final int MAX_N = 100000 + 7;

    private static int n;

    private static int idx = 0;

    private static int[] head = new int[MAX_N];

    private static int[] edge = new int[2 * MAX_N];

    private static int[] nextEdge = new int[2 * MAX_N];

    private static boolean[] visit = new boolean[MAX_N];

    private static int result;

    public static void add(int nodeA, int nodeB) {
        edge[idx] = nodeB;
        nextEdge[idx] = head[nodeA];
        head[nodeA] = idx++;
    }

    public static int dfs(int node) {
        visit[node] = true;

        int sum = 1;
        int tempResult = 0;
        for (int i = head[node]; i != -1; i = nextEdge[i]) {
            if (!visit[edge[i]]) {
                int tempSize = dfs(edge[i]);
                tempResult = Math.max(tempResult, tempSize);
                sum = sum + tempSize;
            }
        }
        tempResult = Math.max(tempResult, n - sum);
        result = Math.min(result, tempResult);

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            head[i] = -1;
        }
        result = n;
        for (int i = 0; i < n - 1; i++) {
            int nodeA = scanner.nextInt();
            int nodeB = scanner.nextInt();
            add(nodeA, nodeB);
            add(nodeB, nodeA);
        }
        dfs(1);
        System.out.println(result);
    }
}
