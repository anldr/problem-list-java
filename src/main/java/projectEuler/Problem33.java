package projectEuler;

public class Problem33 {
    public static void main(String[] args) {
        int up = 1;
        int down = 1;
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                for (int c = 1; c <= 9; c++) {
                    if ((a * 10 + c) * b == (c * 10 + b) * a && a != b) {
                        System.out.println((a * 10 + c) + " " + (c * 10 + b));
                        up = up * a;
                        down = down * b;
                    }
                }
            }
        }

        System.out.println(down / (gcd(up, down)));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
