package leetcode.Vol1to100;

public class LeetCode42_2 {
    public int trap(int[] height) {
        int result = 0;
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int preMax = 0;
        int sufMax = 0;
        while (leftPtr < rightPtr) {
            preMax = Math.max(height[leftPtr], preMax);
            sufMax = Math.max(height[rightPtr], sufMax);
            if (preMax >= sufMax) {
                result = result + (sufMax - height[rightPtr]);
                rightPtr--;
            } else if (preMax < sufMax) {
                result = result + (preMax - height[leftPtr]);
                leftPtr++;
            }
        }
        return result;
    }
}
