package acwing.Vol4201to4300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A* 搜索
 */

public class AcWing4228_2 {
    private static final int MAX_STATUS = 362880 + 7;

    private static String[] pathForward = new String[MAX_STATUS];

    private static String[] pathReverse = new String[MAX_STATUS];

    private static int[] pathStepForward = new int[MAX_STATUS];

    private static int[] pathStepReverse = new int[MAX_STATUS];

    private static boolean[] pathTypeForward = new boolean[MAX_STATUS];

    private static boolean[] pathTypeReverse = new boolean[MAX_STATUS];

    private static final int[] moveX = {1, 0, 0, -1};

    private static final int[] moveY = {0, -1, 1, 0};

    private static final String[] moveStr = {"d", "l", "r", "u"};

    private static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int cas = 0;
        int T = Integer.parseInt(buf.readLine());

        while (T > 0) {
            T--;
            String startStatus = buf.readLine();
            String targetStatus = buf.readLine();

            //init visited
            for (int i = 0; i < MAX_STATUS; i++) {
                pathForward[i] = "-1";
                pathReverse[i] = "-1";
                pathStepForward[i] = -1;
                pathStepReverse[i] = -1;
                pathTypeForward[i] = false;
                pathTypeReverse[i] = false;
            }

            BFS(startStatus, targetStatus, ++cas);
        }
    }

    public static void BFS(String startStatus, String targetStatus, int cas) {
        Deque<String> que = new ArrayDeque<>();

        int startNum = getCantor(startStatus, 9);
        int targetNum = getCantor(targetStatus, 9);

        pathForward[startNum] = "";
        pathReverse[targetNum] = "";

        pathStepForward[startNum] = 0;
        pathStepReverse[targetNum] = 0;

        pathTypeForward[startNum] = true;
        pathTypeReverse[targetNum] = true;

        que.addLast(startStatus);
        que.addLast(targetStatus);

        while (que.size() > 0) {
            String nowNode = que.pollFirst();

            int nowPos = findZero(nowNode);
            int oldX = nowPos / 3;
            int oldY = nowPos % 3;
            for (int i = 0; i < 4; i++) {
                int newX = oldX + moveX[i];
                int newY = oldY + moveY[i];

                if (isValid(newX, newY)) {
                    int newPos = newX * 3 + newY;

                    StringBuilder sb = new StringBuilder(nowNode);
                    sb.setCharAt(nowPos, nowNode.charAt(newPos));
                    sb.setCharAt(newPos, 'X');
                    String newNode = sb.toString();

                    int oldCanNum = getCantor(nowNode, 9);
                    int newCanNum = getCantor(newNode, 9);

                    if (pathTypeForward[oldCanNum] && pathForward[newCanNum].equals("-1")) {
                        pathTypeForward[newCanNum] = true;
                        pathForward[newCanNum] = pathForward[oldCanNum] + moveStr[i];
                        pathStepForward[newCanNum] = pathStepForward[oldCanNum] + 1;

                        if (!pathReverse[newCanNum].equals("-1")) {
                            System.out.println("Case " + cas + ": " + (pathStepForward[newCanNum] + pathStepReverse[newCanNum]));
                            System.out.println(pathForward[newCanNum] + pathReverse[newCanNum]);
                            return ;
                        }

                        que.addLast(newNode);
                    } else if (pathTypeReverse[oldCanNum]) {
                        pathTypeReverse[newCanNum] = true;

                        String movePath = moveStr[3 - i] + pathReverse[oldCanNum];
                        pathStepReverse[newCanNum] = pathStepReverse[oldCanNum] + 1;
                        if (pathReverse[newCanNum].equals("-1")) {
                            pathReverse[newCanNum] = movePath;
                        } else {
                            if (movePath.compareTo(pathReverse[newCanNum]) < 0) {
                                pathReverse[newCanNum] = movePath;
                            }
                        }

                        que.addLast(newNode);
                    }
                }
            }
        }

        System.out.println("unsolvable");
    }

    public static int getCantor(String status, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            int iValue = status.charAt(i) == 'X' ? 0 : status.charAt(i) - '0';
            for (int j = n - 1; j > i; j--) {
                int jValue = status.charAt(j) == 'X' ? 0 : status.charAt(j) - '0';
                if (jValue < iValue) {
                    t++;
                }
            }
            result += t * factorial[n - i - 1];
        }
        return result;
    }

    public static int findZero(String status) {
        for (int i = 0; i < 9; i++) {
            if (status.charAt(i) == 'X') {
                return i;
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
