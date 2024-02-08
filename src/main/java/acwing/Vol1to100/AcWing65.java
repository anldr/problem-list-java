package acwing.Vol1to100;

public class AcWing65 {
    private static int MAX_N = 0;

    private static int reuslt = 0;

    public int inversePairs(int[] nums) {
        MAX_N = nums.length;
        reuslt = 0;
        mergeSort(nums, 0, nums.length - 1);

        return reuslt;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return ;
        }

        int mid = (l + r) >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int[] tmp = new int[MAX_N];
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i];
                i++;
            } else {
                tmp[k++] = nums[j];
                j++;
                reuslt = reuslt + (mid - i + 1);
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i];
            i++;
        }
        while (j <= r) {
            tmp[k++] = nums[j];
            j++;
        }

        for (k = 0, i = l; i <= r; i++, k++) {
            nums[i] = tmp[k];
        }
    }
}
