package leetcode.Vol1to100;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LeetCode37 {
    private static final int MAX_N = 9;

    // 注意定义成static，在leetcode上提交代码却无法通过
    private static boolean[][] row = new boolean[MAX_N][MAX_N + 2];

    private static boolean[][] column = new boolean[MAX_N][MAX_N + 2];

    private static boolean[][] subSudoku = new boolean[MAX_N][MAX_N + 2];

    private static List<Node> nodes = new LinkedList<>();

    private static int numOfZero = 0;

    public static void solveSudoku(char[][] inputSudoku) {
        for (int i = 0; i < MAX_N; i++) {
            for (int j = 0; j < MAX_N; j++) {
                if (inputSudoku[i][j] != '.') {
                    row[i][inputSudoku[i][j] - '0'] = true;
                    column[j][inputSudoku[i][j] - '0'] = true;
                    subSudoku[(i / 3) * 3 + j / 3][inputSudoku[i][j] - '0'] = true;
                } else {
                    nodes.add(new Node(i, j));
                }
            }
        }

        numOfZero = nodes.size();
        DFS(0, inputSudoku);
    }

    public static boolean DFS(int dep, char[][] inputSudoku) {
        if (dep >= numOfZero) {
            return true;
        }

        for (int i = 1; i <= MAX_N; i++) {
            if (isValid(i, nodes.get(dep))) {
                inputSudoku[nodes.get(dep).x][nodes.get(dep).y] = (char)(i + '0');
                modifyStatus(i, nodes.get(dep), true);
                if (DFS(dep + 1, inputSudoku)) {
                    return true;
                }
                modifyStatus(i, nodes.get(dep), false);
                inputSudoku[nodes.get(dep).x][nodes.get(dep).y] = '.';
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

    public static class Node {
        int x;
        int y;

        Node() {}

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };

        char[][] board1 = new char[][]{
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };

//        solveSudoku(board);
        solveSudoku(board1);

        log.info(Arrays.deepToString(board));
        log.info(Arrays.deepToString(board1));
    }
}
