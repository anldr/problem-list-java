package hdu;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * HDU的题目需求额外处理循环输入
 * 不然会被Wrong Answer
 */
public class HDU1240 {
    private static int MAX_N = 13;

    private static int[] moveX = {0, 0, 1, -1, 0, 0};

    private static int[] moveY = {0, 0, 0, 0, 1, -1};

    private static int[] moveZ = {1, -1, 0, 0, 0, 0};

    private static String[][] universe = new String[MAX_N][MAX_N];

    private static boolean[][][] visit = new boolean[MAX_N][MAX_N][MAX_N];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int totalLine = 0;
            Coordinate start = null;
            Coordinate end = null;

            sc.next(); // 接收START
            int n = sc.nextInt();

            init(n);

            while (true) {
                String param = sc.next();

                if (param.charAt(0) == 'X' || param.charAt(0) == 'O') {
                    universe[totalLine / n][ totalLine % n] = param;
                    totalLine++;
                } else if (param.charAt(0) == 'E') {
                    Bfs(n, start, end);
                    break;
                } else {
                    if (start == null) {
                        start = new Coordinate();
                        start.x = Integer.parseInt(param);
                        param = sc.next();
                        start.y = Integer.parseInt(param);
                        param = sc.next();
                        start.z = Integer.parseInt(param);
                        start.step = 0;
                    } else {
                        end = new Coordinate();
                        end.x = Integer.parseInt(param);
                        param = sc.next();
                        end.y = Integer.parseInt(param);
                        param = sc.next();
                        end.z = Integer.parseInt(param);
                        end.step = 0;
                    }
                }
            }
        }
    }

    private static void init(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    visit[i][j][k] = false;
                }
            }
        }
    }

    private static void Bfs(int n, Coordinate start, Coordinate end) {
        Deque<Coordinate> que = new LinkedList<>();

        que.addLast(start);
        visit[start.z][start.x][start.y] = true;

        while (que.size() > 0 ) {
            Coordinate nowCoor = que.pollFirst();

            if (isCoorEqual(nowCoor, end)) {
                System.out.println(n + " " + nowCoor.step);
                return ;
            }

            for (int i = 0; i < 6; i++) {
                Coordinate moveTo = new Coordinate();
                moveTo.x = nowCoor.x + moveX[i];
                moveTo.y = nowCoor.y + moveY[i];
                moveTo.z = nowCoor.z + moveZ[i];

                if (isValid(moveTo, n) && !visit[moveTo.z][moveTo.x][moveTo.y] && universe[moveTo.z][moveTo.x].charAt(moveTo.y) != 'X') {
                    moveTo.step = nowCoor.step + 1;
                    que.addLast(moveTo);
                    visit[moveTo.z][moveTo.x][moveTo.y] = true;
                }
            }
        }

        System.out.println("NO ROUTE");
    }

    private static boolean isCoorEqual(Coordinate source, Coordinate target) {
        return source.x == target.x && source.y == target.y && source.z == target.z;
    }

    private static boolean isValid(Coordinate moveTo, int n) {
        return moveTo.x >= 0 && moveTo.x < n && moveTo.y >= 0 && moveTo.y < n
                && moveTo.z >=0 && moveTo.z < n;
    }

    static class Coordinate {
        public int x;
        public int y;
        public int z;
        public int step;

        Coordinate() {}
    }
}
