package poj.Vol2600to2699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class POJ2676 {
    private static final int MAX_N = 9;

    private static char[][] inputSudoku = new char[MAX_N][MAX_N];

    private static boolean[][] row = new boolean[MAX_N][MAX_N + 2];

    private static boolean[][] column = new boolean[MAX_N][MAX_N + 2];

    private static boolean[][] subSudoku = new boolean[MAX_N][MAX_N + 2];

    private static List<Node> nodes = new LinkedList<Node>();

    private static int numOfZero = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buf.readLine());

        while (T-- > 0) {
            for (int i = 0; i < MAX_N; i++) {
                inputSudoku[i] = buf.readLine().toCharArray();
            }

            // init---1
            for (int i = 0; i < MAX_N; i++) {
                for (int j = 1; j <= MAX_N; j++) {
                    row[i][j] = false;
                    column[i][j] = false;
                    subSudoku[i][j] = false;
                }
            }
            nodes.clear();

            // init---2
            for (int i = 0; i < MAX_N; i++) {
                for (int j = 0; j < MAX_N; j++) {
                    if (inputSudoku[i][j] != '0') {
                        row[i][inputSudoku[i][j] - '0'] = true;
                        column[j][inputSudoku[i][j] - '0'] = true;
                        subSudoku[(i / 3) * 3 + j / 3][inputSudoku[i][j] - '0'] = true;
                    } else {
                        nodes.add(new Node(i, j));
                    }
                }
            }

            numOfZero = nodes.size();

            DFS(0);
        }
    }

    public static boolean DFS(int dep) {
        if (dep >= numOfZero) {
            // ooutput answer
            outputAnswer();

            return true;
        }

        for (int i = 1; i <= MAX_N; i++) {
            if (isValid(i, nodes.get(dep))) {
                inputSudoku[nodes.get(dep).x][nodes.get(dep).y] = (char)(i + '0');
                modifyStatus(i, nodes.get(dep), true);
                if (DFS(dep + 1)) {
                    return true;
                }
                modifyStatus(i, nodes.get(dep), false);
                inputSudoku[nodes.get(dep).x][nodes.get(dep).y] = '0';
            }
        }

        return false;
    }

    public static boolean isValid(int x, Node node) {
        int r = node.x;
        int c = node.y;

        return !(row[r][x] || column[c][x] || subSudoku[(r / 3) * 3 + c / 3][x]);
    }

    public static void modifyStatus(int x, Node node, boolean value) {
        int r = node.x;
        int c = node.y;

        row[r][x] = value;
        column[c][x] = value;
        subSudoku[(r / 3) * 3 + c / 3][x] = value;
    }

    public static void outputAnswer() {
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                System.out.print(inputSudoku[i][j]);
            }
            System.out.println();
        }
    }

    static class Node {
        int x;
        int y;

        Node() {}

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
