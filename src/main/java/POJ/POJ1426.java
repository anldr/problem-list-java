package POJ;

import java.io.IOException;
import java.util.Scanner;

// 太难了终于A了!
public class POJ1426 {
    private static long[] que = new long[750001];

    private static int head;

    private static int tail;

    private static int n;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            n = scanner.nextInt();

            if (n == 0) {
                return ;
            }

            System.out.println(Bfs(n));
        }
    }

    private static long Bfs(int n) {
        // init que
        head = 0;
        tail = -1;

        que[++tail] = 1L;

        while (head <= tail) {
            long num = que[head++];

            if (num % n == 0) {
                return num;
            }

            if ((num * 10L) % n == 0) {
                return num * 10L;
            }
            que[++tail] = (num * 10L);

            if ((num * 10L + 1L) % n == 0) {
                return num * 10L + 1L;
            }
            que[++tail] = (num * 10L + 1L);
        }

        return 0;
    }
}