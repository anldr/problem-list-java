package acwing;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AcWing844 {
    private static final int MAX_N = 107;
    private static final int CONSTANT = 4;
    private static int[] moveX = {-1,0,1,0};
    private static int[] moveY = {0,1,0,-1};
    private static char[][] mazeMap = new char[MAX_N][MAX_N];
    private static int[][] distance = new int[MAX_N][MAX_N];
    private static int n;
    private static int m;
    public static boolean isOutOfRange(int x, int y) {
        if (x >= 1 && x <= n && y >= 1 && y <= m) {
            return true;
        }
        return false;
    }
    public static int bfs() {
        distance[1][1] = 0;
        Pair initCoordinate = new Pair(1,1);
        Deque<Pair> pathQue = new LinkedList<>();
        pathQue.offerLast(initCoordinate);
        while (pathQue.size() > 0) {
            Pair temp = pathQue.getFirst();
            pathQue.removeFirst();
            int nowX = temp.getKey();
            int nowY = temp.getValue();
            if (nowX == n && nowY == m) {
                return distance[nowX][nowY];
            }
            for (int i = 0; i < CONSTANT; i++) {
                int moveToX = nowX + moveX[i];
                int moveToY = nowY + moveY[i];
                if (isOutOfRange(moveToX, moveToY) && distance[moveToX][moveToY] == -1 && mazeMap[moveToX][moveToY] == '0') {
                    distance[moveToX][moveToY] = distance[nowX][nowY] + 1;
                    pathQue.offerLast(new Pair(moveToX,moveToY));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                mazeMap[i][j] = (char)(scanner.nextInt() + '0');
                distance[i][j] = -1;
            }
        }
        System.out.println(bfs());
    }

    static class Pair {
        int key;
        int value;
        Pair (int key, int value) {
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }
        public int getValue() {
            return value;
        }
    }
}
