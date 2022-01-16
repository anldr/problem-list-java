package poj.Vol1000to1099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class POJ1077 {
    private static final int MAX_STATUS = 362880 + 7;

    private static boolean[] visit = new boolean[MAX_STATUS];

    private static final int[] moveX = {-1, 0, 1, 0};

    private static final int[] moveY = {0, 1, 0, -1};

    private static final String[] moveStr = {"u", "r", "d", "l"};

    private static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String[] params = buf.readLine().split(" ");

        int[] startStatus = new int[9];
        for (int i = 0; i < 9; i++) {
            if (params[i].charAt(0) == 'x') {
                startStatus[i] = 0;
            }
            else {
                startStatus[i] = Integer.parseInt(params[i]);
            }
        }

        BFS(startStatus);

    }

    public static void BFS(int[] startStatus) {
        Deque<Node> que = new LinkedList<Node>();

        visit[getCantor(startStatus, 9)] = true;
        que.addLast(new Node(startStatus.clone(), "", 0));

        while (que.size() > 0) {
            Node now = que.pollFirst();

            if (getCantor(now.status, 9) == 46233) {
                // output answer
                System.out.print(now.path);
                return ;
            }

            int pos = findZero(now.status);
            int oldX = pos / 3;
            int oldY = pos % 3;
            for (int i = 0; i < 4; i++) {
                int newX = oldX + moveX[i];
                int newY = oldY + moveY[i];

                if (isValid(newX, newY)) {
                    int newPos = newX * 3 + newY;

                    Node newNode = new Node();
                    newNode.status = now.status.clone();
                    newNode.step = now.step + 1;
                    newNode.path = now.path + moveStr[i];

                    newNode.status[pos] = now.status[newPos];
                    newNode.status[newPos] = 0;

                    int cantorNum = getCantor(newNode.status, 9);
                    if (!visit[cantorNum]) {
                        visit[cantorNum] = true;
                        que.addLast(newNode);
                    }
                }
            }
        }

        System.out.print("unsolvable");
    }

    public static int getCantor(int[] status, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int j = n - 1; j > i; j--) {
                if (status[j] < status[i]) {
                    t++;
                }
            }
            result += t * factorial[n - i - 1];
        }
        return result;
    }

    public static int findZero(int[] status) {
        for (int i = 0; i < 9; i++) {
            if (status[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }

    static class Node{
        public int[] status;
        public int step;

        String path;

        Node() {}

        Node(int[] status, String path, int step) {
            this.status = status;
            this.path = path;
            this.step = step;
        }
    }
}
