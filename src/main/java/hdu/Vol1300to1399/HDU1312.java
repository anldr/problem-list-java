package hdu.Vol1300to1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class HDU1312 {
    private static final int W = 27;

    private static final int[] moveX = {-1, 0, 1, 0};

    private static final int[] moveY = {0, 1, 0, -1};

    private static boolean[][] visit = new boolean[W][W];

    private static int n;

    private static int m;

    private static String[] maze = new String[W];

    private static int BFS(int x, int y) {
        Deque<Point> que = new LinkedList();
        que.addLast(new Point(x, y));
        visit[x][y] = true;

        int result = 1;
        while (que.size() > 0) {
            Point point = que.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nowX = point.x + moveX[i];
                int nowY = point.y + moveY[i];
                if (isValid(nowX, nowY)) {
                    result++;
                    que.addLast(new Point(nowX, nowY));
                    visit[nowX][nowY] = true;
                }
            }
        }

        return result;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && maze[x].charAt(y) == '.' && !visit[x][y];
    }

    private static void init() {
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < W; j++) {
                visit[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] params = buf.readLine().split(" ");
            n = Integer.parseInt(params[0]);
            m = Integer.parseInt(params[1]);

            if (n == 0 && m == 0) {
                return ;
            }

            init();

            for (int i = 0; i < m; i++) {
                maze[i] = buf.readLine();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i].charAt(j) == '@') {
                        System.out.println(BFS(i, j));
                        i = m;
                        j = n;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
