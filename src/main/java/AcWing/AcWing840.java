package AcWing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AcWing840 {
    private static final int N = 100000 + 5;

    private static int index = 0;

    // 拉链法模拟散列表
    private static int[] head = new int[N];

    private static int[] edge = new int[N];

    private static int[] nextEdge = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            head[i] = -1;
        }

        String param = buffer.readLine();
        int n = Integer.parseInt(param);

        for (int i = 0; i < n; i++) {
            String[] params = buffer.readLine().split(" ");
            String op = params[0];
            int x = Integer.parseInt(params[1]);
            if (op.equals("I")) {
                inster(x);
            } else {
                System.out.println(find(x));
            }
        }
    }

    private static void inster(int x) {
        int k = (x % N + N) % N;
        edge[index] = x;
        nextEdge[index] = head[k];
        head[k] = index++;
    }

    private static String find(int x) {
        int k = (x % N + N) % N;
        for (int i = head[k]; i != -1; i = nextEdge[i]) {
            if (edge[i] == x) {
                return "Yes";
            }
        }
        return "No";
    }
}
