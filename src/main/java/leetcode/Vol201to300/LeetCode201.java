package leetcode.Vol201to300;

public class LeetCode201 {
    public int rangeBitwiseAnd(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }

        return right;
    }
}
