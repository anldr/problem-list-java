package acwing.Vol1to100;

public class AcWing56 {
    public int numberOf1Between1AndN_Solution(int n) {
        return countNumber(n, 1);
    }

    private int countNumber(int n , int x) {
        int copyN = n;
        int powTen = 1;
        int result = 0;
        while (copyN > 0) {
            int left = copyN / 10;
            int curNum = copyN % 10;
            copyN = left;

            if (x == 0) {
                left--;
            }
            if (curNum > x) {
                left++;
            }

            result = result + left * powTen;
            if (curNum == x) {
                result = result + n % powTen + 1;
            }
            powTen = powTen * 10;
        }
        return result;
    }
}
