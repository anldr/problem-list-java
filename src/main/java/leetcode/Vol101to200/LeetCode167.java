package leetcode.Vol101to200;

public class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int leftPtr = 0;
        int rightPtr = numbers.length - 1;

        while (leftPtr < rightPtr) {
            if (numbers[leftPtr] + numbers[rightPtr] > target) {
                rightPtr--;
            } else if (numbers[leftPtr] + numbers[rightPtr] < target) {
                leftPtr++;
            } else {
                result[0] = leftPtr + 1;
                result[1] = rightPtr + 1;
                break;
            }
        }

        return result;
    }
}
