package projecteuler;

public class Problem36 {
    private static int MAX_N = 1000007;

    public static void main(String[] args) {
        int result = 0;
        for (int i = 1; i <= MAX_N; i++) {
            if (isPalindromicNumber(i)) {
                System.out.println(i);
                result += i;
            }
        }

        System.out.println(result);
    }

    private static boolean isPalindromicNumber(int num) {
        String baseTen = String.valueOf(num);
        String reBaseTen = new StringBuilder(baseTen).reverse().toString();
        if (!baseTen.equals(reBaseTen)) {
            return false;
        }

        String baseTwo = Integer.toBinaryString(num);
        String reBaseTwo = new StringBuilder(baseTwo).reverse().toString();

        return baseTwo.equals(reBaseTwo);
    }
}
