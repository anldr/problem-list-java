package acwing;

import java.util.*;

public class AcWing845 {
    private static final int MAX_N = 3;

    private static final int CONSTANT_FOUR = 4;

    private static final String target = "12345678x";

    private static int[] moveX = {-1, 0, 1, 0};

    private static int[] moveY = {0, 1, 0, -1};

    private static Coordinate findCoordinate(String grid) {
        int index = grid.indexOf('x');
        Coordinate coordinate = new Coordinate();
        coordinate.setX(index / MAX_N);
        coordinate.setY(index % MAX_N);
        return coordinate;
    }

    private static int change2Index(int x, int y) {
        return x * MAX_N + y;
    }

    private static void swapChar(char[] array, int x, int y) {
        char c = array[x];
        array[x] = array[y];
        array[y] = c;
    }

    private static int bfs(String start) {
        TreeMap<String, Integer> pathMap = new TreeMap<>();
        pathMap.put(start, 0);
        Deque<String> pathQue = new LinkedList<>();
        pathQue.offerLast(start);
        while (pathQue.size() > 0) {
            String temp = pathQue.getFirst();
            int value = pathMap.get(temp);
            Coordinate coordinate = findCoordinate(temp);
            int nowIndex = change2Index(coordinate.getX(), coordinate.getY());
            if (temp.equals(target)) {
                return value;
            }
            pathQue.removeFirst();
            // System.out.println("test: " + temp + "  x: " + coordinate.getX() + "y: " + coordinate.getY());
            for (int i = 0; i < CONSTANT_FOUR; i++) {
                char[] tempArr = temp.toCharArray();
                Coordinate move2Coordinate = new Coordinate();
                move2Coordinate.setX(coordinate.getX() + moveX[i]);
                move2Coordinate.setY(coordinate.getY() + moveY[i]);
                if (move2Coordinate.getX() >= 0 && move2Coordinate.getX() <= 2 && move2Coordinate.getY() >= 0 && move2Coordinate.getY() <= 2) {
                    int moveIndex = change2Index(move2Coordinate.getX(), move2Coordinate.getY());
                    swapChar(tempArr, nowIndex, moveIndex);
                    String tempStr = new String(tempArr);
                    if (!pathMap.containsKey(tempStr)) {
                        pathMap.put(tempStr, value + 1);
                        pathQue.offerLast(tempStr);
                        // System.out.println(tempStr);
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String start = new String("");
        for (int i = 0; i < input.length; i++) {
            start += input[i];
        }
        System.out.println(bfs(start));
    }

    static class Coordinate {
        int x;
        int y;

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }
    }
}
